package geometries;

import static primitives.Util.isZero;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Polygon class represents two-dimensional polygon in 3D Cartesian coordinate
 * system
 *
 * @author Dan
 */
public class Polygon implements Geometry {
    /**
     * List of polygon's vertices
     */
    protected final List<Point> vertices;
    /**
     * Associated plane in which the polygon lays
     */
    protected final Plane plane;
    private final int size;

    /**
     Constructs a polygon with the given vertices.
     @param vertices the vertices of the polygon
     @throws IllegalArgumentException if the number of vertices is less than 3,
     if all the vertices don't lie in the same plane, or if the polygon is not convex
     */
    public Polygon(Point... vertices) {
        if (vertices.length < 3)
            throw new IllegalArgumentException("A polygon can't have less than 3 vertices");

        this.vertices = List.of(vertices); // Store vertices as an immutable list
        size = vertices.length;

        // Generate the plane according to the first three vertices and associate the polygon with this plane.
// The plane holds the invariant normal (orthogonal unit) vector to the polygon.
        plane = new Plane(vertices[0], vertices[1], vertices[2]);
        if (size == 3) return; // If the polygon is a triangle, we're done
        Vector n = plane.getNormal();
        // Subtracting any subsequent points will throw an IllegalArgumentException
        // because of Zero Vector if they are in the same point
        Vector edge1 = vertices[vertices.length - 1].subtract(vertices[vertices.length - 2]);
        Vector edge2 = vertices[0].subtract(vertices[vertices.length - 1]);

        // Cross Product of any subsequent edges will throw an IllegalArgumentException
        // because of Zero Vector if they connect three vertices that lay in the same
        // line.
        // Generate the direction of the polygon according to the angle between last and
        // first edge being less than 180 deg. It is hold by the sign of its dot product
        // with
        // the normal. If all the rest consequent edges will generate the same sign -
        // the
        // polygon is convex ("kamur" in Hebrew).
        boolean positive = edge1.crossProduct(edge2).dotProduct(n) > 0;
        for (var i = 1; i < vertices.length; ++i) {
            // Test that the point is in the same plane as calculated originally
            if (!isZero(vertices[i].subtract(vertices[0]).dotProduct(n)))
                throw new IllegalArgumentException("All vertices of a polygon must lay in the same plane");
            // Test the consequent edges have
            edge1 = edge2;
            edge2 = vertices[i].subtract(vertices[i - 1]);
            if (positive != (edge1.crossProduct(edge2).dotProduct(n) > 0))
                throw new IllegalArgumentException("All vertices must be ordered and the polygon must be convex");
        }
    }

    @Override
    public Vector getNormal(Point point) {
        return plane.getNormal(point);
    }

    public List<Point> findIntersections(Ray ray){
        return null;
    }
}
