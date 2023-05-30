package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * Triangle class is a polygon represented by three points
 */
public class Triangle extends Polygon {

    /**
     * Constructor to initialize Triangle based object with the values of three different points
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     */
    public Triangle(Point p1, Point p2, Point p3) {

        super(p1, p2, p3);
    }


//    @Override
//    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
//
//        List<GeoPoint> intersections = plane.findGeoIntersections(ray);
//
//        if(intersections== null){
//            return null;
//        }
//        /**
//         * vectors from p0 to the vertices of the triangle
//         */
//        Vector v1 = vertices.get(0).subtract(ray.getP0());
//        Vector v2 = vertices.get(1).subtract(ray.getP0());
//        Vector v3 = vertices.get(2).subtract(ray.getP0());
//
//        /**
//         * the normals to the vectors above
//         */
//        Vector n1 = v1.crossProduct(v2).normalize();
//        Vector n2 = v2.crossProduct(v3).normalize();
//        Vector n3 = v3.crossProduct(v1).normalize();
//
//        /**
//         * checking if the intersection point is inside the triangle
//         */
//        Double vn1 = alignZero(ray.getDir().dotProduct(n1));
//        Double vn2 = alignZero(ray.getDir().dotProduct(n2));
//        Double vn3 = alignZero(ray.getDir().dotProduct(n3));
//
//        //p0 intersects the side of the triangle
//        if ((vn1 == 0) || (vn2 == 0) || (vn3 == 0))
//            return null;
//
//        // there are no intersections
//        if (!(((vn1 > 0) && (vn2 > 0) && (vn3 > 0)) || ((vn1 < 0) && (vn2 < 0) && (vn3 < 0))))
//            return null;
//        return List.of(new GeoPoint(this, intersections.get(0).point));
//    }

    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<GeoPoint> planeIntersections = plane.findGeoIntersections(ray);
        if (planeIntersections == null)
            return null;

        Point p0 = ray.getP0();
        Vector v = ray.getDir();

        Vector v1 = vertices.get(0).subtract(p0);
        Vector v2 = vertices.get(1).subtract(p0);
        Vector v3 = vertices.get(2).subtract(p0);

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(s1))
            return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(s2))
            return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(s3))
            return null;

        if ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) {
            Point point = planeIntersections.get(0).point;
            return List.of(new GeoPoint(this, point));
        }
        return null;
    }
}

