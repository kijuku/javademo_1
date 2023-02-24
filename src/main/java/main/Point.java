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
        s += "x: "+ String.format("%.2f", this.getX()) + " ";
        s += "y: "+ String.format("%.2f", this.getY()) + " ";
        s += "z: "+ String.format("%.2f", this.getZ());
        return s;
    }

    public String toString(String format){
        String s = "";
        switch(format){
            case "F1":            
                s += "x: "+ String.format("%.2f", this.getX()) + " ";
                s += "y: "+ String.format("%.2f", this.getY()) + " ";
                s += "z: "+ String.format("%.2f", this.getZ());
            break;
            case "F2":
                s += "( ";
                s += "X: "+ String.format("%.2f", this.getX()) + " ";
                s += "Y: "+ String.format("%.2f", this.getY()) + " ";
                s += "Z: "+ String.format("%.2f", this.getZ());
                s += " )";
            break;
            case "CSV":
                s += "";
                s += ""+ String.format("%.2f", this.getX()) + ";";
                s += ""+ String.format("%.2f", this.getY()) + ";";
                s += ""+ String.format("%.2f", this.getZ());
                s += ";";
            break;
            case "JSON":
                s += "";
                s += "\t\"coodinate\": \n";
                s += "\t\t{";
                s += "\n\t\t\"x\" : "+ this.getX() + ",\n";
                s += "\t\t\"y\" : "+ this.getY() + ",\n";
                s += "\t\t\"z\" : "+ this.getZ();
                s += "\n\t\t}\n\t\t \n";
            break;
            case "JSONCOM":
                s += "";
                s += "\"coodinate\":  ";
                s += "{\n\"x\" : "+ this.getX() + ", ";
                s += "\"y\" : "+ this.getY() + ", ";
                s += "\"z\" : "+ this.getZ();
                s += "}\n  ";
            break;
            case "JSONARRAY":
                s += "";
                s += ""+ this.getX() + ",";
                s += ""+ this.getY() + ",";
                s += ""+ this.getZ();
                s += "";
            break;
            default:
            break;
            
        }
        return s;
    }
 }

