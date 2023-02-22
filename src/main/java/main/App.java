package main;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Trigonometria - class using example
 *
 */
public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Trigonometria - App");
        Trigonometria tri = new Trigonometria();

        System.out.println(tri);
        Trigonometria $tri2 = new Trigonometria("c", 10.0f, 8.0f, 90.0f);
        System.out.println($tri2);

        // toString - method with command parameter.
        System.out.println($tri2.toString("sin"));

        System.out.println($tri2.toString("cos"));
        System.out.println($tri2.toString("tan"));

        Mathematica m = new Mathematica();
        for (int i = 1; i <= 10; i++) {
            System.out.println(m.toString(i));
        }

        Point p1 = new Point();
        Point p2 = new Point(1.0f, 2.0f, 3.4f);
        // Point p2 = new Point();

        System.out.println(p1);

        System.out.println(p2);

        Transform tr = new Transform("Pikseli", 1, 2, 3);
        System.out.println(tr);

        Vector2 v2 = new Vector2();
        Vector3 v3 = new Vector3();

        System.out.println(v2);
        System.out.println(v3);

        v2.setVector2(5.0f, 5.0f);

        v3.setVector3(3.0f, 2.3f, 5.3f);
        System.out.println("Muutetaan vektoreita: ");
        System.out.println(v2);
        System.out.println(v3);

        v3.forward();
        System.out.println(v3);
        v3.zero();
        System.out.println(v3);
        v3.left();
        System.out.println(v3);
        v3.right();
        System.out.println(v3);
        v3.up();
        System.out.println(v3);
        v3.back();
        System.out.println(v3);
        v3.down();
        System.out.println(v3);
        v3.one();
        System.out.println(v3);

        Vector3 ret = new Vector3(4, 5, 6);
        double len = ret.norm();
        System.out.println("Pituus ret: " + len);

        Vector3 r = new Vector3();
        len = r.norm();
        System.out.println("Pituus r: " + len);
        

        // Lasketaan vektorit yhteen
        r = v3.add(v3, ret);
        System.out.println(r);
        len = r.norm();
        System.out.println("Pituus r: " + len);

        r = v3.decrease(v3, ret);
        System.out.println(r);
        len = r.norm();
        System.out.println("Pituus r: " + len);
        
        r = v3.decrease(ret, v3);
        System.out.println(r);
        len = r.norm();
        System.out.println("Pituus r: " + len);

        r = v3.add(ret);
        System.out.println("r: " + r + " --> v3: " + v3 + " --> ret: " + ret);
        len = r.norm();
        System.out.println("Pituus r: " + len);
        
        r = v3.decrease(ret);
        System.out.println(
                "r: " + r.toString("F3") +
                        " --> v3: " + v3.toString("F3") +
                        " --> ret: " + ret.toString("F3"));
                        len = r.norm();
                        System.out.println("Pituus r: " + len);
        // Kolmio
        Point pp1 = new Point(0, 0, 0);
        Point pp2 = new Point(3, 0, 0);
        Point pp3 = new Point(0, 4, 0);
        Triangle tri2 = new Triangle("Triangle ABC", pp1, pp2, pp3);

        System.out.println(tri2);

        double val = tri2.calculateSides("A");
        System.out.println("Sivu A: " + val);

        val = tri2.calculateSides("B");
        System.out.println("Sivu B: " + val);

        val = tri2.calculateSides("C");
        System.out.println("Sivu C: " + val);

        Vector3 t1 = new Vector3(tri2.getPointA());    
        Vector3 t2 = new Vector3(tri2.getPointB());
        Vector3 t3 = new Vector3(tri2.getPointC());

        len = t1.norm();
        System.out.println("Pituus t1: " + len);
        len = t2.norm();
        System.out.println("Pituus t2: " + len);
        len = t3.norm();
        System.out.println("Pituus t3: " + len);

        Vector3 t0 = new Vector3();
        t0 = t2.crossProduct(t2, t3);
        len = t0.norm();
        System.out.println("Pituus t0: " + len);
        System.out.println(t0);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // Square test
        System.out.println("\n**********************************************************");
        ArrayList<Point> corner = new ArrayList<Point>();
        
   //     for (int p = 0; p < 4; p++){
   //         corner.add(new Point(0, 0, 0));
   //     }
        
        corner.add(0, new Point(0, 0, 0));
        
        corner.add(1, new Point(5, 0, 0));
        
        corner.add(2, new Point(0, 5, 0));

        corner.add(3, new Point(5, 5, 0));

        Calculator calc = new Calculator();

        Square square = new Square(corner,"Square 1");
        System.out.println(square);
        System.out.println("Area: " + calc.area(square) + "");
        System.out.println(calc.getAreaStr());

        System.out.println("Perimeter: " + calc.perimeter(square) + "");
        System.out.println(calc.getPerimeterStr());

        ArrayList<Point> corner2 = new ArrayList<Point>();
        
        //     for (int p = 0; p < 4; p++){
        //         corner.add(new Point(0, 0, 0));
        //     }
             
        corner2.add(0, new Point(0, 0, 0));
        
        corner2.add(1, new Point(10, 0, -1));
        
        corner2.add(2, new Point(0, 5, 0));

        corner2.add(3, new Point(10, 5, -1));

        Calculator calc2 = new Calculator();
        DecimalFormat df = new DecimalFormat("#.##");
        
        Square square2 = new Square(corner2,"Square 2");
        System.out.println(square2);
        
        System.out.println("Area: " + df.format(calc2.area(square2)) + "");
        System.out.println(calc2.getAreaStr());
        System.out.println("Perimeter: " + df.format(calc2.perimeter(square2)) + "");
        System.out.println(calc2.getPerimeterStr());

    
        Calculator calc3 = new Calculator();
        Square square3 = new Square(p1,p2,"Square 3");
        System.out.println(square3);
        
        System.out.println("Area: " + df.format(calc3.area(square3)) + "");

        System.out.println("Perimeter: " + df.format(calc3.perimeter(square3)) + "");
        System.out.println(calc3.getPerimeterStr());

        calc3.reset();

        Square square4 = new Square(p1, 15.0d, "Square 4");
        System.out.println(square4);
        System.out.println("Area: " + df.format(calc3.area(square4)) + "");

        System.out.println(calc3.getAreaStr());
        System.out.println("Perimeter: " + df.format(calc3.perimeter(square4)) + "");
        
        System.out.println(calc3.getPerimeterStr());

        calc3.reset();

        Square square5 = new Square(p1, 1.5d, 2.6d, "Square 5");
        System.out.println(square5);
        System.out.println("Area: " + df.format(calc3.area(square5)) + "");

        System.out.println(calc3.getAreaStr());

        System.out.println("Perimeter: " + df.format(calc3.perimeter(square5)) + "");
        
        System.out.println(calc3.getPerimeterStr());

        System.out.println(square5.toString("CSV"));
        System.out.println(square5.toString("JSON"));
        System.out.println(square5.toString("JSONCOM"));

        calc3.reset();
        System.out.println(tri2);
        System.out.println("Area: " + df.format(calc3.area(tri2)) + "");

        System.out.println(calc3.getAreaStr());

        System.out.println("\n**********************************************************");
        Vector2 d1 = new Vector2(2,1);

        System.out.println(d1);
        System.out.println("Rotate: ");
        System.out.println(d1.rotate(Math.PI/2));
        System.out.println(d1.rotate(Math.PI));
        System.out.println(d1.rotate(2*Math.PI*3/4));

        System.out.println("Radians: " + String.format("%.2f",d1.degToRad(180)));
        System.out.println("Degrees: " + String.format("%.2f",d1.radToDeg(Math.PI/3)));

        System.out.println("\n**********************************************************");
        System.out.println("Vector3 v3: " + v3);
        System.out.println("ROTATE X: " + v3.rotate("X", Math.PI/2));
        System.out.println("ROTATE Y: " + v3.rotate("Y", Math.PI/2));
        System.out.println("ROTATE Z: " + v3.rotate("Z", Math.PI/2));

        System.out.println("Cube:");
        System.out.println("\n**********************************************************");
        
        Point p3 = new Point(0.0f, 0.0f, 0.0f);
        Cube cube = new Cube(p3, 100.0D);
        System.out.println(cube);
        System.out.println(cube.toString("Vertex"));
        System.out.println(cube.toString("Midpoint"));
        System.out.println(cube.toString("Cubemidpoint"));
        System.out.println("\n**********************************************************");
        System.out.println(cube.toString("JSON"));

        //System.out.println(cube.toString("Diagonal"));

        Pyramid pyramid = new Pyramid(p3, 1.5D);
        System.out.println(pyramid.toString("JSON"));
    }
}
    