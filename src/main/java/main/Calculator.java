package main;

import java.io.Serializable;

public class Calculator implements Serializable {
    private double area;
    private double perimeter;
    private String areaStr;
    private String perimeterStr;

    public Calculator(){
        this.area = 0.0d;
        this.perimeter = 0.0d;
        this.perimeterStr = "";
        this.areaStr = "";
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

    public String getAreaStr() {
        return this.areaStr;
    }

    public void setAreaStr(String areaStr) {
        this.areaStr = areaStr;
    }

    public String getPerimeterStr() {
        return this.perimeterStr;
    }

    public void setPerimeterStr(String perimeterStr) {
        this.perimeterStr = perimeterStr;
    }


    public void reset(){
        this.setArea(0.0d);
        this.setPerimeter(0.0d);
        this.setAreaStr("");
        this.setPerimeterStr("");
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
        this.setAreaStr("" + String.format("%.2f", sideA) + " * " + 
        String.format("%.2f", sideB) + " = " + String.format("%.2f", this.getArea()));

        return this.getArea();
    }

    public boolean pythagoras(double a, double b, double c){
        double sumab = a*a + b*b;
        double sumc = c*c;
        if (sumc == sumab)
            return true;
        else 
            return false;
    }

    public double area(Triangle triangle){
        Vector3[] v3 = new Vector3[3];
        v3[0] = new Vector3(triangle.getPointA().getX(),triangle.getPointA().getY(),triangle.getPointA().getZ());
        v3[1] = new Vector3(triangle.getPointB().getX(),triangle.getPointB().getY(),triangle.getPointB().getZ());
        v3[2] = new Vector3(triangle.getPointC().getX(),triangle.getPointC().getY(),triangle.getPointC().getZ());
        
        double hypo, kate1, kate2;
        double sideA = length(v3[0], v3[1]);
        double sideB = length(v3[0], v3[2]);
        double sideC = length(v3[1], v3[2]);
        if (sideA < sideB){
            if (sideB < sideC){
                kate1 = sideA;
                kate2 = sideB;
                hypo = sideC;
            } else {
                kate1 = sideA;
                kate2 = sideC;
                hypo = sideB;
            }
        } else {
            if (sideA < sideC){
                kate1 = sideA;
                kate2 = sideB;
                hypo = sideC;
            } else {
                kate1 = sideC;
                kate2 = sideB;
                hypo = sideA;
            }
        }

        if (pythagoras(kate1, kate2, hypo)){
            this.setArea((kate1*kate2)/2);
            this.setAreaStr("( "+ kate1+ " * " + kate2 +" ) / 2 = " + this.getArea());
        } else {
            this.setArea(0.0d);
            this.setAreaStr(""+ kate1+ ", " + kate2 +" ," + hypo + " Ei osata vielä!");
        }


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

        this.setPerimeterStr("" + String.format("%.2f", sideA) + " + " + 
        String.format("%.2f", sideB) + " + " + 
        String.format("%.2f", sideD) + " + " + 
        String.format("%.2f", sideC) + " = " +
        String.format("%.2f", this.getPerimeter()) );

        return this.getPerimeter();
    }

    
    public double perimeter(Triangle triangle){
        for (int i = 0; i < 3; i++){

        }
        return this.getPerimeter();
    }

    public double radToDeg(double rad){
        return (180/Math.PI)*rad;
    }

    public double degToRad(double deg){
        return (2*Math.PI/360)*deg;
    }
    
}

