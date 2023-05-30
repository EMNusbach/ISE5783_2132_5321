package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;


/**
 * An abstract class that represents all the geometries
 * emission - the glowing color of the geometry
 */
public abstract class Geometry extends Intersectable {
    protected Color emission = Color.BLACK;
    private Material material = new Material();

    /**
     * returns glowing color of the geometry
     *
     * @return emission
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * set the emission for the Geometry
     *
     * @return the Geometry object
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * getter of material
     *
     * @return material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * setter of material
     *
     * @param material
     * @return material
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }

    /**
     * Calculates the normal (vertical) vector of a geometry starting at the point that was received
     *
     * @param p is a point on the geometry
     * @return normal vertical
     */
    public abstract Vector getNormal(Point p);
}

