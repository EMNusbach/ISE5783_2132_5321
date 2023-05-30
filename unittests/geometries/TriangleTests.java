package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * A class for testing the Triangle class.
 */
class TriangleTests {


    /**
     * Test method for {@link geometries.Triangle#getNormal(Point)}.
     * Tests the getNormal method of the Triangle class.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // Create a vector with equal components
        double sqrt3 = Math.sqrt(1d / 3);
        Vector n = new Vector(sqrt3, sqrt3, sqrt3);

        // Create a new triangle and check its normal
        Triangle triangle = new Triangle(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        Point point = new Point(1, 0, 0);
        //TC01: simple test
        assertEquals(n, triangle.getNormal(point), "Triangle's normal is not correct");
    }

    /**
     * Test method for {@link geometries.Triangle#findIntersections(Ray)}
     */
    @Test
    void testFindIntsersections() {
        Triangle triangle = new Triangle(new Point(0, 0, 3), new Point(-2, 0, 0), new Point(0, -3, 0));
        // ============ Equivalence Partitions Tests ==============
        //TC01: Ray's line out of triangle
        assertNull(triangle.findIntersections(new Ray(new Point(-5, 1, 0)
                        , new Vector(1, 2, 0)))
                , "Ray's line out of triangle");

        //TC02: Ray's line inside triangle
        Triangle triangle2 = new Triangle(new Point(0, 0, 3), new Point(-2, 0, 0), new Point(0, 0, 0));
        assertEquals(List.of(new Point(-1, 0, 1)), triangle2.findIntersections(new Ray(new Point(-1, -3, 0)
                        , new Vector(0, 3, 1)))
                , "Ray's line inside triangle");

        //TC03: Ray's line the two continuations of sides
        assertNull(triangle2.findIntersections(new Ray(new Point(-1, -3, 0)
                        , new Vector(2, -1, 1)))
                , "Ray's line the two continuations of sides");

        // =============== Boundary Values Tests ==================
        //TC11:Ray's line on the vertices
        assertNull(triangle.findIntersections(new Ray(new Point(-5, 1, 0)
                        , new Vector(3, -1, 0)))
                , "Ray's line on the vertices");

        //TC12:Ray's line on the side of the triangle
        assertNull(triangle.findIntersections(new Ray(new Point(-5, 1, 0)
                        , new Vector(1, 2, 0)))
                , "Ray's line on the continuation of a side of the triangle");


    }
}