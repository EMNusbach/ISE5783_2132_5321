package renderer;

import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.Scene;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**

 * @Param DELTA - a const parameter for ray-head offset size for shading rays.
 * @Param MAX_CALC_COLOR_LEVEL - max color of transparencies or reflections.
 * @Param MIN_CALC_COLOR_K - min color of transparencies or reflections.
 * Rey tracer
 * calculate the color ray-geometry intersection
 */
public class RayTracerBasic extends RayTracerBase {

    private static final double DELTA = 0.1;
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;
    private static final Double3 INITIAL_K = Double3.ONE;



    /**
     * ctor - initializing the scene parameter
     * uses super ctor
     *
     * @param scene
     */
    public RayTracerBasic(Scene scene) {
        super(scene);
    }


//    /**
//     * According to the pong model
//     * This model is additive in which we connect all the components that will eventually
//     * make up an image with background colors, self-colors and texture colors.
//     *
//     * @param geoPoint the geometry and the lighted point at him
//     * @param ray      the ray that goes out of the camera
//     * @return the color at the point
//     */
//    private Color calcColor(GeoPoint geoPoint, Ray ray) {
//        if (geoPoint == null) {
//            return scene.background;
//        }
//        return scene.ambientLight.getIntensity()
//                .add(geoPoint.geometry.getEmission())
//                .add(calcLocalEffects(geoPoint, ray))
//                .add(calcGlobalEffects(geoPoint, ray));
//    }

    private Color calcColor(GeoPoint gp, Ray ray) {
        return calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K)
                .add(scene.ambientLight.getIntensity());
    }

