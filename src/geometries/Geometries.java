package geometries;

import primitives.*;


import java.util.*;

/**
 * Composite pattern
 * a useful design pattern that allows us to create a complex image out of simple geometries.
 */

public class Geometries extends Intersectable {
    private List<Intersectable> geometries;

    @Override
    public List<Point> findIntersections(Ray ray) {
        //creating a list of all the intersections
        List<Point> l = null;

        // going over geometries
        for (Intersectable geom : geometries) {
            List<Point> gp = geom.findIntersections(ray);

            //Checking if three are intersections
            if (gp != null) {

                //firs initialization to the list
                if (l == null)
                    l = new LinkedList<>();

                // Adding the intersections points to the list we created
                    l.addAll(gp);
            }
        }

        return l;
    }


    /**
     * Default c_tor
     */
    Geometries() {
        geometries = new LinkedList();
    }

    /**
     * copy c_tor
     * @param geometries
     */
    public Geometries(Intersectable... geometries) {
        this();
        add(geometries);

    }

    /**
     * add new elements to the list
     * @param geometries
     */
    public void add(Intersectable... geometries) {
        Collections.addAll(this.geometries, geometries);
    }


}
