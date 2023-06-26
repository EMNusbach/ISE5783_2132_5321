 package renderer;

 import geometries.Polygon;
 import geometries.Sphere;
 import geometries.Triangle;
 import lighting.AmbientLight;
 import lighting.DirectionalLight;
 import lighting.PointLight;
 import lighting.SpotLight;
 import org.junit.jupiter.api.Test;
 import primitives.*;
 import scene.Scene;

 import static java.awt.Color.*;

 public class Image2Tests {
     Point A = new Point(-51.82, -19.69, -550);
     Point B = new Point(-48.42, 14.15, -550);
     Point C = new Point(-51.81, -0.78, -530.3);
     Point D = new Point(-61.73, 21.56, -672.88);
     Point E = new Point(-65.3, 34.47, -550);
     Point F = new Point(-79, 34.07, -529.92);
     Point G = new Point(-97.33, 38.05, -550);
     Point H = new Point(-117.87, 22.8, -550);
     Point I = new Point(-104.97, 27.82, -570.67);
     Point J = new Point(-117.98, 7.5, -530.28);
     Point K = new Point(-124.19, -8.01, -550);
     Point L = new Point(-106.35, -33.82, -550);
     Point M = new Point(-110.51, -22.87, -570.65);
     Point N = new Point(-91.91, -33.61, -529.44);
     Point O = new Point(-76.83, -38.77, -550);
     Point P = new Point(-64.72, -24.47, -573.02);
     Point Q = new Point(-104.02, -12.86, -517.24);
     Point R = new Point(-93.94, 12.57, -513.09);
     Point S = new Point(-75.55, -13.08, -486.7);
     Point T = new Point(-70.82, 10.11, -514.68);
     Point U = new Point(-70.96, -1.38, -586.65);
     Point V = new Point(-85, -20.62, -584.27);
     Point W = new Point(-85, 19.69, -584.82);
     Point Z = new Point(-99.93, 0.49, -587.1);
     @Test
     public void OurFinalImage() {
         Scene scene = new Scene.SceneBuilder("Test scene").build();
         scene = new Scene.SceneBuilder("l").setBackground(Color.BLACK).build();
         scene = new Scene.SceneBuilder("r").setAmbientLight
                 (new AmbientLight(new Color(WHITE), new Double3(0.15))).build();
         Camera camera = new Camera(new Point(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)) //
                 .setVPSize(1000, 1000).setVPDistance(1000);
         scene.geometries.add(

                 new Sphere(new Point(100, 0, -200), 190)
                         .setEmission(new Color(BLACK))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.8).setkR(0.0)),

                 new Sphere(new Point(100, 0, -200), 145)
                         .setEmission(new Color(BLACK))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.8).setkR(0.0)),

                 new Sphere(new Point(-205, 95, -200), 95)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 //region Chain
                 new Sphere(new Point(-340, 115, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-339, 95, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-335, 75, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-330, 55, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-320, 37, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-310, 19, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-295, 5, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-280, -10, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-265, -20, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-245, -26, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-225, -31, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-205, -33, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-185, -30, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-165, -25, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-148, -17, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-132, -8, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-118, 5, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-108, 23, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-100, 40, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-95, 60, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-89, 79, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-79, 97, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-69, 115, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-57, 132, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-43, 149, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-27, 162, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(-12, 172, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(5, 182, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(22, 190, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(40, 196, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(60, 202, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(80, 204, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(100, 205, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(120, 205, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(140, 204, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(160, 200, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(180, 195, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(195, 185, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(212, 175, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(226, 166, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),
                 new Sphere(new Point(241, 154, -200), 10)
                         .setEmission(new Color(GREEN))//
                         .setMaterial(new Material().setkD(0.8).setkS(0.8).setnshininess(30).setkT(0.0).setkR(0.0)),


//endregion
                 new Polygon(new Point(-250, -210, -400), new Point(-150, -210, -400), new Point(-150, 200, -400),
                         new Point(-250, 200, -400))
                         .setEmission(new Color(BLACK))
                         .setMaterial(new Material().setkD(0.2).setkS(0.2)
                                 .setnshininess(30).setkT(1.0).setGlossy(2)),
                 new Polygon(new Point(-110, -210, -400), new Point(-10, -210, -400), new Point(-10, 200, -400),
                         new Point(-110, 200, -400))
                         .setEmission(new Color(BLACK))
                         .setMaterial(new Material().setkD(0.2).setkS(0.2)
                                 .setnshininess(30).setkT(1.0).setGlossy(1)),
                 new Polygon(new Point(30, -210, -400), new Point(130, -210, -400), new Point(130, 200, -400),
                         new Point(30, 200, -400))
                         .setEmission(new Color(BLACK))
                         .setMaterial(new Material().setkD(0.2).setkS(0.2)
                                 .setnshininess(30).setkT(1.0).setGlossy(0.5)),
                 new Polygon(new Point(170, -210, -400), new Point(270, -210, -400), new Point(270, 200, -400),
                         new Point(170, 200, -400))
                         .setEmission(new Color(BLACK))
                         .setMaterial(new Material().setkD(0.2).setkS(0.2)
                                 .setnshininess(30).setkT(1.0).setGlossy(0.25)),


                 new Triangle(new Point(500, 200, -100), new Point(-500, 200, -100), new Point(1800, 200, -700))
                         .setEmission(new Color(BLACK))//
                         .setMaterial(new Material().setkD(0.8).setkS(1.0).setnshininess(10000).setkR(1d).setGlossy(0.5)),

                 new Triangle(new Point(-500, 200, -100), new Point(1800, 200, -700), new Point(-1800, 200, -700))
                         .setEmission(new Color(BLACK))//
                         .setMaterial(new Material().setkD(0.8).setkS(1d).setnshininess(10000).setkR(1d).setGlossy(0.5)));


         scene.lights.add(new DirectionalLight(new Color(10, 10, 10), new Vector(1, -1, 0)));
         scene.lights.add(new SpotLight(new Color(400, 400, 1020), new Point(-300, -300, -100), new Vector(2, 2, -3))
                 .setkL(0.00001).setkQ(0.000005).setkC(1));
         scene.lights.add(new SpotLight(new Color(400, 400, 1020), new Point(0, 0, -1), new Vector(0, 0, -300))
                 .setkL(0.0001).setkQ(0.00005).setkC(0.7));
         scene.lights.add(new PointLight(new Color(400, 400, 1020), new Point(-60, -210, -400))
                 .setkL(0.1).setkQ(0.5).setkC(0.7));
         scene.lights.add(new PointLight(new Color(400, 400, 1020), new Point(220, -210, -400))
                 .setkL(0.1).setkQ(0.5).setkC(0.7));

         ImageWriter imageWriter = new ImageWriter("my picture without improvements", 300, 300);
         camera.setImageWriter(imageWriter)
                 .setantiAliasing(0)
                 .setadaptive(true)
                 .setthreadsCount(3)
                 .setRayTracer(new RayTracerBasic(scene))
                 .renderImage()
                 .writeToImage();


     }
 }
