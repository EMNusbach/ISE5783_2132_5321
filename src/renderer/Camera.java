package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.MissingResourceException;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Represents a camera in a 3D scene with a virtual view plane.
 * The camera is defined by its location and the directions towards the scene.
 * The view plane is represented by its height and width.
 */
public class Camera {

    private Point p0;
    private Vector vRight;
    private Vector vUp;
    private Vector vTo;
    private double distance;
    private double width;
    private double height;
    private Point centerPoint;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracer;

    private int numOfRays = 300;
    private int adaptiveMaxDepth = 4;
    private boolean isMultithreading = true;
    private int numOfThreads = 30;

    /**
     * Constructs a camera.
     *
     * @param p0  The location of the camera.
     * @param vTo The direction towards the view plane.
     * @param vUp The upward direction.
     * @throws IllegalArgumentException if vTo and vUp are not orthogonal.
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vUp.dotProduct(vTo))) {
            throw new IllegalArgumentException("The vectors 'up' and 'to' are not orthogonal.");
        }

        this.p0 = p0;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();
        vRight = this.vTo.crossProduct(this.vUp).normalize();
    }

    //region Getters/Setters

    /**
     * Returns the location of the camera.
     *
     * @return The location point.
     */
    public Point getP0() {
        return p0;
    }

    /**
     * Returns the right vector of the camera.
     *
     * @return The right vector.
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * Returns the up vector of the camera.
     *
     * @return The up vector.
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * Returns the direction vector towards the view plane.
     *
     * @return The direction vector.
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * Returns the distance from the camera to the view plane.
     *
     * @return The distance value.
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Returns the width of the view plane.
     *
     * @return The width value.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns the height of the view plane.
     *
     * @return The height value.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Returns the center point of the view plane.
     *
     * @return The center point.
     */
    public Point get_centerVPPoint() {
        return centerPoint;
    }

    /**
     * Sets the size of the view plane.
     *
     * @param width  The width of the view plane.
     * @param height The height of the view plane.
     * @return This camera (builder pattern).
     * @throws IllegalArgumentException if width or height are equal to 0.
     */
    public Camera setVPSize(double width, double height) {
        if (isZero(width) || isZero(height)) {
            throw new IllegalArgumentException("Width or height cannot be zero.");
        }

        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * Sets the distance from the camera to the view plane.
     *
     * @param distance The distance value.
     * @return This camera (builder pattern).
     * @throws IllegalArgumentException if distance is 0.
     */
    public Camera setVPDistance(double distance) {
        if (isZero(distance)) {
            throw new IllegalArgumentException("Distance cannot be zero.");
        }

        this.distance = distance;
        // Recalculate the center point of the view plane
        centerPoint = p0.add(vTo.scale(this.distance));
        return this;
    }

    /**
     * Sets the ray tracer for the camera.
     *
     * @param rayTracer The ray tracer.
     * @return This camera (builder pattern).
     */
    public Camera setRayTracer(RayTracerBase rayTracer) {
        this.rayTracer = rayTracer;
        return this;
    }

    /**
     * Sets the image writer for the camera.
     *
     * @param imageWriter The image writer.
     * @return This camera (builder pattern).
     */
    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }

    //endregion

    /**
     * Checks if all fields are properly set and creates an image.
     *
     * @return This camera.
     * @throws MissingResourceException if any camera data is missing.
     */
    public Camera renderImage() {
        if (p0 == null || vRight == null
                || vUp == null || vTo == null || distance == 0
                || width == 0 || height == 0 || centerPoint == null
                || imageWriter == null || rayTracer == null) {
            throw new MissingResourceException("Missing camera data", Camera.class.getName(), null);
        }

        for (int i = 0; i < imageWriter.getNy(); i++) {
            for (int j = 0; j < imageWriter.getNx(); j++) {
                // Pixel coloring by ray
                Ray ray = constructRay(imageWriter.getNx(), imageWriter.getNy(), j, i);
                imageWriter.writePixel(j, i, rayTracer.TraceRay(ray));
            }
        }

        return this;
    }

    /**
     * Prints a grid on the image.
     *
     * @param interval The interval between pixels.
     * @param color    The color of the grid.
     */
    public void printGrid(int interval, Color color) {
        if (this.imageWriter == null)
            throw new MissingResourceException("imageWriter is null", ImageWriter.class.getName(), null);

        imageWriter.printGrid(interval, color);
    }

