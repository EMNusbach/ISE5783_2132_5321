package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaneTests {


    /**
     * Test method for {@link geometries.Plane#getNormal(Point)}.
     * Tests the getNormal method of the Plane class.
     * The test creates a Vector object with the square root of 1/3 and uses it
     * to instantiate a Plane object. The getNormal method of the Plane object
     * is then called with a Point object as argument, and the resulting Vector
     * is compared with the expected value. The test fails if the two Vector
     * objects are not equal.
     *
     * @throws AssertionError if the plane's normal vector is not correct.
     */
    @Test
    void testGetNormal() {
        double sqrt3 = Math.sqrt(1d / 3);  // Create a Vector object with the square root of 1/3
        Vector n = new Vector(sqrt3, sqrt3, sqrt3);

        // ============ Equivalence Partitions Tests ==============
        //TC01: simple test
        assertEquals(n, new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1)).getNormal(new Point(1, 0, 0)), "Plane's normal is not correct");
        // Instantiate a Plane object and call the getNormal method
        // with a Point object as argument. Compare the resulting
        // Vector with the expected value
    }

    @Test
    void testFindIntsersections() {
        Plane plane = new Plane(new Point(0, 0, 1), new Point(0, 2, 0), new Point(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============
        // The Ray's here ar not orthogonal and not parallels to the plane
        // TC01: Ray intersect the plane (1 point)
        Ray ray = new Ray(new Point(0, -2, 0), new Vector(1, 4, -1));
        assertEquals(List.of(new Point(1, 2, -1)), plane.findIntersections(ray));
        //
    }
}