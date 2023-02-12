package main;

import java.io.Serializable;

public class Vector2 implements Serializable {
    float x; // X component of the point.
    float y; // Y component of the point.
    
    public Vector2() {
        this.x = 0.0f;
        this.y = 0.0f;
    }


    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
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

    public void setVector2(float x, float y) {
        this.setX(x);
        this.setY(y);
    }
    
    public Vector2 forward(){
        this.setX(0.0f);
        this.setY(0.0f);
        return this;
    }
    public String toString(){
        String s = "";
        s += "x: "+ this.getX() + " ";
        s += "y: "+ this.getY() ;
        
        return s;
    }
    public String toString(String format){
        String s = "";
        switch(format){
            case "F1":            
                s += "x: "+ this.getX() + " ";
                s += "y: "+ this.getY();
            break;
            case "F2":
                s += "( ";
                s += "X: "+ this.getX() + " ";
                s += "Y: "+ this.getY();
                s += " )";
            break;
            default:
            break;
            
        }
        return s;
    }
}
