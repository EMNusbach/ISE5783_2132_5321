package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import scene.Scene;

import java.util.List;

/**
 * the abstract RayTracerBase class is used to color a scene
 * with a given scene and a ray the class calculates the color of the ray
 */
public abstract class RayTracerBase {
    protected Scene scene;

    /**
     * ctor - initializing the scene parameter
     *
     * @param scene
     */
    public RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * the abstract method traces the ray to the point it hits in the scene,
     * it considers the different factors (ambient light, emmision light, light sources exet.)
     *
     * @param ray - the traced ray
     * @return - the discovered color
     */
    public abstract Color TraceRay(Ray ray);

    /**
     * Trace the ray and calculates the color of the point that interact with the geometries of the scene
     *
     * @param rays the ray that came out of the camera
     * @return the color of the object that the ray is interact with
     */
    public abstract Color TraceRays(List<Ray> rays);

    /**
     * Checks the color of the pixel with the help of individual rays and averages between
     * them and only if necessary continues to send beams of rays in recursion
     *
     * @param centerP   center pixl
     * @param Width     Length
     * @param Height    width
     * @param minWidth  min Width
     * @param minHeight min Height
     * @param cameraLoc Camera location
     * @param Vright    Vector right
     * @param Vup       vector up
     * @param prePoints pre Points
     * @return Pixel color
     */
    public abstract Color AdaptiveSuperSamplingRec(Point centerP, double Width, double Height, double minWidth, double minHeight, Point cameraLoc, Vector Vright, Vector Vup, List<Point> prePoints);

}
