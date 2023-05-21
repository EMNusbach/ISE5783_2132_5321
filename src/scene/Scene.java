package scene;

import lighting.*;
import geometries.Geometries;
import primitives.Color;

import java.util.List;
import java.util.LinkedList;

/**
     * Graphic scene in our 3D model
     * Scene contains geometric shapes and light sources
     * we are using the builder pattern design
     */
    public class Scene {
        public String name = null;
        public Color background = Color.BLACK;
        public AmbientLight ambientLight = new AmbientLight();
        public Geometries geometries= new Geometries();
        public List<LightSource> lighting = new LinkedList<>();
        /**
         * Constructor for SceneBuilder
         * to get the Scene instance, you must call the methods
         * @param name the name of the scene
         */
        public Scene(String name) {
            this.name = name;
        }

        //region Setters
        // ***************** Setters ********************** //
        // ** all setters implements the Builder Design Pattern **//

        /**
         * set the Background color for the scene
         *
         * @return the scene object
         */
        public scene.Scene setBackground(Color background) {
            this.background = background;
            return this;
        }

        /**
         * set the Ambient Light for the scene
         *
         * @return the scene object
         */
        public scene.Scene setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        /**
         * set the geometry model - a list of geometries
         *
         * @return the scene object
         */
        public scene.Scene setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        /**
         * set the lightSource - a list of light sources
         *
         * @return the scene object
         */
        public scene.Scene setLighting(List<LightSource> lighting) {
            this.lighting = lighting;
            return this;
        }
        //endregion
    }