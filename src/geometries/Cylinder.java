package geometries;
import primitives.Ray;
import primitives.Point;
import primitives.Vector;

import static primitives.Util.*;

/**

 The Cylinder class represents a three-dimensional cylinder object
 which extends the Tube class.
 */
public class Cylinder extends Tube {

    //** Height of the Cylinder*/
    private final double height;

    /**
     Returns the height of the Cylinder.
     @return the height of the Cylinder
     */
    public double getHeight() {
        return height;
    }

    /**
     Constructs a new Cylinder object with the specified radius,
     axisRay, and height values.
     @param radius the radius of the Cylinder
     @param axisRay the axisRay of the Cylinder
     @param height the height of the Cylinder
     */
    public Cylinder(double radius, Ray axisRay, double height) {
        super(radius, axisRay);
        this.height = height;
    }

    @Override
    /**
     * @author:Maayan
     Returns the normal Vector of a point on the Cylinder surface.
     @param point the point to find the normal Vector for
     @return the normal Vector of the point on the Cylinder surface
     */
    /**
     * Computes the normal vector to this cylinder at the given point.
     *
     * @param p The point on the surface of the cylinder.
     * @return The normal vector to the cylinder at the given point.
     */
    public Vector getNormal(Point p) {
        // Get the starting point of the axis ray and the direction vector of the axis ray.
        Point p0 = axisRay.getP0();
        Vector v = axisRay.getDir();

        // If the given point is the same as the starting point of the axis ray, return the direction vector of the axis ray.
        if (p.equals(p0))
            return v;

        // Compute the projection of the vector from the starting point of the axis ray to the given point onto the axis ray.
        Vector P_P0 = p.subtract(p0);

        // Compute the distance from the starting point of the axis ray to the intersection point
        // between the axis ray and the line perpendicular to the cylinder passing through the given point.
        double t = P_P0.dotProduct(v);


       // in case the given point is on either of the upper or the lower bases of the cylinder.
        // returns the normal to one of the bases of the cylinder
        if (t == 0 || isZero(height - t))
            return v;


        //computes the point that is on the axis ray parallel to the point p
        Point o = p0.add(v.scale(t));

        // returns the normal that is orthogonal to the side of the cylinder
        return p.subtract(o).normalize();
    }



}
