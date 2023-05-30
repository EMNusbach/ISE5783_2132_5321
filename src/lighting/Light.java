package lighting;

import primitives.Color;

/**
 * abstract class to generate light intensity for all kind of lights
 */
abstract class Light {
    private Color intensity;

    /**
     * constructor of light
     *
     * @param intensity
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * getter of intensity
     *
     * @return
     */
    public Color getIntensity() {
        return intensity;
    }
}
