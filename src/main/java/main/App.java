package main;

/**
 * Trigonometria - class using example 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Trigonometria - App" );
        Trigonometria tri = new Trigonometria();

        System.out.println(tri);
        Trigonometria $tri2 = new Trigonometria("c",10.0f,8.0f,90.0f);
        System.out.println($tri2);

        // toString - method with command parameter.
        System.out.println($tri2.toString("sin"));

        System.out.println($tri2.toString("cos"));
        System.out.println($tri2.toString("tan"));

        Mathematica m = new Mathematica();
        for (int i = 1; i <= 10; i++){
            System.out.println(m.toString(i));
        }

        Point p1 = new Point();
        Point p2 = new Point(1.0f,2.0f,3.4f);
        //Point p2 = new Point();

        System.out.println(p1);

        System.out.println(p2);

        Transform tr = new Transform("Pikseli", 1,2,3);
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

        Vector3 ret = new Vector3(4,5,6);
        Vector3 r = new Vector3();
        // Lasketaan vektorit yhteen
        r = v3.add(v3,ret);
        System.out.println(r);
        r = v3.decrease(v3,ret);
        System.out.println(r);

        r = v3.decrease(ret,v3);
        System.out.println(r);

        r = v3.add(ret);
        System.out.println("r: " + r + " --> v3: " + v3 + " --> ret: " + ret);
        
        r = v3.decrease(ret);
        System.out.println(
            "r: " + r.toString("F3") + 
            " --> v3: " + v3.toString("F3") + 
            " --> ret: " + ret.toString("F3")
            );
        
    }
}
