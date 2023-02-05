package main;

public class Triangle {
    private String name;
    private Point pointA;
    private Point pointB;
    private Point pointC;

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

    public String toString() {
        String s = "";
        s += this.name + ": \n";
        s += "[ (" + this.pointA.toString() + "), (";
        s += this.pointB.toString() + "),(";
        s += this.pointC.toString() + ") ]";

        return s;
    }

}