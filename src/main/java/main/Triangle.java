package main;

import java.io.Serializable;

public class Triangle implements Serializable {
    protected String name;
    protected Point pointA;
    protected Point pointB;
    protected Point pointC;

    public Triangle() {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        this.name = "";
        this.pointA = p1;
        this.pointB = p2;
        this.pointC = p3;
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.name = "";
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Triangle(String name, Point pointA, Point pointB, Point pointC) {
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPointA() {
        return this.pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return this.pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return this.pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public double length(Point p1, Point p2){
        
        double x = (p1.getX() - p2.getX())*(p1.getX() - p2.getX());
        double y = (p1.getY() - p2.getY())*(p1.getY() - p2.getY());
        double z = (p1.getZ() - p2.getZ())*(p1.getZ() - p2.getZ());
        double sum = x+y+z;
        return (double)(Math.sqrt(sum));
    }

    public double calculateSides(String name){
        double val = 0.0f;
        switch (name){
            case "A":
                val = length(pointA, pointB);
            break;
            case "B":
                val = length(pointA, pointC);
            break;
            case "C":
                val = length(pointB, pointC);
            break;
        }

        return val;
    }

    public String toString() {
        String s = "";
        s += this.name + ": \n";
        s += "[ (" + this.pointA.toString() + "), (";
        s += this.pointB.toString() + "),(";
        s += this.pointC.toString() + ") ]";

        return s;
    }


    public String toString(String format) {
        String s = "";
        switch(format){
            case "JSON":
                s += "\"TriangleVertex" + this.name + "1\" : { \n";
                s += "" + this.pointA.toString("JSON") + "},\n";
                s += "\"TriangleVertex" + this.name + "2\" : \n  {\n";
                s += "" + this.pointB.toString("JSON") + "},\n";
                s += "\"TriangleVertex" + this.name + "3\" : \n  {\n";
                s += "" + this.pointC.toString("JSON") + " }\n";
            break;
            case "JSONARRAY":
                s += "";
                s += "[" + this.pointA.toString("JSONARRAY") + "],";
                s += "";
                s += "[" + this.pointB.toString("JSONARRAY") + "],";
                s += "";
                s += "[" + this.pointC.toString("JSONARRAY") + "]";
            break;

        }

        return s;
    }
}