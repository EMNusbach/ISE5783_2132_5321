package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Graphic scene in our 3D model
 * Scene contains geometric shapes and light sources
 * we are using the builder pattern design
 */
public class Scene {
    public final Color background;
    public final AmbientLight ambientLight;
    public final Geometries geometries;
    public final List<LightSource> lights;
    private final String name;

    /**
     * Constructor for SceneBuilder
     * to get the Scene instance, you must call the methods
     *
     * @param builder the instance  of the SceneBuilder
     */
    public Scene(SceneBuilder builder) {

        name = builder.name;
        background = builder.background;
        ambientLight = builder.ambientLight;
        geometries = builder.geometries;
        lights = builder.lights;
    }

    public String getName() {
        return name;
    }

    public static class SceneBuilder {
        private final String name;
        private Color background = Color.BLACK;
        private AmbientLight ambientLight = AmbientLight.NONE;
        private Geometries geometries = new Geometries();
        private List<LightSource> lights = new LinkedList<>();

        //region Setters
        // ***************** Setters ********************** //
        // ** all setters implements the Builder Design Pattern **//


        public SceneBuilder(String name) {
            this.name = name;
        }

        /**
         * set the Background color for the scene
         *
         * @return the scene object
         */

        public SceneBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        public SceneBuilder setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        public SceneBuilder setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        public SceneBuilder setLights(List<LightSource> lights) {
            this.lights = lights;
            return this;
        }

        public Scene build() {
            return new Scene(this);
        }
    }
    //endregion
}