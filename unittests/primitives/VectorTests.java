package primitives;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTests {
    Vector v111 = new Vector(1.0, 1.0, 1.0);
    Vector v123 = new Vector(1.0, 2.0, 3.0);

    VectorTests() {
    }

    @Test
    public void testAdd() {
        Assertions.assertEquals(this.v111, (new Vector(2.0, 3.0, 4.0)).add(new Vector(-1.0, -2.0, -3.0)), "Wrong vector add");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.v123.add(new Vector(-1.0, -2.0, -3.0));
        }, "Add v plus -v must throw exception");
    }

    @Test
    public void testSubtract() {
        Assertions.assertEquals(this.v111, (new Vector(2.0, 3.0, 4.0)).subtract(this.v123), "Wrong vector subtract");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.v123.subtract(this.v123);
        }, "Subtract v from v must throw exception");
    }

    @Test
    public void testPointSubtract() {
        Assertions.assertEquals(this.v111, (new Point(2.0, 3.0, 4.0)).subtract(this.v123), "Wrong point subtract");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.v123.subtract(this.v123);
        }, "Subtract P from P must throw exception");
    }

    @Test
    public void testScale() {
        Assertions.assertEquals(new Vector(2.0, 4.0, 6.0), this.v123.scale(2.0), "Wrong vector scale");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.v123.scale(0.0);
        }, "Scale by 0 must throw exception");
    }

    @Test
    public void testDotProduct() {
        Vector v2 = new Vector(-2.0, -4.0, -6.0);
        Assertions.assertEquals(-28.0, this.v123.dotProduct(v2), 1.0E-5, "dotProduct() wrong value");
        Vector v3 = new Vector(0.0, 3.0, -2.0);
        Assertions.assertEquals(0.0, this.v123.dotProduct(v3), 1.0E-5, "dotProduct() for orthogonal vectors is not zero");
    }

    @Test
    public void testCrossProduct() {
        Vector v2 = new Vector(0.0, 3.0, -2.0);
        Vector vr = this.v123.crossProduct(v2);
        Assertions.assertEquals(this.v123.length() * v2.length(), vr.length(), 1.0E-5, "crossProduct() wrong result length");
        Assertions.assertTrue(Util.isZero(vr.dotProduct(this.v123)), "crossProduct() result is not orthogonal to 1st operand");
        Assertions.assertTrue(Util.isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 2nd operand");
        Vector v3 = new Vector(-2.0, -4.0, -6.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.v123.crossProduct(v3);
        }, "crossProduct() for parallel vectors does not throw an exception");
    }

    @Test
    public void testLengthSquared() {
        Assertions.assertEquals(14.0, this.v123.lengthSquared(), 1.0E-5, "lengthSquared() wrong value");
    }

    @Test
    public void testLength() {
        Assertions.assertEquals(5.0, (new Vector(0.0, 3.0, 4.0)).length(), 1.0E-5, "length() wrong value");
    }

    @Test
    public void testNormalize() {
        Vector v = new Vector(0.0, 3.0, 4.0);
        Vector n = v.normalize();
        Assertions.assertEquals(1.0, n.lengthSquared(), 1.0E-5, "wrong normalized vector length");
        Assertions.assertEquals(new Vector(0.0, 0.6, 0.8), n, "wrong normalized vector");
    }
}