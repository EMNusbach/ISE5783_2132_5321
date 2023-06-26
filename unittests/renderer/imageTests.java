//package renderer;
//
//
//import scene.Scene;
//
//import geometries.Polygon;
//import geometries.Sphere;
//import lighting.AmbientLight;
//import lighting.DirectionalLight;
//import lighting.PointLight;
//import lighting.SpotLight;
//import org.junit.jupiter.api.Test;
//import primitives.*;
//
//
//import static java.awt.Color.*;
//
//import geometries.*;
//
//
//public class imageTests {
//
//    private Scene scene = new Scene.SceneBuilder("House scene").build();
//
//    @Test
//    public void housePicture() {
//        Camera camera = new Camera(new Point(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
//                .setVPSize(25, 25).setVPDistance(1000);
//        Point A = new Point(2, -4.56733, 3.26697);
//        Point B = new Point(1.33949, -8.42337, 5.64588);
//        Point C = new Point(1.33949, -1.29055, 5.64588);
//        Point D = new Point(2, 0.95004, 3.26697);
//        Point E = new Point(-5.22038, -4.48057, -0.17177);
//        Point F = new Point(-6.45236, -8.42337, 5.64588);
//        Point G = new Point(-5.19457, 0.96882, 2.9306);
//        Point H = new Point(-6.45236, -1.29055, 5.64588);
//        Point I = new Point(-2, 4, 8.77547);
//        Point Jb = new Point(-25, -3, -7);
//        Point Kb = new Point(25, -3, -7);
//        Point Jg = new Point(-25, -3, -7);
//        Point Kg = new Point(25, -3, -7);
//        Point L = new Point(25, -25, 0);
//        Point M = new Point(-25, -25, 0);
//        Point N = new Point(-25, 25, 0);
//        Point O = new Point(25, 25, 0);
//        Color grass = new Color(39, 167, 29);
//        Color sky = new Color(103, 239, 250);
//        Color brown = new Color(50, 0, 0);
//
//
//        scene.geometries.add(
//
//                //building
//                new Triangle(A, B, C).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(A, C, D).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(A, D, E).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(D, E, G).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(C, D, G).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(C, G, H).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(G, H, E).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(F, H, E).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(A, B, E).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(F, E, B).setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(H, C, new Point(1.33949, -5.5, 5.64588))
//                        .setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(H, new Point(1.33949, -5.5, 5.64588), new Point(-6.45236, -5.5, 5.64588))
//                        .setEmission(new Color
//                                (181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(B, new Point(-1.5, -8.42, 5.7), new Point(-1.5, -5.5, 5.7))
//                        .setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(B, new Point(1.33949, -5.5, 5.64588), new Point(-1.5, -5.5, 5.7))
//                        .setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(F, new Point(-3.7, -8.42, 5.7), new Point(-3.7, -5.5, 5.7))
//                        .setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(F, new Point(-6.45236, -5.5, 5.64588), new Point(-3.7, -5.5, 5.7))
//                        .setEmission(new Color(181, 101, 29))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//
//                //roof
//                new Triangle(H, G, I).setEmission(new Color(RED))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(C, D, I).setEmission(new Color(RED))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(H, C, I).setEmission(new Color(RED))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(D, G, I).setEmission(new Color(RED))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//
//
//                //sky
//                new Triangle(Jb, N, Kb).setEmission(sky)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.3)),
//                new Triangle(N, O, Kb).setEmission(sky)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.3)),
//
//                //sun
//                new Sphere(new Point(7.59, 9.44, 10), 2).setEmission(new Color(YELLOW))
//                        .setMaterial(new Material().setkD(0.001).setkS(0.5).setnshininess(100).setkT(0.6).setkR(0.3)),
////birds
//                new Triangle(new Point(-10, 5, 0), new Point(-9.94, 2.67, 3),
//                        new Point(-9.46, 4.15, 0)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-10, 5, 0),
//                        new Point(-9.46, 4.15, 0), new Point(-8.33, 3.91, 3)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-4.96, 3.75, 3), new Point(-7.06, 4.44, 0),
//                        new Point(-6.21, 3.93, 0)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-6.58, 2.49, 3), new Point(-7.06, 4.44, 0),
//                        new Point(-6.21, 3.93, 0)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-6.76, 1.44, 3), new Point(-8.61, 2.79, 0),
//                        new Point(-7.87, 1.82, 0)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-8.25, 0.64, 3), new Point(-8.61, 2.79, 0),
//                        new Point(-7.87, 1.82, 0)).setEmission(new Color(BLACK))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-3.7, -8.42, 5.7), new Point(-3.7, -5.5, 5.7),
//                        new Point(-1.9, -9, 6.1))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//                new Triangle(new Point(-1.9, -9, 6.1), new Point(-3.7, -5.5, 5.7),
//                        new Point(-1.9, -6, 6.1))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.0)),
//
//                //windows
//                new Triangle(new Point(-3.67, -2.60, 5.7), new Point(-3.67, -3.90, 5.7),
//                        new Point(-5.03, -3.90, 5.7))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.2).setkR(0.3)),
//                new Triangle(new Point(-5.03, -2.60, 5.7), new Point(-3.67, -2.60, 5.7),
//                        new Point(-5.03, -3.90, 5.7))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.2).setkR(0.3)),
//                new Triangle(new Point(-1.39, -2.60, 5.7), new Point(-1.39, -3.90, 5.7),
//                        new Point(-0.03, -3.90, 5.7))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.2).setkR(0.3)),
//                new Triangle(new Point(-0.03, -2.60, 5.7), new Point(-1.39, -2.60, 5.7),
//                        new Point(-0.03, -3.90, 5.7))
//                        .setEmission(brown)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.2).setkR(0.3)),
//
//                //grass
//                new Triangle(M, Kg, L).setEmission(grass)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.3)),
//                new Triangle(Kg, Jg, M).setEmission(grass)
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.3)),
////clouds
//                new Sphere(new Point(-7.92, 6.92, 0), 1.5).setEmission(new Color(255, 255, 255))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.9).setkR(0.3)),
//                new Sphere(new Point(-8.5, 9.62, 0), 2).setEmission(new Color(255, 255, 255))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.9).setkR(0.3)),
//                new Sphere(new Point(-3.01, 10.14, 0), 1.5).setEmission(new Color(255, 255, 255))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.9).setkR(0.3)),
//                new Sphere(new Point(-1.65, 8.06, 0), 2.3).setEmission(new Color(255, 255, 255))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.9).setkR(0.3)),
//                new Sphere(new Point(-5.41, 8.46, 0), 2.7).setEmission(new Color(255, 255, 255))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.9).setkR(0.3)),
//
//                //lamp1
//                new Polygon(new Point(2.9, -7.20, 4), new Point(2.9, -4.15, 4),
//                        new Point(3.45, -4.15, 4), new Point(3.45, -7.20, 4)),
//                new Sphere(new Point(3.21, -3.70, 4), 0.6).setEmission(new Color(YELLOW))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.4).setkR(0.3)),
//
//
//                //lamp2
//                new Polygon(new Point(-7.9, -7.20, 4), new Point(-7.9, -4.15, 4),
//                new Point(-8.45, -4.15, 4), new Point(-8.45, -7.20, 4)),
//                new Sphere(new Point(-8.21, -3.70, 4), 0.6).setEmission(new Color(YELLOW))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.4).setkR(0.3))
//
//
//        );
//        //birds/sun
//        scene.lights.add(new SpotLight(new Color(yellow), new Point(-7.27, 12.14, 5.5),
//                new Vector(-0.12, -8.55, 5.5)));
//
//        //sun
//        //scene.lights.add(new PointLight(new Color(yellow), new Point(6.59, 8.44, 10)));
//
//        scene.lights.add(new PointLight(new Color(yellow), new Point(6.59, 8.44, 10)));
//        scene.lights.add(new DirectionalLight(new Color(800, 500, 0), new Vector(5.59, 7.44, 10)));
//
//        //lamp light
//        scene.lights.add(new PointLight(new Color(255, 255, 255), new Point(3.21, -3.70, 4)));
//      //  scene.lights.add(new PointLight(new Color(255, 255, 255), new Point(6.59, 8.44, 10)));
//        //lamp2 light
//        scene.lights.add(new PointLight(new Color(255, 255, 255), new Point(-8.21, -3.70, 4)));
//
//        camera.setImageWriter(new ImageWriter("House image", 1000, 1000)) //
//                .setantiAliasing(1)
//                .setadaptive(true)
//                .setthreadsCount(3)
//                .setRayTracer(new RayTracerBasic(scene)) //
//                .renderImage() //
//                .writeToImage();
//
//
//    }
//
//
//    @Test
//    public void lovelyDayPicture() {
//        Camera camera = new Camera(new Point(0, 100, 10000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //vto,vup
//                .setVPSize(2500, 2500).setVPDistance(10000);
//
//        scene = new Scene.SceneBuilder("l").setAmbientLight(new AmbientLight(new Color(255, 255, 255), new Double3(0.1))).build();
//        scene = new Scene.SceneBuilder("l").setBackground(new Color(135, 206, 250)).build();
//        scene.geometries.add(
//                //six big triangles
//                new Triangle(new Point(-930, -1500, -1000), new Point(-1250, -804, -1000), new Point(-1500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(-500, -1500, -1050), new Point(-750, -780, -1000), new Point(-1000, -1500, -2000)).setEmission(new Color(20, 190, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(0, -1500, -1000), new Point(-250, -800, -1000), new Point(-500, -1500, -2000)).setEmission(new Color(20, 185, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(500, -1500, -1000), new Point(250, -880, -1000), new Point(0, -1500, -2000)).setEmission(new Color(20, 195, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(1000, -1500, -1008), new Point(750, -842, -1000), new Point(500, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(1400, -1500, -1095), new Point(1250, -839, -1000), new Point(1050, -1500, -2000)).setEmission(new Color(20, 180, 20)).setMaterial(new Material().setkR(0.36)),
////5 smaller triangles
//                new Triangle(new Point(-750, -1500, -1000), new Point(-1000, -960, -1000), new Point(-1250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(-250, -1500, -1000), new Point(-500, -895, -1000), new Point(-700, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(250, -1500, -1000), new Point(0, -950, -1000), new Point(-250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(750, -1500, -1000), new Point(500, -900, -1000), new Point(250, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                new Triangle(new Point(1250, -1500, -1000), new Point(1000, -950, -1000), new Point(750, -1500, -2000)).setEmission(new Color(20, 200, 20)).setMaterial(new Material().setkR(0.36)),
//                //the red points on the grass
//                new Sphere(new Point(-1000, -960, -1000), 50).setMaterial(new Material().setkD(0.25).setkR(0.025).setkS(0.95).setnshininess(25)).setEmission(new Color(102, 0, 102)),
//                new Sphere(new Point(250, -900, -1000), 50).setEmission(new Color(102, 0, 102)).setMaterial(new Material().setkD(0.30).setkR(0.1).setkS(0.40).setnshininess(5)),
//                new Sphere(new Point(-120, -1180, -1000), 50).setEmission(new Color(102, 0, 102)).setMaterial(new Material().setkD(0.1).setkR(0.001).setkS(0.54).setnshininess(12)),
//                new Sphere(new Point(1100, -1150, -1000), 50).setEmission(new Color(102, 0, 102)).setMaterial(new Material().setkD(0.8).setkR(0.0005).setkS(0.7).setnshininess(40)),
//
//                //the paper
//                new Triangle(new Point(-100, -35, -150), new Point(150, -150, -150), new Point(75, 75, -150)).setEmission(new Color(10, 0, 255)).setMaterial(new Material().setkD(0.5).setkS(0.5).setnshininess(300).setkR(0.5)), //the lower
//                new Triangle(new Point(-600, -300, -600), new Point(-500, 400, -500), new Point(75, 75, -150)).setEmission(new Color(10, 0, 255)).setMaterial(new Material().setkD(0.5).setkS(0.25).setnshininess(500).setkR(0.26)),//the lefter
//                new Triangle(new Point(400, 100, 600), new Point(-500, 400, -500), new Point(75, 75, -150)).setEmission(new Color(10, 0, 255)).setMaterial(new Material().setkD(0.68).setkR(0.30).setkS(0.2).setnshininess(300)),//the rightest
//                //
//                new Triangle(new Point(-100, -35, -150), new Point(150, -100, -100), new Point(100, 100, 100)).setEmission(new Color(102, 0, 102)),
//                //the suns
//                new Sphere(new Point(750, 730, 760), 370)
//                        .setEmission(new Color(255, 0, 0))
//                        .setMaterial(new Material().setkD(0.4).setkS(0.3).setnshininess(100).setkT(0.3)),
//                new Sphere(new Point(720, 700, 450), 250) //the inner sphere
//                        .setEmission(new Color(YELLOW))
//                        .setMaterial(new Material().setkD(0.5).setkS(0.5).setnshininess(100)));
//
//
//        scene.lights.add(new DirectionalLight(new Color(990, 869, 100), new Vector(1000, 850, 950)));
//        scene.lights.add(new SpotLight(new Color(720, 400, 400), new Point(-200, -200, -200), new Vector(1, 10, -4))
//                .setkL(0.00001).setkQ(0.000005));
//        scene.lights.add(new PointLight(new Color(500, 300, 0), new Point(700, 700, 950))
//                .setkL(0.00001).setkQ(0.000001));
//        scene.lights.add(new PointLight(new Color(100, 300, 0), new Point(-1400, -1400, 1000))
//                .setkL(0.00001).setkQ(0.000001));
//        camera.setImageWriter(new ImageWriter("lovely day", 500, 500))
//                .setRayTracer(new RayTracerBasic(scene))
//                .renderImage()
//                .writeToImage();
//    }
//
//}
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

public class imageTests {
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

        ImageWriter imageWriter = new ImageWriter("my picture", 300, 300);
        camera.setImageWriter(imageWriter)
                .setantiAliasing(150)
                .setadaptive(true)
                .setthreadsCount(3)
                .setRayTracer(new RayTracerBasic(scene))
                .renderImage()
                .writeToImage();


    }
}