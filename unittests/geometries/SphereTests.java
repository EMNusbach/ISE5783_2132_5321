package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;


import static org.junit.jupiter.api.Assertions.*;

/**

 The SphereTests class is used to test the methods of the Sphere class.
 */
class SphereTests {

    /**
     * Test method for {@link geometries.Sphere#getNormal(Point)}.
     * Tests the getNormal method of the Sphere class.
     *      A new Sphere object is created with center (0,0,0) and radius 1.
     *      The getNormal method is called with a Point object with coordinates (2,0,0).
     *      The method should return a normalized Vector object with coordinates (1,0,0).
     *      If the method returns a Vector object with different coordinates, the test will fail.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        Sphere s = new Sphere(new Point(0,0,0), 1d);
        //TC01: simple test
        assertEquals(new Vector(1,0,0), s.getNormal(new Point(2,0,0)), "wrong normalized vector");
    }

    @Test
    void testFindIntsersections() {
    }
}