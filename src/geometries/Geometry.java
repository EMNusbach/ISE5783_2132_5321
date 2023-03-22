package geometries;
import primitives.Vector;
import primitives.Point;

/** An interface that represents all the geometries*/
public interface Geometry {

    /** Calculates the normal (vertical) vector of a geometry starting at the point that was received
     * @param p is a point on the geometry
     * @return normal vertical
     */
    public Vector getNormal(Point p);
}

