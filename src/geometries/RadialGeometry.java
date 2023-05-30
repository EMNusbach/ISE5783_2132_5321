package geometries;

/**
 * RadialGeometry is an abstract class that is implemented by all classes that contain a radius
 */
public abstract class RadialGeometry extends Geometry {

    /**
     * a radius for use by different geometry
     */
    protected final double radius;

    /**
     * Constructor to initialize RadialGeometry based object with the same RadialGeometry values
     *
     * @param radius
     */
    RadialGeometry(double radius) {
        this.radius = radius;
    }

    /**
     * getting the radius of geometry
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

//    @Override
//    public List<Point> findIntersections(Ray ray){
//        return null;
//    }
}

