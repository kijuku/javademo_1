package main;

import java.io.Serializable;

public class Transform implements Serializable {
    String name;
    Point p;

    public Transform(String name, double x, double y, double z) {
        this.name = name;
        this.p = new Point(x,y,z);
    }

    public Transform(String name, Point p) {
        this.name = name;
        this.p = p;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getP() {
        return this.p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public String toString(){
        String s = "";
        s += "Name: " + this.getName() + "\n";
        s += this.p.toString();
        return s;
    }
}
