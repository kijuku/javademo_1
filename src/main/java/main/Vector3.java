package main;

public class Vector3 {
    float x; // X component of the point.
    float y; // Y component of the point.
    float z; // Y component of the point.

    public Vector3() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Vector3(float x, float y, float z) {
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

    public void setVector3(float x, float y, float z) {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
    }
    public Vector3 forward(){
        this.setX(0.0f);
        this.setY(0.0f);
        this.setZ(1.0f);
        return this;
    }
    public Vector3 down(){
        this.setX(0.0f);
        this.setY(-1.0f);
        this.setZ(0.0f);
        return this;
    }
    public Vector3 back(){
        this.setX(0.0f);
        this.setY(0.0f);
        this.setZ(-1.0f);
        return this;
    }
    public Vector3 left(){
        this.setX(-1.0f);
        this.setY(0.0f);
        this.setZ(0.0f);
        return this;
    }
    public Vector3 right(){
        this.setX(1.0f);
        this.setY(0.0f);
        this.setZ(0.0f);
        return this;
    }
    public Vector3 up(){
        this.setX(0.0f);
        this.setY(1.0f);
        this.setZ(0.0f);
        return this;
    }
    public Vector3 one(){
        this.setX(1.0f);
        this.setY(1.0f);
        this.setZ(1.0f);
        return this;
    }
    public Vector3 zero(){
        this.setX(0.0f);
        this.setY(0.0f);
        this.setZ(0.0f);
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