//    private Color calcColor(GeoPoint gp, Ray ray, int level, Double3 k) {
//        Color color = calcLocalEffects(gp, ray,k);
//        return  1 == level? color: color.add(calcGlobalEffects(gp, ray, level, k));
//    }

    private Color calcColor(GeoPoint geoPoint, Ray ray, int level, Double3 k) {
        Color color = geoPoint.geometry.getEmission();

        Vector v = ray.getDir();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);

        // check that ray is not parallel to geometry
        double nv = alignZero(n.dotProduct(v));

        if (isZero(nv)) {
            return color;
        }
        Material material = geoPoint.geometry.getMaterial();
        color = color.add(calcLocalEffects(geoPoint, /*material,*/ ray, k));
        return 1 == level ? color : color.add(calcGlobalEffects(geoPoint, ray,level, k));
    }



    /**
     * Computer lighting effects as at a certain point on geometry
     *
     * @param intersection the geometry and the lighted point at him
     * @param ray          the ray from the camera
     * @return the total color at the point including the specular and diffusive
     */
    private Color calcLocalEffects(GeoPoint intersection, Ray ray, Double3 k) {
        Color color = Color.BLACK;
        Vector v = ray.getDir();
        Vector n = intersection.geometry.getNormal(intersection.point); //normal to point
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) //vectors orthogonal - no effect
            return color;
        Material material = intersection.geometry.getMaterial();

        for (LightSource lightSource : scene.lights) { //sum of all effects of all lights on scene
            Vector l = lightSource.getL(intersection.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sing(nv)
                Double3 ktr = transparency(intersection, lightSource,l, n );
                if (!ktr.product(k).lowerThan(MIN_CALC_COLOR_K)) {
                    Color iL = lightSource.getIntensity(intersection.point).scale(ktr);
                    color = color.add(iL.scale(calcDiffusive(material, nl)),
                            iL.scale(calcSpecular(material, n, l, v)));
                }

            }
        }
        return color;
    }

    private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, Double3 k) {
        Color color = Color.BLACK;
        Material mat = intersection.geometry.getMaterial();
        Double3 kr = mat.getkR(), kkr = k.product(kr);

        Vector v = ray.getDir();
        Vector n = intersection.geometry.getNormal(intersection.point); //normal to point

        Ray reflectedRay = constructReflectedRay(intersection.point, v, n);
        GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
        if (!mat.getkR().lowerThan(MIN_CALC_COLOR_K))
            color = color.add(calcColor(reflectedPoint ,  reflectedRay, level -1, kkr).scale(kr));

        Ray refractedRay = constructRefractedRay(intersection.point, v,n);
        GeoPoint refractedPoint = findClosestIntersection(refractedRay);
        Double3 kt = mat.getkR(), kkt = k.product(kt);
        if (!mat.getkR().lowerThan(MIN_CALC_COLOR_K))
            color = color.add(calcColor(refractedPoint, refractedRay, level-1,kkt).scale(kt));

        return color;
    }


    /**
     * Calculation of specular light component
     *
     * @param material - Attenuation coefficient for specular light component
     * @param n        - normal to point
     * @param l        - direction vector from light to point
     * @param v        - direction of ray shooted to point
     * @return Color - the calculated color of specular light component
     */
    private Double3 calcSpecular(Material material, Vector n, Vector l, Vector v) {
        Vector r = l.subtract(n.scale(2 * l.dotProduct(n))).normalize();
        return material.kS.scale(Math.pow(Math.max(0, v.scale(-1).dotProduct(r)), material.nShininess));
    }

    /**
     * Calculation of diffusion light component
     *
     * @param material - normal to point
     * @param nl       - dot product between n-normal to point and l-direction vector from light to point
     * @return Color - the calculated color of diffusion light component
     */
    private Double3 calcDiffusive(Material material, double nl) {
        return material.kD.scale(Math.abs(nl));
    }

    /**
     * Trace the ray and calculates the color of the point that interact with the geometries of the scene
     *
     * @param ray the ray that came out of the camera
     * @return the color of the object that the ray is interact with
     */
    public Color TraceRay(Ray ray) {
        GeoPoint clossestGeoPoint = findClosestIntersection(ray);
        if (clossestGeoPoint == null)
            return scene.background;

        return calcColor(clossestGeoPoint, ray);
    }

    /**
     * Checks if a point is unshaded by other geometries with respect to a specific light source.
     *
     * @param gp          the point and its associated geometry
     * @param lightSource the light source
     * @param l           the direction vector from the light source to the point
     * @param n           the normal vector at the point
     * @return {@code true} if the point is unshaded, {@code false} otherwise
     */
    private Double3 transparency(GeoPoint gp, LightSource lightSource, Vector l, Vector n) {
        Vector lightDirection = l.scale(-1); // from point to light source
        double nl = n.dotProduct(lightDirection);

        Ray lightRay = new Ray(gp.point, lightDirection, n);

        double maxDistanceSquared = lightSource.getDistance(gp.point) * lightSource.getDistance(gp.point);
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
        if (intersections == null) {
            return Double3.ONE;
        }
        Double3 ktr = Double3.ONE;


        for (GeoPoint geoPoint : intersections) {
            double distance = geoPoint.point.distanceSquared(gp.point);
            if (distance < maxDistanceSquared) {
                Double3 kT = geoPoint.geometry.getMaterial().getkT();
                ktr = ktr.add(ktr.product(kT));
                return Double3.ZERO;

            }
        }

        return ktr;
    }

    private Ray constructReflectedRay(Point pointGeo, Vector v, Vector n) {
        double vn = v.dotProduct(n);

        if (vn == 0) {
            return null;
        }

        Vector r = v.subtract(n.scale(2 * vn));
        return new Ray(pointGeo, n, r);
    }

    private Ray constructRefractedRay(Point point, Vector v, Vector n) {
        return new Ray(point, n, v);
    }

    private GeoPoint findClosestIntersection(Ray ray){
        List<GeoPoint> intersection = scene.geometries.findGeoIntersections(ray);
        if (intersection ==null)
            return null;
        return ray.findClosestGeoPoint(intersection);
    }


}