package primitives;

/**
 * @Param kT - Attenuation coefficient of transparency
 * @Param kT - Attenuation coefficient of reflection
 *
 * this class gives factors of material and the texture of the geometry.
 * geometries objects can have the same material.
 */
public class Material {
    public Double3 kD = Double3.ZERO;
    public Double3 kS = Double3.ZERO;
    public Double3 kT = Double3.ZERO;
    public Double3 kR = Double3.ZERO;
    public int nShininess = 0;

    //region Getters

    /**
     * getting of nShininess
     *
     * @return nShininess
     */
    public int getnShininess() {
        return nShininess;
    }

    public Material setnShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * getting of kD
     *
     * @return kD
     */
    public Double3 getkD() {
        return kD;
    }
    //endregion

    //region Setters
    // ** all setters implements the Builder Design Pattern **//
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    public Material setkD(Double kD) {
        this.kD = new Double3(kD);
        return this;
    }

    /**
     * getting of kS
     *
     * @return kS
     */
    public Double3 getkS() {
        return kS;
    }

    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    public Material setkS(Double kS) {
        this.kS = new Double3(kS);
        return this;
    }

    public Material setkT(Double3 kT) {
        this.kT = kT;
        return this;
    }

    public Material setkT(Double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    public Double3 getkT() {
        return kT;
    }

    public Material setkR(Double3 kR) {
        this.kR = kR;
        return this;
    }

    public Material setkR(Double kR) {
        this.kR = new Double3(kR);
        return this;
    }

    public Double3 getkR() {
        return kR;
    }

    //endregion
}
