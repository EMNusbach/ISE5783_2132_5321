package primitives;

import java.util.Objects;

/** This class will serve all primitive classes based on Ray */
public class Ray {
    /** Starting point of the ray */
    private final Point p0;
    /** Direction of the ary*/
    private final Vector dir;

    /** getting the point
     * @return the value of point
     */
    public Point getP0() {
        return p0;
    }

    /** getting the vector
     * @return the value of point
     */
    public Vector getDir() {
        return dir;
    }

    /** Constructor to initialize Ray based object with the same Ray values
     * @param p0 value for starting point
     * @param dir value for vectors direction
     */
    Ray(Point p0, Vector dir){
        this.p0 = p0;
        this.dir = dir.normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray ray)) return false;
        return this.p0.equals(ray.p0) && this.dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getP0(), getDir());
    }

    @Override
    public String toString() {
        return "p0= " + p0 +
                ", dir= " + dir;
    }
}
