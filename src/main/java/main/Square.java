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

    /*
     * Square (p1 , p4 , name) - constructor
     * 
     * p2 (p1.x,p4.y,p4z)         p4  
     * ***************************o
     * *                          *
     * o***************************
     * p1          p3 (p4.x,p1.y,p1.z)  
     */
    public Square(Point cornerA, Point cornerD, String name) {
        this.corner[0] = new Point(cornerA.getX(), cornerA.getY(), cornerA.getZ());

        this.corner[3] = new Point(cornerD.getX(), cornerD.getY(), cornerD.getZ());
            
        this.corner[1] = new Point(cornerA.getX(), cornerD.getY(), cornerD.getZ());
        this.corner[2] = new Point(cornerD.getX(), cornerA.getY(), cornerA.getZ());
        
        this.name = name;
    }

     /*
     * Square (p1 , distance , name) - constructor
     * 
     * p2 (p1.x,p1.y+d,p1z)         p4 (p1.x+d,p1.y+d,p1.z) 
     * ***************************o
     * *                          *
     * o***************************
     * p1          p3 (p1.x+d,p1.y,p1.z)  
     */

    public Square(Point cornerA, double distance, String name) {
        this.corner[0] = new Point(cornerA.getX(), cornerA.getY(), cornerA.getZ());
            
        this.corner[1] = new Point(cornerA.getX(), cornerA.getY()+distance, cornerA.getZ());
        this.corner[2] = new Point(cornerA.getX()+distance, cornerA.getY(), cornerA.getZ());
        this.corner[3] = new Point(cornerA.getX()+distance, cornerA.getY()+distance, cornerA.getZ());
        
        
        this.name = name;
    }

     /*
     * Square (p1 , dis1, dis2 , name) - constructor
     * 
     * p2 (p1.x,p1.y+d1,p1z)      p4 (p1.x+d2,p1.y+d1,p1.z) 
     * ***************************o
     * *                          *
     * o***************************
     * p1                         p3 (p1.x+d2,p1.y,p1.z)  
     */
     public Square(Point cornerA, double distance1, double distance2, String name) {
        this.corner[0] = new Point(cornerA.getX(), cornerA.getY(), cornerA.getZ());
            
        this.corner[1] = new Point(cornerA.getX(), cornerA.getY() + distance1, cornerA.getZ());
        this.corner[2] = new Point(cornerA.getX() + distance2, cornerA.getY(), cornerA.getZ());
        this.corner[3] = new Point(cornerA.getX() + distance2, cornerA.getY() + distance1, cornerA.getZ());
        
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
        int i = 1;
        String s = "\n"+  this.getName() + ": \n";
        for (Point p : this.getCorner()){
            s += "p" + i + ": [ " + p.toString() +" ]\n";
            i++;
        }
        
        return s;
    }

    /*
     * Print - name and corner coordinates to String.
     */
    public String toString(String format){
        int i = 1;
        String s = "\n"+  this.getName() + ": \n";
        switch (format){
            case "CSV":  
                s += "(CSV)\n"; 
                s += "name;pointname;x;y;z;\n";            
                for (Point p : this.getCorner()){
                    s += "" + this.getName() + ";p" + i + "; " + p.toString("CSV") +"\n";
                    i++;
                }
            break;
            case "JSON":  
                s += "(JSON)\n";             
                s += "{\n\"name:\" : \"" + this.getName() + "\",\n"; 
                s += "\"square\" : [\n";
                for (Point p : this.getCorner()){
                    s += "\t{\n\t\"pointname\" : \"p" + i + "\",\n";
                    s += p.toString("JSON");
                    if (this.getCorner().length == i){
                        s += " \t} \n";
                    } else {
                        s += " \t}, \n";
                    }
                    i++;
                }
                s += " ] \n} \n";
            break;
            case "JSONCOM":  
                s += "(JSON)\n";             
                s += "{ \"name:\" : \"" + this.getName() + "\","; 
                s += "\"square\" : [";
                for (Point p : this.getCorner()){
                    s += " { \"pointname\" : \"p" + i + "\", ";
                    s += p.toString("JSONCOM");
                    if (this.getCorner().length == i){
                        s += " } ";
                    } else {
                        s += " }, ";
                    }
                    i++;
                }
                s += " ] }";
            break;
            default:
            break;            
        }
        
        return s;
    }

}
