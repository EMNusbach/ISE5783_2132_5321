package geometries;
import primitives.Point;
import primitives.Vector;

/** plane class is a polygon represented by a point and a vector*/
public class Plane implements Geometry{
    /** A point that is on the plane */
    private final Point q0;

    /** A vector that is vertical to the plane*/
    private final Vector normal;

    /** Constructor to initialize plane based object by three points that are on the plane
     * @param p1 first points that is on the plane
     * @param p2 second points that is on the plane
     * @param p3 third points that is on the plane
     */
    Plane(Point p1, Point p2, Point p3){
        this.q0 = p1;
        this.normal = null;
    }

    /**
     * Constructor to initialize Plane based object with the same plane values
     * @param p A point that is on the plane
     * @param v A vector that is vertical to the plane
     */
    Plane(Point p, Vector v){
        this.q0=p;
        this.normal = v.normalize();
    }

    /** getting the point that is on the plane
     * @return the point
     */
    public Point getQ0() {
        return q0;
    }

    /** getting vector that is vertical to the plane
     * @return the vector
     */
    public Vector getNormal() {
        return normal;
    }

    public Vector getNormal(Point p){
        return null;
    }

}

