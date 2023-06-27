package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * sphere class is a geometric shape represented by a point and a radius
 */
public class Sphere extends RadialGeometry {
    /**
     * A point that represents the center of the sphere
     */
    private final Point center;


    /**
     * Constructor to initialize Sphere based object with the same Sphere values
     *
     * @param radius the radius of the sphere
     * @param center the center of the sphere
     */
    public Sphere(Point center, double radius) {
        super(radius);
        this.center = center;
    }

    /**
     * getting the center of the sphere
     *
     * @return the center of sphere
     */
    public Point getCenter() {

        return center;
    }

    @Override
    public Vector getNormal(Point p1) {

        return p1.subtract(center).normalize();
    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {

        // p0 = center , returns 1 point
        if (ray.getP0().equals(center))
            return List.of(new GeoPoint(this, center.add(ray.getDir().scale(radius))));

        Vector u = center.subtract(ray.getP0());
        double tm = alignZero(ray.getDir().dotProduct(u));

        double d_squared = alignZero((u.lengthSquared() - tm * tm));
        double rr = radius * radius;

        // there are no intersections
        if (d_squared >= (rr))
            return null;

        double th = alignZero((Math.sqrt(rr - d_squared)));
        double t1 = alignZero(tm + th);
        double t2 = alignZero(tm - th);

        // both are in same direction of sphere
        if (t1 > 0 && t2 > 0) {
            //  Point p1 = ray.getP0().add(ray.getDir().scale(t1));
            //Point p2 = ray.getP0().add(ray.getDir().scale(t2));

            return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));
        }

        if (t1 > 0) {
            //  Point p1 = ray.getP0().add(ray.getDir().scale(t1));
            return List.of(new GeoPoint(this, ray.getPoint(t1)));
        }

        if (t2 > 0) {
            // Point p2 = ray.getP0().add(ray.getDir().scale(t2));
            return List.of(new GeoPoint(this, ray.getPoint(t2)));
        }
        return null;
    }


}

