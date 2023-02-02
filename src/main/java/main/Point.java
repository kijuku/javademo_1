package main;

public class Point {
    float x; // X component of the point.
    float y; // Y component of the point.
    float z; // Y component of the point.

    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return this.z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setPoint(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
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

