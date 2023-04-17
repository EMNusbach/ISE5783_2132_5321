package primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTests {
    Point p = new Point(1.0, 1.0, 1.0);

    PointTests() {
    }

    /**
     *
     */
    @Test
    void testAdd() {
        Assertions.assertEquals(new Point(2.0, 3.0, 4.0), this.p.add(new Vector(1.0, 2.0, 3.0)), "Wrong point add");

    }

    @Test
    void testSubtract() {
        Assertions.assertEquals(this.p, (new Point(2.0, 3.0, 4.0)).subtract(new Point(1.0, 2.0, 3.0)), "Wrong point subtract");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.p.subtract(this.p);
        }, "Subtract P from P must throw exception");
    }

    @Test
    void testDistanceSquared() {
        Assertions.assertEquals(14.0, this.p.distanceSquared(new Point(2.0, 3.0, 4.0)), 1.0E-4, "Wrong squared distance between the point and itself");
        Assertions.assertEquals(0.0, (new Point(1.0, 2.0, 3.0)).distanceSquared(new Point(1.0, 2.0, 3.0)), 1.0E-4, "Wrong squared distance between the point and itself");
    }

    @Test
    void testDistance() {
        Assertions.assertEquals(Math.sqrt(14.0), this.p.distance(new Point(2.0, 3.0, 4.0)), 1.0E-4, "Wrong distance between the point and itself");
        Assertions.assertEquals(0.0, (new Point(1.0, 2.0, 3.0)).distance(new Point(1.0, 2.0, 3.0)), 1.0E-4, "Wrong distance between the point and itself");
    }
}