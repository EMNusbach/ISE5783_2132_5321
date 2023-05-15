package renderer;

import primitives.*;

import java.util.MissingResourceException;

import static primitives.Util.*;

/**
 * po- center of the camera
 * vUp- axis up;
 * vTo- axis towards the image;
 * vRight- axis right;
 * width - of view plane
 * height - of view plane
 * distance - of view plane from camera
 */
public class Camera {

    private Point p0;
    private Vector vUp;
    private Vector vTo;
    private Vector vRight;
    private double width;
    private double height;
    private double distance;
    private Point centerPoint;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracer;

    /**
     * c_tor
     *
     * @param p0
     * @param vUp
     * @param vTo
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        // Checking if the two vectors are not vertical to one another
        double vTo_vUp = alignZero(vTo.dotProduct(vUp));
        if (!isZero(vUp.dotProduct(vTo)))
            throw new IllegalArgumentException("The two vectors are not vertical to one another");

        this.p0 = p0;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();

        // creating a right vector that is vertical to vUp and vTo
        this.vRight = vTo.crossProduct(vUp).normalize();
    }

    /**
     * @return center of the camera
     */
    public Point getP0() {
        return p0;
    }

    /**
     * @return axis up
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * @return axis towards the image
     */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * @return axis right
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * @return width of view plane
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return height  of view plane
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return distance of view plane from camera
     */
    public double getDistance() {
        return distance;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    /**
     * Prints a grid on the image with the specified interval and color.
     *
     * @param interval the interval between grid lines
     * @param color    the color of the grid lines
     * @throws MissingResourceException if the imageWriter is null
     */
    public void printGrid(int interval, Color color) throws MissingResourceException {
        if (this.imageWriter == null)
            throw new MissingResourceException("imageWriter is null", ImageWriter.class.getName(), null);
        imageWriter.printGrid(interval, color);
    }


    /**
     * set the imageWriter  for the Camera
     *
     * @return the Camera object
     */
    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }

    public void writeToImage() {
        imageWriter.writeToImage();
    }


    public Camera setVPSize(double width, double height) {
        if (isZero(width) || isZero(height)) {
            throw new IllegalArgumentException("width or height cannot be zero");
        }

        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * @param distance
     */
    public Camera setVPDistance(double distance) {
        if (isZero(distance)) {
            throw new IllegalArgumentException("distance cannot be zero");
        }

        this.distance = distance;
        // every time that we chang the distance from the view plane
        // we will calculate the center point of the view plane aging
        centerPoint = p0.add(vTo.scale(this.distance));
        return this;
    }


    /**
     * Calculates the center point of a pixel on the view plane.
     *
     * @param nX The number of pixels along the width of the view plane.
     * @param nY The number of pixels along the height of the view plane.
     * @param j  The horizontal index of the pixel.
     * @param i  The vertical index of the pixel.
     * @return The center point of the specified pixel.
     */
    private Point getCenterOfPixel(double nX, double nY, int j, int i) {
// calculate the ratio of the pixel by the height and by the width of the view plane
// the ratio Ry = h/Ny, the height of the pixel
        double rY = alignZero(height / nY);
// the ratio Rx = w/Nx, the width of the pixel
        double rX = alignZero(width / nX);

// Xj = (j - (Nx -1)/2) * Rx
        double xJ = alignZero((j - ((nX - 1d) / 2d)) * rX);
// Yi = -(i - (Ny - 1)/2) * Ry
        double yI = alignZero(-(i - ((nY - 1d) / 2d)) * rY);

        Point pIJ = centerPoint;

        if (xJ != 0d) {
            pIJ = pIJ.add(vRight.scale(xJ));
        }
        if (yI != 0d) {
            pIJ = pIJ.add(vUp.scale(yI));
        }
        return pIJ;
    }

    /**
     * @param nX - number of columns in the resolution matrix
     * @param nY - number of rows in the resolution matrix
     * @param j  - index of a column in the matrix
     * @param i  - index of a row in the matrix
     * @return
     */

    public Ray constructRay(double nX, double nY, int j, int i) {
        Point pIJ = getCenterOfPixel(nX, nY, j, i); // center point of the pixel

        //Vi,j = Pi,j - P0, the direction of the ray to the pixel(j, i)
        Vector vIJ = pIJ.subtract(p0);
        return new Ray(p0, vIJ);
    }


    /**
     * Renders the image by tracing rays through each pixel of the image plane.
     * The resulting color for each pixel is calculated using ray tracing.
     *
     * @throws MissingResourceException if any required camera data is missing.
     */
    public void renderImage() throws MissingResourceException {
        if (p0 == null || vRight == null
                || vUp == null || vTo == null || distance == 0
                || width == 0 || height == 0 || centerPoint == null
                || imageWriter == null || rayTracer == null) {
            throw new MissingResourceException("Missing camera data", Camera.class.getName(), null);
        }

        for (int i = 0; i < imageWriter.getNy(); i++) {
            for (int j = 0; j < imageWriter.getNx(); j++) {
                // Pixel coloring by ray
                Ray ray = constructRay(imageWriter.getNy(), imageWriter.getNx(), j, i);
                imageWriter.writePixel(j, i, rayTracer.TraceRay(ray));
            }
        }
    }

    public Camera setRayTracer(RayTracerBase rayTracer) {
        this.rayTracer = rayTracer;
        return this;
    }


}
