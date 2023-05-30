package primitives;

import java.util.Objects;

/**
 * This class will serve all primitive classes based on a vector
 */
public class Vector extends Point {

    /**
     * Constructor to initialize Vector based object with its three coordinate values
     *
     * @param x first coordinate value
     * @param y second coordinate value
     * @param z third coordinate value
     */
    public Vector(double x, double y, double z) {
        this(new Double3(x, y, z));
    }

    /**
     * Constructor to initialize Vector based object with the same Vector values
     *
     * @param xyz number value for all three coordinates
     */
    Vector(Double3 xyz) {
        super(xyz);
        if (this.xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("vector can't be zero");

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector vector)) return false;
        return this.xyz.equals(vector.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xyz);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Sum two vectors into a new vector where each couple of coordinates are summarized
     *
     * @param v right handle side operand for addition
     * @return result of add
     */
    public Vector add(Vector v) {
        return new Vector(this.xyz.add(v.xyz));
    }

    /**
     * multiplies a vector by a number into a new vector where each number is multiplied by the number
     *
     * @param num right handle side operand for scaling
     * @return result of scale
     */
    public Vector scale(double num) {
        return new Vector(this.xyz.scale(num));
    }

    /**
     * multiplies a vectors with a vector where each couple of coordinates are  multiplied and summarized
     *
     * @param v right handle side operand for dotProduct
     * @return result od dotProduct
     */
    public double dotProduct(Vector v) {
        return ((this.xyz.d1 * v.xyz.d1) + (this.xyz.d2 * v.xyz.d2) + (this.xyz.d3 * v.xyz.d3));
    }

    /**
     * multiplies a vectors with a vector using the formula vector multiplication algorithm
     *
     * @param v right handle side operand for crossProduct
     * @return result od crossProduct
     */
    public Vector crossProduct(Vector v) {
        return new Vector((this.xyz.d2 * v.xyz.d3) - (this.xyz.d3 * v.xyz.d2), (this.xyz.d3 * v.xyz.d1) - (this.xyz.d1 * v.xyz.d3), (this.xyz.d1 * v.xyz.d2) - (this.xyz.d2 * v.xyz.d1));
    }

    /**
     * multiplies a vectors with itself where each couple of coordinates are  multiplied and summarized
     *
     * @return result od lengthSquared
     */
    public double lengthSquared() {
        return this.dotProduct(this);
    }

    /**
     * multiplies a vectors with itself where each couple of coordinates are multiplied and summarized,then calculating the root of the result
     *
     * @return result of length
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }


    /**
     * normalize a vector by reducing a vector with its length
     *
     * @return result of normalize
     */
    public Vector normalize() {
        return new Vector(this.xyz.reduce(this.length()));
    }

    /**
     * rotate the vectors by Rodrigues' rotation formula:
     * vRot = V * cos(theta) + (K x V) * sin(theta) + K * (K*V) * (1 - cos(theta))
     * V is this vector
     *
     * @param k        the axis vector of rotation
     * @param cosTheta cos(theta)
     * @param sinTheta sin(theta)
     */
    public void rotateVector(Vector k, double cosTheta, double sinTheta) {
        Vector vRot;
        if (cosTheta == 0d) {
            vRot = k.crossProduct(this).scale(sinTheta);
        } else {
            vRot = this.scale(cosTheta);
            if (sinTheta != 0d) {
                vRot = vRot.add(k.crossProduct(this).scale(sinTheta));
            }
        }
        xyz = vRot.normalize().xyz;
    }


}
