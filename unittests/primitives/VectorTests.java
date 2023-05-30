package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The VectorTests class is responsible for testing the Vector class.
 */
class VectorTests {
    // Initialize vectors for testing purposes
    Vector v111 = new Vector(1.0, 1.0, 1.0);
    Vector v123 = new Vector(1.0, 2.0, 3.0);

    /**
     * The VectorTests constructor.
     */
    VectorTests() {
    }

    /**
     * The testAdd method tests the Vector add method.
     * It tests whether the method correctly adds two vectors, and whether adding a vector to its negative counterpart throws an exception.
     */
    @Test
    public void testAdd() {
        // ============ Equivalence Partitions Tests ==============
        //  TC01: Simple test
        assertEquals(this.v111, (new Vector(2.0, 3.0, 4.0)).add(new Vector(-1.0, -2.0, -3.0)), "Wrong vector add");

        // =============== Boundary Values Tests ==================
        //  TC10: test adding v + (-v)
        assertThrows(IllegalArgumentException.class, () -> {
            this.v123.add(new Vector(-1.0, -2.0, -3.0));
        }, "Add v plus -v must throw exception");
    }

    /**
     * The testSubtract method tests the Vector subtract method.
     * It tests whether the method correctly subtracts two vectors, and whether subtracting a vector from itself throws an exception.
     */
    @Test
    public void testSubtract() {
        // ============ Equivalence Partitions Tests ==============
        //TC01: simple test
        assertEquals(this.v111, (new Vector(2.0, 3.0, 4.0)).subtract(this.v123), "Wrong vector subtract");

        // =============== Boundary Values Tests ==================
        // TC10:test subtracting same vector
        assertThrows(IllegalArgumentException.class, () -> {
            this.v123.subtract(this.v123);
        }, "Subtract v from v must throw exception");
    }

    /**
     * The testPointSubtract method tests the Point subtract method of the Vector class.
     * It tests whether the method correctly subtracts a vector from a point, and whether subtracting a point from itself throws an exception.
     */
    @Test
    public void testPointSubtract() {
        // ============ Equivalence Partitions Tests ==============
        //TC01:Simple test
        assertEquals(this.v111, (new Point(2.0, 3.0, 4.0)).subtract(this.v123), "Wrong point subtract");

        // =============== Boundary Values Tests ==================
        // TC10:Subtract P from P
        assertThrows(IllegalArgumentException.class, () -> {
            this.v123.subtract(this.v123);
        }, "Subtract P from P must throw exception");
    }


    /**
     * Test method for {@link primitives.Vector#scale(double)}.
     * The testScale method tests the Vector scale method.
     * It tests whether the method correctly scales a vector, and whether scaling by 0 throws an exception.
     */
    @Test
    public void testScale() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: simple test
        assertEquals(new Vector(2.0, 4.0, 6.0), this.v123.scale(2.0), "Wrong vector scale");

        // =============== Boundary Values Tests ==================
        // TC10: test scale by 0
        assertThrows(IllegalArgumentException.class, () -> {
            this.v123.scale(0.0);
        }, "Scale by 0 must throw exception");
    }


    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     * Tests the dotProduct() method of the Vector class.
     * Creates a Vector v2 and asserts that the dot product between v123 and v2 is equal to -28.0 with a delta of 1.0E-5.
     * Creates a Vector v3 and asserts that the dot product between v123 and v3 is equal to 0.0 with a delta of 1.0E-5.
     *
     * @see Vector#dotProduct(Vector)
     */
    @Test
    public void testDotProduct() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple dotProduct test
        Vector v2 = new Vector(-2.0, -4.0, -6.0);
        assertEquals(-28.0, this.v123.dotProduct(v2), 1.0E-5, "dotProduct() wrong value");

        // =============== Boundary Values Tests ==================
        // TC10: dotProduct for orthogonal vectors
        Vector v3 = new Vector(0.0, 3.0, -2.0);
        assertEquals(0.0, this.v123.dotProduct(v3), 1.0E-5, "dotProduct() for orthogonal vectors is not zero");
    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     * Tests the crossProduct() method of the Vector class.
     * Creates a Vector v2 and computes the cross product of v123 and v2, and asserts that the length of the result is
     * equal to the product of the lengths of v123 and v2 with a delta of 1.0E-5.
     * Also asserts that the result of the cross product is orthogonal to both v123 and v2.
     * Finally, creates a Vector v3 that is parallel to v123 and asserts that computing the cross product of v123 and v3
     * throws an IllegalArgumentException.
     *
     * @see Vector#crossProduct(Vector)
     */
    @Test
    public void testCrossProduct() {
        // ============ Equivalence Partitions Tests ==============
        // TC01:Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        Vector v2 = new Vector(0.0, 3.0, -2.0);
        Vector vr = this.v123.crossProduct(v2);
        assertEquals(this.v123.length() * v2.length(), vr.length(), 1.0E-5, "crossProduct() wrong result length");
        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(Util.isZero(vr.dotProduct(this.v123)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(Util.isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC10: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2.0, -4.0, -6.0);
        assertThrows(IllegalArgumentException.class, () -> {
            this.v123.crossProduct(v3);
        }, "crossProduct() for parallel vectors does not throw an exception");
    }

    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     * Tests the lengthSquared() method of the Vector class.
     * Asserts that the length squared of v123 is equal to 14.0 with a delta of 1.0E-5.
     *
     * @see Vector#lengthSquared()
     */
    @Test
    public void testLengthSquared() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertEquals(14.0, this.v123.lengthSquared(), 1.0E-5, "lengthSquared() wrong value");
    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     * Tests the length() method of the Vector class.
     * Creates a Vector v and asserts that its length is equal to 5.0 with a delta of 1.0E-5.
     *
     * @see Vector#length()
     */
    @Test
    public void testLength() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test
        assertEquals(5.0, (new Vector(0.0, 3.0, 4.0)).length(), 1.0E-5, "length() wrong value");
    }


    /**
     * Test method for {@link primitives.Vector#normalize()}.
     * Test method for the normalize function of Vector class.
     * <p>
     * It creates a new vector instance, normalizes it and checks whether the resulting vector
     * <p>
     * has a unit length and the expected direction.
     *
     * @see Vector#normalize
     */
    @Test
    public void testNormalize() {
// Create a new vector with components (0.0, 3.0, 4.0)
        Vector v = new Vector(0.0, 3.0, 4.0);

// Normalize the vector
        Vector n = v.normalize();

        // ============ Equivalence Partitions Tests ==============
        // TC01: Simple test

// Check if the length of the normalized vector is unit
        assertEquals(1.0, n.lengthSquared(), 1.0E-5, "wrong normalized vector length");

// Check if the direction of the normalized vector is as expected
        assertEquals(new Vector(0.0, 0.6, 0.8), n, "wrong normalized vector");
    }
}