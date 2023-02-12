package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Square implements Serializable {
    private Point [] corner = new Point[4];
    private String name;

    public Square() {
        for (int i = 0; i < corner.length; i++) {
            this.corner[i] = new Point(0.0d, 0.0d, 0.0d);
        }
        
        this.name = "Square def";
    }
    public Square(String name) {
        for (int i = 0; i < corner.length; i++) {
            this.corner[i] = new Point(0.0d, 0.0d, 0.0d);
        }
        
        this.name = name;
    }

    public Square(ArrayList<Point> corner, String name) {
        int i = 0;
        for (Point p : corner){
            this.corner[i] = new Point(p.getX(), p.getY(), p.getZ());
            i++;
        }

        
        this.name = name;
    }

    public Square(Point[] corner, String name) {
        this.corner = corner;
        this.name = name;
    }

    public Point[] getCorner() {
        return this.corner;
    }

    public Point getCorner(int index) {
        return this.corner[index];
    }

    public void setCorner(Point[] corner) {
        this.corner = corner;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Print - name and corner coordinates to String.
     */
    public String toString(){
        String s = "\n"+  this.getName() + ": \n";
        for (Point p : this.getCorner()){
            s += "" + p.toString() +"\n";
        }
        
        return s;
    }

}