    /**
     * Constructs a ray through a pixel on the view plane.
     *
     * @param nX Number of pixels in the width of the view plane.
     * @param nY Number of pixels in the height of the view plane.
     * @param j  Row index in the view plane.
     * @param i  Column index in the view plane.
     * @return The ray that goes through the pixel (j, i): Ray(p0, Vi,j).
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        Point pIJ = getCenterOfPixel(nX, nY, j, i); // Center point of the pixel

        // Vi,j = Pi,j - P0, the direction of the ray to the pixel (j, i)
        Vector vIJ = pIJ.subtract(p0);
        return new Ray(p0, vIJ);
    }

    /**
     * Calculates the center point of a pixel on the view plane.
     *
     * @param nX Number of pixels in the width of the view plane.
     * @param nY Number of pixels in the height of the view plane.
     * @param j  Row index in the view plane.
     * @param i  Column index in the view plane.
     * @return The center point of the pixel.
     */
    private Point getCenterOfPixel(int nX, int nY, int j, int i) {
        // Calculate the ratio of the pixel's height and width
        // Ry = h / Ny, the height of the pixel
        double rY = alignZero(height / nY);
        // Rx = w / Nx, the width of the pixel
        double rX = alignZero(width / nX);

        // Xj = (j - (Nx - 1) / 2) * Rx
        double xJ = alignZero((j - ((nX - 1) / 2d)) * rX);
        // Yi = -(i - (Ny - 1) / 2) * Ry
        double yI = alignZero(-(i - ((nY - 1) / 2d)) * rY);

        Point pIJ = centerPoint;

        if (!isZero(xJ)) {
            pIJ = pIJ.add(vRight.scale(xJ));
        }
        if (!isZero(yI)) {
            pIJ = pIJ.add(vUp.scale(yI));
        }

        return pIJ;
    }

    /**
     * Writes the image to the output file.
     */
    public void writeToImage() {
        imageWriter.writeToImage();
    }

    /**
     * Moves the camera to a new position and point of view.
     *
     * @param newPosition    The new position of the camera.
     * @param newPointOfView The new point of view of the camera.
     * @return The new camera with the updated position and point of view.
     */
    public Camera moveCamera(Point newPosition, Point newPointOfView) {
        // Calculate the new vTo of the camera
        Vector new_vTo = newPointOfView.subtract(newPosition).normalize();
        // Calculate the angle between the new vTo and the old one
        double theta = new_vTo.dotProduct(vTo);
        // Calculate the axis vector for the rotation
        Vector k = vTo.crossProduct(new_vTo).normalize();

        vTo = new_vTo;
        p0 = newPosition;

        return rotateCamera(theta, k);
    }

    /**
     * Rotates the camera by rotating the vectors of the camera directions according to Rodrigues' rotation formula.
     *
     * @param theta The angle theta according to the right-hand rule in degrees.
     * @return This camera after the rotation.
     */
    public Camera rotateCamera(double theta) {
        return rotateCamera(theta, vTo);
    }

    /**
     * Rotates the camera by rotating the vectors of the camera directions according to Rodrigues' rotation formula.
     *
     * @param theta The angle theta according to the right-hand rule in degrees.
     * @param k     The axis vector for the rotation.
     * @return This camera after the rotation.
     */
    private Camera rotateCamera(double theta, Vector k) {
        double radianAngle = Math.toRadians(theta);
        double cosTheta = alignZero(Math.cos(radianAngle));
        double sinTheta = alignZero(Math.sin(radianAngle));

        vRight.rotateVector(k, cosTheta, sinTheta);
        vUp.rotateVector(k, cosTheta, sinTheta);

        return this;
    }



    /**
     * Sets the multithreading option for rendering the image.
     *
     * @param threads The number of threads to use for rendering. Must be 0 or higher.
     * @return This camera with the multithreading option set.
     * @throws IllegalArgumentException if the number of threads is less than 0.
     */
    public Camera setMultithreading(int threads) {
        if (threads < 0)
            throw new IllegalArgumentException("Multithreading parameter must be 0 or higher");

        isMultithreading = true;

        if (threads != 0)
            numOfThreads = threads;
        else {
            int cores = Runtime.getRuntime().availableProcessors() - 2;
            numOfThreads = cores <= 2 ? 1 : cores;
        }
        return this;
    }

    /**
     * Sets the rendering improvements for the camera.
     *
     * @param multiThreading Indicates whether to use multithreading for rendering.
     * @param glossy         Indicates whether to use glossy reflections.
     * @return This camera with the specified rendering improvements.
     */
    public Camera setImprovements(boolean multiThreading, boolean glossy) {
        this.isMultithreading = multiThreading;
        // this.glossy = glossy; // Uncomment this line if you need to use the glossy option
        return this;
    }
}