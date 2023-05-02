package renderer;
import primitives.*;
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

    /**
     * ctor
     * @param p0
     * @param vUp
     * @param vTo
     */
    public Camera(Point p0, Vector vUp, Vector vTo){
        this.p0 = p0;
        this.vUp = vUp.normalize();
        this.vTo = vTo.normalize();

        // Checking if the two vectors are not vertical to one another
        double vTo_vUp = alignZero(vTo.dotProduct(vUp));
        if(vTo_vUp != 0)
            throw new IllegalArgumentException("The two vectors are not vertical to one another");

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
     * @return  distance of view plane from camera
     */
    public double getDistance() {
        return distance;
    }

    /**
     * TODO
     * @param width
     * @param height
     * @return
     */
    public Camera setVPSize(double width, double height){
        return this;
    }

    /**
     * TODO
     * @param distance
     * @return
     */
    public Camera setVPDistance(double distance) {
        return this;
    }

    /**
     * @param nX - number of columns in the resolution matrix
     * @param nY - number of rows in the resolution matrix
     * @param j - index of a column in the matrix
     * @param i - index of a row in the matrix
     * @return
     */
    public Ray constructRay(int nX, int nY, int j, int i){
        return null;
    }






}
