package geometries;
import primitives.*;


/**
 * An abstract class that represents all the geometries
 * emission - the glowing color of the geometry
 * */
public abstract class Geometry extends Intersectable{

    protected Color emission = Color.BLACK;

    /**
     * returns glowing color of the geometry
     * @return emission
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * set the emission for the Geometry
     * @return the Geometry object
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /** Calculates the normal (vertical) vector of a geometry starting at the point that was received
     * @param p is a point on the geometry
     * @return normal vertical
     */
    public abstract Vector getNormal(Point p);
}

