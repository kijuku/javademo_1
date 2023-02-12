package main;

import java.io.Serializable;

public class Point implements Serializable {
    double x; // X component of the point.
    double y; // Y component of the point.
    double z; // Y component of the point.

    /**
     * 
     */
    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setPoint(double d, double e, double f) {
        this.setX(d);
        this.setY(e);
        this.setZ(f);
    }

    public Point getPoint() {
        Point p = new Point(this.getX(),this.getY(),this.getZ());
        return p;
    }
    
    public String toString(){
        String s = "";
        s += "x: "+ this.getX() + " ";
        s += "y: "+ this.getY() + " ";
        s += "z: "+this.getZ();
        return s;
    }
    public String toString(String format){
        String s = "";
        switch(format){
            case "F1":            
                s += "x: "+ this.getX() + " ";
                s += "y: "+ this.getY() + " ";
                s += "z: "+this.getZ();
            break;
            case "F2":
                s += "( ";
                s += "X: "+ this.getX() + " ";
                s += "Y: "+ this.getY() + " ";
                s += "Z: "+ this.getZ();
                s += " )";
            break;
            default:
            break;
            
        }
        return s;
    }
 }

