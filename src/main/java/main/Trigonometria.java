package main;

import java.lang.Math;

public class Trigonometria {
    private double aCat;
    private double bCat;
    private double cHyp;
    private double alpha;
    private double beta;
    private double gamma;
    
    // Default Constructor
    //******************************************/
    public Trigonometria(){
        aCat = 4;
        bCat = 3;
        cHyp = 5;
        gamma = 90.0; // Square
        beta = Math.toDegrees(Math.asin(bCat/cHyp));
        alpha = Math.toDegrees(Math.asin(aCat/cHyp));
    }

    public double Pythagoras(String unknown, double val1, double val2){
        double value = 0.0;
        if (unknown.equals("a") || unknown.equals("b") ){
            value = Math.sqrt(Math.pow(val1,2)-Math.pow(val2,2));
        }
        if (unknown.equals("c") ){
            value = Math.sqrt(Math.pow(val1,2) + Math.pow(val2,2));
        }
        return value;
    }

    
    // Constructor
    //******************************************/
    public Trigonometria(String unknown,double aCat, double bCat, double gamma){
        this.aCat = aCat;
        this.bCat = bCat;
        this.gamma = gamma;
        this.cHyp = Pythagoras(unknown,aCat,bCat);
        
        if (this.gamma == 90.0){
            this.beta = Math.toDegrees(Math.asin(this.bCat/this.cHyp));
            this.alpha = Math.toDegrees(Math.asin(this.aCat/this.cHyp));
        }
    }

    // toString - method with command attribute
    //******************************************/
    public String toString(String command){
        String s = "";
        switch (command){
            case "sin":
                s += "Sini:\n";
                s += "sin(alfa) = a : c\n";
                s += "sin(alfa) = " + this.aCat + " :  " + this.cHyp + "\n";
                s += "sin(alfa) = " + this.aCat / this.cHyp + "\n";
                break;
            case "cos":
                s += "Kosini:\n";
                s += "cos(alfa) = b : c\n";
                s += "cos(alfa) = " + this.bCat + " :  " + this.cHyp + "\n";
                s += "cos(alfa) = " + this.bCat / this.cHyp + "\n";
                break;
            case "tan":
                s += "Tangetti:\n";
                s += "tan(alfa) = a : b\n";
                s += "tan(alfa) = " + this.aCat + " :  " + this.bCat + "\n";
                s += "tan(alfa) = " + this.aCat / this.bCat + "\n";
                break;
            default:
            break;
        }
        return s;
    }

    
    // toString - method 
    //******************************************/
    public String toString(){
        String s = "Suorakulmainen kolmio:\n";
        s += "a: " + this.aCat + " cm\n";
        s += "b: " + this.bCat + " cm\n";
        s += "c: " + this.cHyp + " cm\n";
        s += "alpha: " + Math.round( this.alpha ) + " astetta\n";
        s += "bata: " + Math.round( this.beta )+ " astetta\n";
        return s;
    }

}
