package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.*;

/**
 * plane class is a polygon represented by a point and a vector
 */
public class Plane implements Geometry {
    /**
     * A point that is on the plane
     */
    private final Point q0;

    /**
     * A vector that is vertical to the plane
     */
    private final Vector normal;

    /**
     * Constructor to initialize plane based object by three points that are on the plane
     * Representing the plane according to a point and normal.
     * @param p1 first points that is on the plane
     * @param p2 second points that is on the plane
     * @param p3 third points that is on the plane
     */
    Plane(Point p1, Point p2, Point p3) {
        this.q0 = p1;
        if( p1.equals(p2) || p1.equals(p3) || p2.equals(p3))
            throw new IllegalArgumentException("Two of the points are identical");

        Vector v1= p1.subtract(p2); // vector from p2 towards p1
        Vector v2 = p2.subtract(p3); // vector from p3 towards p2

        if( v1.normalize().equals(v2.normalize()))
            throw new IllegalArgumentException("The points form a vector and not a plane");
        this.normal = v1.crossProduct(v2).normalize(); // creating a normal by normalized vector multiplication
    }

    /**
     * Constructor to initialize Plane based object with the same plane values
     *
     * @param p A point that is on the plane
     * @param vector A vector that is vertical to the plane
     */
    Plane(Point p, Vector vector) {
        this.q0 = p;
        this.normal = vector.normalize();
    }

    /**
     * getting the point that is on the plane
     *
     * @return the point
     */
    public Point getQ0() {
        return q0;
    }

    /**
     * getting vector that is vertical to the plane
     *
     * @return the vector
     */
    public Vector getNormal() {
        return normal;
    }

    @Override
    public Vector getNormal(Point p) {
        /**
         * we don't use the following for performance reasons
         * return getNormal();
         */
        return normal;
    }

    public List<Point> findIntersections(Ray ray){

        // q0=p0 = starting point of the ray
        if(q0.equals(ray.getP0()))
            return null;

       // Calculating the numerator.
       Vector p0_q0 = q0.subtract(ray.getP0());
       double numerator= alignZero( normal.dotProduct(p0_q0));

       // In case that the plane contains the ray or is parallel to it.
       if(isZero(numerator))
          return null;

       // Calculating the denominator
        double denominator = alignZero(normal.dotProduct(ray.getDir()));

        // In case that the plane is parallel to it.
        if(isZero(denominator))
            return null;

        double t =alignZero(numerator / denominator);

        // The ray is pointing away from the plane.
        if (t<=0)
            return null;

        Vector tv = ray.getDir().scale(t);
        Point p= ray.getP0().add(tv);

        return List.of(p);
    }


}

