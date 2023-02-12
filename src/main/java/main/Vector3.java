package main;
import java.io.Serializable;
import java.lang.Math;

public class Vector3 implements Serializable {
    double x; // X component of the point.
    double y; // Y component of the point.
    double z; // Y component of the point.

    public Vector3() {
        this.x = 0.0d;
        this.y = 0.0d;
        this.z = 0.0d;
    }

    public Vector3(Point p) {
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }

    public Vector3(double x, double y, double z) {
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

    public void setVector3(double x, double y, double z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
   
    public void setPoint(Point point) {
        this.setX(point.getX());
        this.setY(point.getY());
        this.setZ(point.getZ());
    }
    
    public Vector3 forward(){
        this.setX(0.0d);
        this.setY(0.0d);
        this.setZ(1.0d);
        return this;
    }
    public Vector3 down(){
        this.setX(0.0d);
        this.setY(-1.0d);
        this.setZ(0.0d);
        return this;
    }
    public Vector3 back(){
        this.setX(0.0d);
        this.setY(0.0d);
        this.setZ(-1.0d);
        return this;
    }
    public Vector3 left(){
        this.setX(-1.0d);
        this.setY(0.0d);
        this.setZ(0.0d);
        return this;
    }
    public Vector3 right(){
        this.setX(1.0d);
        this.setY(0.0d);
        this.setZ(0.0d);
        return this;
    }
    public Vector3 up(){
        this.setX(0.0d);
        this.setY(1.0d);
        this.setZ(0.0d);
        return this;
    }
    public Vector3 one(){
        this.setX(1.0d);
        this.setY(1.0d);
        this.setZ(1.0d);
        return this;
    }
    public Vector3 zero(){
        this.setX(0.0d);
        this.setY(0.0d);
        this.setZ(0.0d);
        return this;
    }

    public Vector3 add(Vector3 a, Vector3 b){
        Vector3 ret = new Vector3();

        ret.setX(a.getX()+b.getX());
        ret.setY(a.getY()+b.getY());
        ret.setZ(a.getZ()+b.getZ());
        return ret;
    }
    
    public Vector3 add(Vector3 a){
        this.setX(this.getX()+a.getX());
        this.setY(this.getY()+a.getY());
        this.setZ(this.getZ()+a.getZ());
        return this;
    }

    public Vector3 decrease(Vector3 a, Vector3 b){
        Vector3 ret = new Vector3();

        ret.setX(a.getX()-b.getX());
        ret.setY(a.getY()-b.getY());
        ret.setZ(a.getZ()-b.getZ());
        return ret;
    }

    public Vector3 decrease(Vector3 a){
        this.setX(this.getX()-a.getX());
        this.setY(this.getY()-a.getY());
        this.setZ(this.getZ()-a.getZ());
        return this;
    }

    public Vector3 mulScalar(double k){
        this.setX(this.getX() * k);
        this.setY(this.getY() * k);
        this.setZ(this.getZ() * k);
        return this;
    }

    public double norm(){
        double x2 = (this.getX()*this.getX());
        double y2 = (this.getY()*this.getY());
        double z2 = (this.getZ()*this.getZ());
        double sum = (double)(x2+y2+z2);
        return (double)(Math.sqrt(sum));
    }

    public double dotProduct(Vector3 a, Vector3 b){
        Vector3 dotProd = new Vector3();
        dotProd.setX(a.getX() * b.getX());
        dotProd.setY(a.getX() * b.getX());
        dotProd.setZ(a.getX() * b.getX());
        double sum = dotProd.getX()+dotProd.getY()+dotProd.getZ();
        return sum;
    }

    public double dotProduct(Vector3 a){
        Vector3 dotProd = new Vector3();
        dotProd.setX(a.getX() * this.getX());
        dotProd.setY(a.getY() * this.getY());
        dotProd.setZ(a.getZ() * this.getZ());

        double sum = dotProd.getX()+dotProd.getY()+dotProd.getZ();
        return sum;
    }

    public Vector3 crossProduct(Vector3 a, Vector3 b){
        Vector3 cProd1 = new Vector3();
        Vector3 cProd2 = new Vector3();
        Vector3 ret = new Vector3();

        cProd1.setX(a.getY() * b.getZ());
        cProd1.setY(a.getZ() * b.getX());
        cProd1.setZ(a.getX() * b.getY());

        cProd2.setX(a.getZ() * b.getY());
        cProd2.setY(a.getX() * b.getZ());
        cProd2.setZ(a.getY() * b.getX());
        ret.setX(cProd1.getX()-cProd2.getX());
        ret.setY(cProd1.getY()-cProd2.getY());
        ret.setZ(cProd1.getZ()-cProd2.getZ());        
        return ret;
    }

    public Vector3 mulScalar(Vector3 a, double k){
        Vector3 ret = new Vector3();

        ret.setX(a.getX() * k);
        ret.setY(a.getY() * k);
        ret.setZ(a.getZ() * k);
        return ret;
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
            case "F3":
                s += "( ";
                s += ""+ this.getX() + ", ";
                s += ""+ this.getY() + ", ";
                s += ""+ this.getZ();
                s += " )";
            break;
            default:
            break;
            
        }
        return s;
    }
}
