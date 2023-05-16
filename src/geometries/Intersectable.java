package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

/**
 *  A class that handles the intersection points.
 */
public abstract class Intersectable {


   /**
    * TODO
    * an auxiliary class the represents
    * geometry -
    * point -
    */
   public static class GeoPoint {
      public Geometry geometry;
      public Point point;

      /**
       *
       * @param geometry
       * @param point
       * @return
       */
      GeoPoint(Geometry geometry, Point point){
         this.geometry = geometry;
         this.point = point;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof GeoPoint geoPoint)) return false;
         return this.geometry.equals(geoPoint.geometry) && this.point.equals(geoPoint.point);
      }

      @Override
      public String toString() {
         return "GeoPoint{" +
                 "geometry=" + geometry +
                 ", point=" + point +
                 '}';
      }

   }

   public List<Point> findIntersections(Ray ray);

   public final List<GeoPoint> findGeoIntersections(Ray ray){
      return findGeoIntersectionsHelper(ray);
   }

   protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray);






}
