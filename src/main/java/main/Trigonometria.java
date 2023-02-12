package main;

import java.io.Serializable;
import java.lang.Math;
import java.text.DecimalFormat;

public class Trigonometria implements Serializable {
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

    
    // Pythagoras - method
    // Attributes:
    //      String:     unknow  - Example "a"
    //      double:     val1    - Example 2.0
    //      double:     val2    - Example 6.0
    //
    // Return value:
    //      double:     value   - Calculate unknown tringle side
    //******************************************/
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


    public double getACat() {
        return this.aCat;
    }

    public void setACat(double aCat) {
        this.aCat = aCat;
    }

    public double getBCat() {
        return this.bCat;
    }

    public void setBCat(double bCat) {
        this.bCat = bCat;
    }

    public double getCHyp() {
        return this.cHyp;
    }

    public void setCHyp(double cHyp) {
        this.cHyp = cHyp;
    }

    public double getAlpha() {
        return this.alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getBeta() {
        return this.beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getGamma() {
        return this.gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
    }

    // toString - method with command attribute
    //******************************************/
    public String toString(String command){
        DecimalFormat df = new DecimalFormat("#.###");
        String s = "";
        switch (command){
            case "sin":
                s += "Sini:\n";
                s += "sin(alfa) = a : c\n";
                s += "sin(alfa) = " + df.format(getACat()) + " :  " + df.format(getCHyp()) + "\n";
                s += "sin(alfa) = " + df.format(getACat() / getCHyp()) + "\n";
                break;
            case "cos":
                s += "Kosini:\n";
                s += "cos(alfa) = b : c\n";
                s += "cos(alfa) = " + df.format(getBCat()) + " :  " + df.format(getCHyp()) + "\n";
                s += "cos(alfa) = " + df.format(getBCat() / getCHyp()) + "\n";
                break;
            case "tan":
                s += "Tangetti:\n";
                s += "tan(alfa) = a : b\n";
                s += "tan(alfa) = " + df.format(getACat()) + " :  " + df.format(getBCat()) + "\n";
                s += "tan(alfa) = " + df.format(getACat() / getBCat()) + "\n";
                break;
            default:
            break;
        }
        return s;
    }

    
    // toString - method 
    //******************************************/
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        String s = "Suorakulmainen kolmio:\n";
        s += "a: " + df.format(getACat()) + " cm\n";
        s += "b: " + df.format(getBCat()) + " cm\n";
        s += "c: " + df.format(getCHyp()) + " cm\n";
        s += "alpha: " + df.format( getAlpha() ) + " astetta\n";
        s += "bata: " + df.format( getBeta() )+ " astetta\n";
        return s;
    }

}
