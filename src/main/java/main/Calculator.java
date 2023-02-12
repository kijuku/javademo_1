package main;

import java.io.Serializable;

public class Calculator implements Serializable {
    private double area;
    private double perimeter;

    public Calculator(){
        this.area = 0.0d;
        this.perimeter = 0.0d;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    
    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    /*
     * length - method calculates length between two points. 
     */
    public double length(Point p1, Point p2){
        
        double x = (p1.getX() - p2.getX())*(p1.getX() - p2.getX());
        double y = (p1.getY() - p2.getY())*(p1.getY() - p2.getY());
        double z = (p1.getZ() - p2.getZ())*(p1.getZ() - p2.getZ());
        double sum = x+y+z;
        return (double)(Math.sqrt(sum));
    }

    public double length(Vector3 p1, Vector3 p2){
        
        double x = (p1.getX() - p2.getX())*(p1.getX() - p2.getX());
        double y = (p1.getY() - p2.getY())*(p1.getY() - p2.getY());
        double z = (p1.getZ() - p2.getZ())*(p1.getZ() - p2.getZ());
        double sum = x+y+z;
        return (double)(Math.sqrt(sum));
    }
    /*
     * point1 -> point2 = sideA, 
     * point1 -> point3 = sideB, 
     */
    public double area(Square square){
        Vector3[] v3 = new Vector3[4];
       
        for (int i = 0; i < 4; i++){
           v3[i] = new Vector3(square.getCorner(i).getX(),square.getCorner(i).getY(),square.getCorner(i).getZ());     
        }

        double sideA = length(v3[0], v3[1]);
        double sideB = length(v3[0], v3[2]);

        this.setArea(sideA*sideB);

        return this.getArea();
    }

    public double area(Triangle triangle){
        Vector3[] v3 = new Vector3[3];
       
        return this.getArea();

    }

    /*
     * point1 -> point2 = sideA, 
     * point1 -> point3 = sideB, 
     * point2 -> point4 = sideC, 
     * point3 -> point4 = sideD, 
     */
    public double perimeter(Square square){
        Vector3[] v3 = new Vector3[4];
       
        for (int i = 0; i < 4; i++){
            v3[i] = new Vector3(square.getCorner(i).getX(),square.getCorner(i).getY(),square.getCorner(i).getZ());     
        }

        double sideA = length(v3[0], v3[1]);
        double sideB = length(v3[0], v3[2]);
        
        double sideC = length(v3[1], v3[3]);
        
        double sideD = length(v3[2], v3[3]);

        this.setPerimeter(sideA+sideB+sideC+sideD);

        return this.getPerimeter();
    }

    
    public double perimeter(Triangle triangle){
        for (int i = 0; i < 3; i++){

        }
        return this.getPerimeter();
    }
}

