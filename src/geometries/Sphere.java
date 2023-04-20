package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/** sphere class is a geometric shape represented by a point and a radius*/
public class Sphere extends RadialGeometry{
    /** A point that represents the center of the sphere */
    private final  Point center;


    /** Constructor to initialize Sphere based object with the same Sphere values
     * @param radius the radius of the sphere
     * @param center the center of the sphere
     */
    public Sphere(Point center,double radius) {
        super(radius);
        this.center = center;
    }

    /** getting the center of the sphere
     * @return the center of sphere
     */
    public Point getCenter() {

        return center;
    }

    @Override
    public Vector getNormal(Point p1){

        return p1.subtract(center).normalize();
    }

    public List<Point> findIntersections(Ray ray){
        return null;
    }
}

