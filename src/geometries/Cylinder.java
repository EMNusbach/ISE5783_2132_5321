package geometries;
import primitives.Ray;
import primitives.Point;
import primitives.Vector;

/** Cylinder class is a polygon represented by a radius, Ray and height*/
public class Cylinder extends Tube{

    //** Height of the Cylinder*/
    private final double height;

    /** getting the height of the Cylinder
     * @return height of Cylinder
     */
    public double getHeight() {
        return height;
    }

    /** Constructor to initialize Cylinder based object with the same Cylinder values
     * @param radius of Cylinder
     * @param axisRay of Cylinder
     * @param height of Cylinder
     */
    public Cylinder(double radius, Ray axisRay, double height) {
        super(radius, axisRay);
        this.height = height;
    }

    @Override
    public Vector getNormal(Point o){
        return null;}
}
