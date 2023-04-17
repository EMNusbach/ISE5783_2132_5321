package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;


import static org.junit.jupiter.api.Assertions.*;

class SphereTests {

    @Test
    void testGetNormal() {
        Sphere s = new Sphere( new Point(0,0,0),1d);
        assertEquals(new Vector(1,0,0), s.getNormal(new Point(2,0,0)), "wrong normalized vector");
    }
}