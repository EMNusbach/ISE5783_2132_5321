package geometries;
import primitives.Point;

/** Triangle class is a polygon represented by three points*/
public class Triangle extends Polygon{

    /** Constructor to initialize Triangle based object with the values of three different points
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    Triangle(Point p1, Point p2, Point p3){
        super(p1, p2, p3);
    }
}

