package geometries;
import primitives.Point;
import primitives.Vector;

/** sphere class is a polygon represented by a point and a radius*/
public class Sphere extends RadialGeometry{
    /** A point that represents the center of the sphere*/
    private final  Point center;


    /** Constructor to initialize Sphere based object with the same Sphere values
     * @param radius the radius of the sphere
     * @param center the center of the sphere
     */
    public Sphere(double radius, Point center) {
        super(radius);
        this.center = center;
    }

    /** getting the center of the sphere
     * @return the center of sphere
     */
    public Point getCenter() {
        return center;
    }

    public Vector getNormal(Point p1){return null;}
}

