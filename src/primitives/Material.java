package primitives;

/**
 * this class gives factors of material and the texture of the geometry.
 * geometries objects can have the same material.
 *
 * @author tehila and esther malka
 */
public class Material {

    /**
     * diffusive
     */
    public Double3 kD = new Double3(0, 0, 0);
    /**
     * specular
     */
    public Double3 kS = new Double3(0, 0, 0);
    /**
     * Discount coefficient for transparency
     */
    public Double3 kT = new Double3(0, 0, 0);
    /**
     * Coefficient of attenuation for reflection
     */
    public Double3 kR = new Double3(0, 0, 0);
    /**
     * The shininess factor of the material.
     */
    public int nShininess = 0;

    /**
     * The glossy factor of the material.
     */
    public double Glossy = 0;

    /**
     * getting of nShininess
     *
     * @return nShininess
     */
    public int getnShininess() {
        return nShininess;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkD() {
        return kD;
    }

    /**
     * Sets the diffuse coefficient of the material.
     *
     * @param kD The diffuse coefficient to set
     * @return The Material object with the updated diffuse coefficient
     */
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Sets the diffuse coefficient of the material.
     *
     * @param kD The diffuse coefficient to set
     * @return The Material object with the updated diffuse coefficient
     */
    public Material setkD(Double kD) {
        this.kD = new Double3(kD);
        return this;
    }

    //endregion

    /**
     * getting of kS
     *
     * @return kS
     */
    public Double3 getkS() {
        return kS;
    }

    /**
     * The specular coefficient of the material.
     *
     * @param kS The specular coefficient as a Double3 representing the RGB values.
     * @return The Material object for method chaining.
     */
    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    /**
     * The specular coefficient of the material.
     *
     * @param kS The specular coefficient as a Double representing the grayscale value.
     * @return The Material object for method chaining.
     */
    public Material setkS(Double kS) {
        this.kS = new Double3(kS);
        return this;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkT() {
        return kT;
    }

    /**
     * The transparency coefficient of the material.
     *
     * @param kT The transparency coefficient as a Double3 representing the RGB values.
     * @return The Material object for method chaining.
     */
    public Material setkT(Double3 kT) {
        this.kT = kT;
        return this;
    }

    /**
     * The transparency coefficient of the material.
     *
     * @param kT The transparency coefficient as a Double representing the grayscale value.
     * @return The Material object for method chaining.
     */
    public Material setkT(Double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkR() {
        return kR;
    }

    /**
     * The coefficient of attenuation for reflection.
     *
     * @param kR The reflection coefficient as a Double3 representing the RGB values.
     * @return The Material object for method chaining.
     */
    public Material setkR(Double3 kR) {
        this.kR = kR;
        return this;
    }

    /**
     * The coefficient of attenuation for reflection.
     *
     * @param kR The reflection coefficient as a Double representing the grayscale value.
     * @return The Material object for method chaining.
     */
    public Material setkR(Double kR) {
        this.kR = new Double3(kR);
        return this;
    }

    /**
     * Sets the shininess factor of the material.
     *
     * @param nShininess The shininess factor.
     * @return The Material object for method chaining.
     */
    public Material setnshininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * Returns the glossy value of the material.
     *
     * @return The glossy value.
     */
    public double getGlossy() {
        return Glossy;
    }

    /**
     * Sets the glossy value of the material.
     *
     * @param Glossy The glossy value.
     * @return The Material object for method chaining.
     */
    public Material setGlossy(double Glossy) {
        this.Glossy = Glossy;
        return this;
    }


    //endregion
}
