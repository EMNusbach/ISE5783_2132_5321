package geometries;

import primitives.*;


import java.util.*;

public class Geometries implements Intersectable {
    private List<Intersectable> geometries;

    @Override
    public List<Point> findIntersections(Ray ray) {
        //creating a list of all the intersections
        List<Point> l = null;

        // going over geometries
        for (Intersectable geom : geometries) {
            List<Point> gp = geom.findIntersections(ray);

            //Checking if three are intersections
            if (gp != null)

                //going over the intersections points and adding them to the list we created
                for (Point p : gp)
                    l.add(p);
        }
        // todo: check if there are identical points in l

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
     *
     * @param geometries
     */
    public Geometries(Intersectable... geometries) {
        this();
        add(geometries);

    }

    /**
     * add new elements to the list
     *
     * @param geometries
     */
    public void add(Intersectable... geometries) {
        Collections.addAll(this.geometries, geometries);
    }


}
