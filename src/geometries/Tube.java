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

    @Override
    public Vector getNormal(Point p){
        Point p0 = axisRay.getP0();
        Vector v= axisRay.getDir();
        Vector p_p0= p.subtract(p0);
        Point o;
        if(p_p0.dotProduct(v)==0) // if vector p_p0 is vertical to vector v then t is 0;
            o=p0;
        else {
            double t = v.dotProduct(p.subtract(p0));
            o = p0.add(v.scale(t));
        }
        return p.subtract(o).normalize();
    }

}

