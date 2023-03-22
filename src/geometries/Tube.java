package geometries;
import primitives.Ray;
import primitives.Point;
import primitives.Vector;

/** Tube class is a polygon represented by a radius and a ray*/
public class Tube extends RadialGeometry {

    /** The axis ray of the Tube */
    protected final Ray axisRay;

    /** getting the axis ray of the Tube
     * @return axisRay
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    /** Constructor to initialize Tube based object with the same values of Tube
     * @param radius of the Tube
     * @param axisRay of the Tube
     */
    public Tube(double radius, Ray axisRay) {
        super(radius);
        this.axisRay = axisRay;
    }

    public Vector getNormal(Point p){
        return null;
    }

}

