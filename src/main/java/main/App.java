package main;

/**
 * Trigonometria - class using example
 *
 */
public class App {
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
        float len = ret.norm();
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
        Point pp2 = new Point(3, 0, -1);
        Point pp3 = new Point(0, 4, -1);
        Triangle tri2 = new Triangle("Triangle ABC", pp1, pp2, pp3);

        System.out.println(tri2);

        float val = tri2.calculateSides("A");
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


    }
}
