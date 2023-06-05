package renderer;

import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.Scene;

import java.util.List;
import static primitives.Util.*;

/**
 * The RayTracerBasic class represents a basic ray tracer that calculates the color
 * of ray-geometry intersections in a scene.
 */
public class RayTracerBasic extends RayTracerBase {

    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;
    private static final Double3 INITIAL_K = Double3.ONE;

    /**
     * Constructs a RayTracerBasic object with the given scene.
     *
     * @param scene the scene to be rendered
     */
    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    /**
     * Calculates the color of the intersection point between a ray and geometry.
     *
     * @param gp  the intersection point between the ray and geometry
     * @param ray the ray
     * @return the color at the intersection point
     */
    private Color calcColor(GeoPoint gp, Ray ray) {
        return calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K)
                .add(scene.ambientLight.getIntensity());
    }

    /**
     * Calculates the color at the intersection point recursively, taking into account
     * the level of reflections or transparencies.
     *
     * @param geoPoint the intersection point between the ray and geometry
     * @param ray      the ray
     * @param level    the current level of reflections or transparencies
     * @param k        the accumulation factor for transparency or reflection
     * @return the color at the intersection point
     */
    private Color calcColor(GeoPoint geoPoint, Ray ray, int level, Double3 k) {
        Color color = geoPoint.geometry.getEmission();
        Vector v = ray.getDir();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);

        // Check if the ray is parallel to the geometry
        double nv = alignZero(n.dotProduct(v));
        if (isZero(nv)) {
            return color;
        }

        Material material = geoPoint.geometry.getMaterial();
        color = color.add(calcLocalEffects(geoPoint, ray, k));

        // Recursive calculation of global effects (reflections and refractions)
        return (level == 1) ? color :
                color.add(calcGlobalEffects(geoPoint, ray, level, k));
    }


    /**
     * Computer lighting effects at a certain point on geometry.
     *
     * @param intersection the geometry and the point being illuminated
     * @param ray          the ray from the camera
     * @return the total color at the point including the specular and diffusive components
     */
    private Color calcLocalEffects(GeoPoint intersection, Ray ray, Double3 k) {
        Color color = Color.BLACK;
        Vector v = ray.getDir();
        Vector n = intersection.geometry.getNormal(intersection.point); // normal to the point
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) // vectors are orthogonal - no effect
            return color;
        Material material = intersection.geometry.getMaterial();

        for (LightSource lightSource : scene.lights) { // sum of all effects of all lights in the scene
            Vector l = lightSource.getL(intersection.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sign(nv)
                Double3 ktr = transparency(intersection, lightSource, l, n);
                if (!ktr.product(k).lowerThan(MIN_CALC_COLOR_K)) {
                    Color iL = lightSource.getIntensity(intersection.point).scale(ktr);
                    color = color.add(iL.scale(calcDiffusive(material, nl)),
                            iL.scale(calcSpecular(material, n, l, v)));
                }
            }
        }
        return color;
    }

    /**
     * Calculates the global effects of reflection and refraction on the color of a point.
     *
     * @param gp    the point and associated geometry
     * @param ray   the ray from the camera
     * @param level the recursion level
     * @param k     the coefficient of attenuation for global effects
     * @return the color affected by global effects
     */
    private Color calcGlobalEffects(GeoPoint gp, Ray ray, int level, Double3 k) {
        Color color = Color.BLACK;
        Material material = gp.geometry.getMaterial();
        Double3 kr = material.getkR();

        // in each recursive iteration, the impact of the reflection decreases
        Double3 kkr = k.product(kr);
        Vector n = gp.geometry.getNormal(gp.point);

        if (!kkr.lowerThan(MIN_CALC_COLOR_K)) {
            Ray reflectedRay = constructReflected(gp, ray);
            GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
            if (reflectedPoint == null) return color.add(scene.background);
            color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kr));
        }

        Double3 kt = material.getkT();
        Double3 kkt = k.product(kt); // in each recursive iteration, the impact of the refraction decreases

        if (!kkt.lowerThan(MIN_CALC_COLOR_K)) {
            Ray refractedRay = constructRefracted(gp, ray);
            GeoPoint refractedPoint = findClosestIntersection(refractedRay);
            if (refractedPoint == null) return color.add(scene.background);
            color = color.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kt));
        }
        return color;
    }


    /**
     * Calculates the specular light component at a given point.
     *
     * @param material - The material with the attenuation coefficient for the specular light component
     * @param n        - The normal vector at the point
     * @param l        - The direction vector from the light source to the point
     * @param v        - The direction vector of the ray shot towards the point
     * @return The calculated color of the specular light component
     */
    private Double3 calcSpecular(Material material, Vector n, Vector l, Vector v) {
        Vector r = l.subtract(n.scale(2 * l.dotProduct(n))).normalize();
        return material.kS.scale(Math.pow(Math.max(0, v.scale(-1).dotProduct(r)), material.nShininess));
    }

    /**
     * Calculates the diffuse light component at a given point.
     *
     * @param material - The material at the point
     * @param nl       - The dot product between the normal vector and the direction vector from the light source to the point
     * @return The calculated color of the diffuse light component
     */
    private Double3 calcDiffusive(Material material, double nl) {
        return material.kD.scale(Math.abs(nl));
    }

    /**
     * Traces the ray and calculates the color of the point that interacts with the geometries in the scene.
     *
     * @param ray - The ray that originates from the camera
     * @return The color of the object that the ray intersects with
     */
    public Color TraceRay(Ray ray) {
        GeoPoint closestGeoPoint = findClosestIntersection(ray);
        if (closestGeoPoint == null)
            return scene.background;

        return calcColor(closestGeoPoint, ray);
    }

    /**
     * Checks if a point is unshaded by other geometries with respect to a specific light source.
     *
     * @param geopoint - The point and its associated geometry
     * @param light    - The light source
     * @param l        - The direction vector from the light source to the point
     * @param n        - The normal vector at the point
     * @return {@code true} if the point is unshaded, {@code false} otherwise
     */
    private Double3 transparency(GeoPoint geopoint, LightSource light, Vector l, Vector n) {
        // From point to light source
        Vector lightDirection = l.scale(-1);

        // Build ray with delta
        Ray lightRay = new Ray(geopoint.point, lightDirection, n);

        double lightDistance = light.getDistance(geopoint.point);
        var intersections = scene.geometries.findGeoIntersections(lightRay);

        if (intersections == null) return Double3.ONE; // No intersections
        Double3 ktr = new Double3(1d);

        for (GeoPoint gp : intersections) {
            if (alignZero(gp.point.distance(geopoint.point) - lightDistance) <= 0) {
                ktr = ktr.product(gp.geometry.getMaterial().getkT()); // The more transparency, the less shadow
                if (ktr.lowerThan(MIN_CALC_COLOR_K)) return Double3.ZERO;
            }
        }
        return ktr;
    }


    /**
     * Constructs a reflected ray that starts from the point where the ray hits the camera and goes diagonally to the point.
     * @param geoPoint - The point where the ray hits the camera
     * @param ray      - The ray from the camera
     * @return A reflected ray
     */
    private Ray constructReflected(GeoPoint geoPoint, Ray ray) {
        Vector v = ray.getDir();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);
        double nv = alignZero(v.dotProduct(n));
        // r = v - 2(v * n) * n
        Vector r = v.subtract(n.scale(2d * nv)).normalize();

        return new Ray(geoPoint.point, r, n); // Use the constructor with the normal for moving the head a little
    }

    /**
     * Constructs a refracted ray that starts from the point where the ray hits the camera and goes in a direction similar to the original beam.
     * @return A refracted ray
     */
    private Ray constructRefracted(GeoPoint geoPoint, Ray inRay) {
        return new Ray(geoPoint.point, inRay.getDir(), geoPoint.geometry.getNormal(geoPoint.point));
    }

    /**
     * Finds the closest intersection of a ray with the geometries in the scene.
     * @param ray - The ray to intersect with the scene geometries
     * @return The closest intersection point as a GeoPoint object, or null if no intersection is found
     */
    private GeoPoint findClosestIntersection(Ray ray) {
        List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);
        if (intersections == null)
            return null;
        return ray.findClosestGeoPoint(intersections);
    }


}