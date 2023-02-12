package main;

import java.io.Serializable;

public class Mathematica implements Serializable {
    private double x;
    private double y;
    private double z;
    private double t;

    public Mathematica() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.t = 0.0;
    }

    public Mathematica(double x, double y, double z, double t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
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

    public double getT() {
        return this.t;
    }

    public void setT(double t) {
        this.t = t;
    }

    @Override
    public String toString() {
        String s = "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", z='" + getZ() + "'" +
            ", t='" + getT() + "'" +
            "}";
        return s;
    }
    public String toString(int val){
        String s = "Kertotaulukko ("+ val +"):\n";
        s += "==================\n";
        for (int i = 1; i <= 10; i++){
            s += "" + val + " * " + i + " = " + val*i + "\n";
        }
        return s;
    }
}
