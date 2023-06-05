package primitives;

/**
 * This class represents the material properties and texture of a geometry object.
 * Multiple geometries can share the same material.
 */
public class Material {
    public Double3 kD = Double3.ZERO;
    public Double3 kS = Double3.ZERO;
    public Double3 kT = Double3.ZERO;
    public Double3 kR = Double3.ZERO;
    public int nShininess = 0;

    //region Getters

    /**
     * Retrieves the shininess coefficient.
     *
     * @return The shininess coefficient.
     */
    public int getnShininess() {
        return nShininess;
    }

    /**
     * Sets the shininess coefficient.
     *
     * @param nShininess The shininess coefficient to set.
     * @return The updated Material object.
     */
    public Material setnShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * Retrieves the diffuse reflection coefficient.
     *
     * @return The diffuse reflection coefficient.
     */
    public Double3 getkD() {
        return kD;
    }

    //region Setters
    // ** All setters implement the Builder Design Pattern ** //

    /**
     * Sets the diffuse reflection coefficient.
     *
     * @param kD The diffuse reflection coefficient to set.
     * @return The updated Material object.
     */
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Sets the diffuse reflection coefficient.
     *
     * @param kD The diffuse reflection coefficient to set.
     * @return The updated Material object.
     */
    public Material setkD(Double kD) {
        this.kD = new Double3(kD);
        return this;
    }

    /**
     * Retrieves the specular reflection coefficient.
     *
     * @return The specular reflection coefficient.
     */
    public Double3 getkS() {
        return kS;
    }

    /**
     * Sets the specular reflection coefficient.
     *
     * @param kS The specular reflection coefficient to set.
     * @return The updated Material object.
     */
    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    /**
     * Sets the specular reflection coefficient.
     *
     * @param kS The specular reflection coefficient to set.
     * @return The updated Material object.
     */
    public Material setkS(Double kS) {
        this.kS = new Double3(kS);
        return this;
    }

    /**
     * Sets the attenuation coefficient of transparency.
     *
     * @param kT The attenuation coefficient of transparency to set.
     * @return The updated Material object.
     */
    public Material setkT(Double3 kT) {
        this.kT = kT;
        return this;
    }

    /**
     * Sets the attenuation coefficient of transparency.
     *
     * @param kT The attenuation coefficient of transparency to set.
     * @return The updated Material object.
     */
    public Material setkT(Double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    /**
     * Retrieves the attenuation coefficient of transparency.
     *
     * @return The attenuation coefficient of transparency.
     */
    public Double3 getkT() {
        return kT;
    }

    /**
     * Sets the attenuation coefficient of reflection.
     *
     * @param kR The attenuation coefficient of reflection to set.
     * @return The updated Material object.
     */
    public Material setkR(Double3 kR) {
        this.kR = kR;
        return this;
    }

/**
 * Sets the attenuation coefficient of reflection.
 *
 * @param kR The attenuation coefficient of reflection
 */
    public Material setkR(Double kR) {
        this.kR = new Double3(kR);
        return this;
    }

    /**
     * Retrieves the attenuation coefficient of reflection.
     *
     * @return The attenuation coefficient of reflection.
     */
    public Double3 getkR() {
        return kR;
    }

    //endregion
}
