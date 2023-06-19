package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Graphic scene in our 3D model.
 * Scene contains geometric shapes and light sources.
 * We are using the builder pattern design.
 */
public class Scene {
    public final Color background;
    public final AmbientLight ambientLight;
    public final Geometries geometries;
    public final List<LightSource> lights;
    private final String name;

    /**
     * Constructor for SceneBuilder.
     * To get the Scene instance, you must call the methods.
     *
     * @param builder The instance of the SceneBuilder.
     */
    public Scene(SceneBuilder builder) {
        name = builder.name;
        background = builder.background;
        ambientLight = builder.ambientLight;
        geometries = builder.geometries;
        lights = builder.lights;
    }

    /**
     * Gets the name of the scene.
     *
     * @return The name of the scene.
     */
    public String getName() {
        return name;
    }

    /**
     * Builder class for Scene.
     */
    public static class SceneBuilder {
        private final String name;
        private Color background = Color.BLACK;
        private AmbientLight ambientLight = AmbientLight.NONE;
        private Geometries geometries = new Geometries();
        private List<LightSource> lights = new LinkedList<>();

        /**
         * Constructor for SceneBuilder.
         *
         * @param name The name of the scene.
         */
        public SceneBuilder(String name) {
            this.name = name;
        }

        /**
         * Sets the background color for the scene.
         *
         * @param background The background color to set.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        /**
         * Sets the ambient light for the scene.
         *
         * @param ambientLight The ambient light to set.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        /**
         * Sets the geometries for the scene.
         *
         * @param geometries The geometries to set.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        /**
         * Sets the light sources for the scene.
         *
         * @param lights The light sources to set.
         * @return The SceneBuilder object.
         */
        public SceneBuilder setLights(List<LightSource> lights) {
            this.lights = lights;
            return this;
        }

        /**
         * Builds the Scene object.
         *
         * @return The Scene object.
         */
        public Scene build() {
            return new Scene(this);
        }
    }
}
