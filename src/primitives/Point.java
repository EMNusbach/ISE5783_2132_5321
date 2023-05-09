package primitives;

import java.util.Objects;

/** This class will serve all primitive classes based on a point  */
public class Point {

    /** A constant zero point*/
    public final static Point ZERO = new Point(0d, 0d, 0d);

    /** A point with 3 coordinates */
    protected final Double3 xyz;

    /** Constructor to initialize Point based object with its three coordinate values
     * @param x first coordinate value
     * @param y second coordinate value
     * @param z third coordinate value
     */
    public Point(double x, double y, double z){
        this (new Double3(x,y,z));
    }

    /** Constructor to initialize Point based object with the same Point values
     * @param xyz number value for all three coordinates
     */
    Point(Double3 xyz){
        this.xyz = xyz;
    }

    /**
     * @return the x coordinate
     */
    public double getX() {
        return xyz.d1;
    }

    /**
     * @return the y coordinate
     */
    public double getY() {
        return xyz.d2;
    }

    /**
     * @return the z coordinate
     */
    public double getZ() {
        return xyz.d3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return this.xyz.equals(point.xyz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xyz);
    }

    @Override
    public String toString() {
        return "xyz= " + xyz;
    }


    /** Subtract two floating point triads into a new triad where each couple of numbers is subtracted
     * @param p right handle side operand for subtraction
     * @return result of subtraction
     */
    public Vector subtract(Point p){
        return new Vector(this.xyz.subtract(p.xyz));
    }

    /** Sum two floating point triads into a new triad where each couple of numbers is summarized
     * @param v right handle side operand for addition
     * @return result of add
     */
    public Point add(Vector v){
        return new Point(this.xyz.add(v.xyz));
    }

    /** The distance between two points, squared
     * @param p right handle side operand for distance squared
     * @return result of distance squared
     */
    public double distanceSquared(Point p){
        return (((this.xyz.d1 - p.xyz.d1) * (this.xyz.d1 - p.xyz.d1)) + ((this.xyz.d2 - p.xyz.d2) * (this.xyz.d2 - p.xyz.d2)) + ((this.xyz.d3 - p.xyz.d3) * (this.xyz.d3 - p.xyz.d3)));
    }

    /** The distance between two points
     * @param p right handle side operand for distance
     * @return result of distance
     */
    public double distance(Point p){
        return Math.sqrt(this.distanceSquared(p));
    }

}

