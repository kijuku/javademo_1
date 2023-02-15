package main;

import java.io.Serializable;

public class Vector2 implements Serializable {
    double x; // X component of the point.
    double y; // Y component of the point.
    
    public Vector2() {
        this.x = 0.0d;
        this.y = 0.0d;
    }


    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVector2(double x, double y) {
        this.setX(x);
        this.setY(y);
    }
    
    public Vector2 forward(){
        this.setX(0.0f);
        this.setY(0.0f);
        return this;
    }

    public double radToDeg(double rad){
        return (180/Math.PI)*rad;
    }

    public double degToRad(double deg){
        return (2*Math.PI/360)*deg;
    }

    /*
     * Rotate Vector2 from Origin 
     */
    public Vector2 rotate(double rad){
        Vector2 v = new Vector2();
        double x1 = this.getX()*Math.cos(rad)-this.getY()*Math.sin(rad);
        double y1 = this.getX()*Math.sin(rad)+this.getY()*Math.cos(rad);

        v.setX(x1);
        v.setY(y1);
        return v;
    }

    
    /*
     * Rotate Vector2 from Origin 
     */
    public Vector2 rotateDeg(double deg){
        Vector2 v = new Vector2();
        double x1 = this.getX()*Math.cos(deg)-this.getY()*Math.sin(deg);
        double y1 = this.getX()*Math.sin(deg)+this.getY()*Math.cos(deg);

        v.setX(x1);
        v.setY(y1);
        return v;
    }

    public String toString(){
        String s = "";
        s += "x: "+  String.format("%.2f",this.getX()) + " ";
        s += "y: "+  String.format("%.2f",this.getY()) ;
        
        return s;
    }
    public String toString(String format){
        String s = "";
        switch(format){
            case "F1":            
                s += "x: "+  String.format("%.2f",this.getX()) + " ";
                s += "y: "+  String.format("%.2f",this.getY());
            break;
            case "F2":
                s += "( ";
                s += "X: "+  String.format("%.2f",this.getX()) + " ";
                s += "Y: "+  String.format("%.2f",this.getY());
                s += " )";
            break;
            default:
            break;
            
        }
        return s;
    }
}
