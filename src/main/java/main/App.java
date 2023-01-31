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
    }
}
