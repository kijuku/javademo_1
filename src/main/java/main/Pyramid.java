package main;

import java.util.ArrayList;

public class Pyramid extends Triangle {
    protected ArrayList<Triangle> pyramidFace = new ArrayList<Triangle>();
    protected ArrayList<Vertex> pyramidVertex = new ArrayList<Vertex>();
    protected ArrayList<Vertex> sideMidVertex = new ArrayList<Vertex>();
    protected Face bottomFace  = new Face();
    protected Vertex midPoint = new Vertex();
    protected Vertex topPoint = new Vertex();
    protected String name;


    public Pyramid() {
    }

    public Pyramid(Point p, double size) {
        this.name = "Default pyramid";
        generatePyramid(p, size);        
    }

     //**********************************************************/
     public Vertex addX(Vertex a, double size){
        Vertex ret = new Vertex();
    
        ret.setX(a.getX() + size);
        ret.setY(a.getY());
        ret.setZ(a.getZ());
        return ret;
    }

    //**********************************************************/
    public Vertex addY(Vertex a, double size){
        Vertex ret = new Vertex();
    
        ret.setX(a.getX());
        ret.setY(a.getY() + size);
        ret.setZ(a.getZ());
        return ret;
    }

    
    //**********************************************************/
    public Vertex addZ(Vertex a, double size){
        Vertex ret = new Vertex();
    
        ret.setX(a.getX());
        ret.setY(a.getY());
        ret.setZ(a.getZ() + size);
        return ret;
    }

    //**********************************************************/
    public Vertex calcMidPoint(Vertex a, Vertex b){
        Vertex ret = new Vertex();
        ret.setX((a.getX()+b.getX())/2);
        ret.setY((a.getY()+b.getY())/2);
        ret.setZ((a.getZ()+b.getZ())/2);
        return ret; 
    }

    //**********************************************************/
    public void generatePyramid(Point p, double size){
        Face face1 = new Face();
        Vertex vertex = new Vertex(p);
        // Face 1
        face1.face[0] = vertex;
        pyramidVertex.add(face1.face[0]);
        face1.face[1] = addX(vertex,size);
        pyramidVertex.add(face1.face[1]);
        face1.face[2] = addY(vertex,size);
        pyramidVertex.add(face1.face[2]);
        face1.face[3] = addY(face1.face[1],size);
        pyramidVertex.add(face1.face[3]);

        // Calculate MidPoint
        face1.midPoint = calcMidPoint(face1.face[0], face1.face[3]);
        this.setMidPoint(face1.midPoint);

        face1.setDiagonal(face1.face[0], face1.face[3]);

        // Calculate side MidPoints
        this.sideMidVertex.add(calcMidPoint(face1.face[0], face1.face[1]));
        this.sideMidVertex.add(calcMidPoint(face1.face[1], face1.face[3]));
        this.sideMidVertex.add(calcMidPoint(face1.face[2], face1.face[3]));
        this.sideMidVertex.add(calcMidPoint(face1.face[0], face1.face[2]));
        
        // Calculate top Point
        topPoint = addZ(this.getMidPoint(), size);

        Triangle tri1 = new Triangle(face1.face[0],face1.face[1],topPoint);
        this.pyramidFace.add(tri1);
  
        Triangle tri2 = new Triangle(face1.face[1],face1.face[3],topPoint);
        this.pyramidFace.add(tri2);
  
        Triangle tri3 = new Triangle(face1.face[3],face1.face[2],topPoint);
        this.pyramidFace.add(tri3);
  
        Triangle tri4 = new Triangle(face1.face[2],face1.face[0],topPoint);
        this.pyramidFace.add(tri4);

        // Set Bottom Face
        this.setBottomFace(face1);
    }

    
    //**********************************************************/
    public Pyramid(Point p, double size, double height) {
    }




    //**********************************************************/
    public ArrayList<Triangle> getPyramidFace() {
        return this.pyramidFace;
    }

    //**********************************************************/
    public void setPyramidFace(ArrayList<Triangle> pyramidFace) {
        this.pyramidFace = pyramidFace;
    }

    //**********************************************************/
    public ArrayList<Vertex> getPyramidVertex() {
        return this.pyramidVertex;
    }

    //**********************************************************/
    public void setPyramidVertex(ArrayList<Vertex> pyramidVertex) {
        this.pyramidVertex = pyramidVertex;
    }

    //**********************************************************/
    public Face getBottomFace() {
        return this.bottomFace;
    }

    //**********************************************************/
    public void setBottomFace(Face bottomFace) {
        this.bottomFace = bottomFace;
    }

    //**********************************************************/
    public Vertex getMidPoint() {
        return this.midPoint;
    }

    //**********************************************************/
    public void setMidPoint(Vertex midPoint) {
        this.midPoint = midPoint;
    }

    //**********************************************************/
    public Vertex getTopPoint() {
        return this.topPoint;
    }

    //**********************************************************/
    public void setTopPoint(Vertex topPoint) {
        this.topPoint = topPoint;
    }

    //**********************************************************/
    public String getName() {
        return this.name;
    }

    //**********************************************************/
    public void setName(String name) {
        this.name = name;
    }

    //**********************************************************/
    public ArrayList<Vertex> getSideMidVertex() {
        return this.sideMidVertex;
    }

    //**********************************************************/
    public void setSideMidVertex(ArrayList<Vertex> sideMidVertex) {
        this.sideMidVertex = sideMidVertex;
    }


    //**********************************************************/
    public String toString(){
        String s = "";

        return s;
    } 
    
    //**********************************************************/
    public String toString(String format){
        String s = "";
        int k = 0;
        switch (format){
            case "JSON":
                s += "(JSON)\n";             
                s += "{\n\"name\" : \"" + this.getName() + "\",\n"; 
                s += "\"type\"  : \"pyramid\",\n";
                s += "\"Vertex\" : {\n";
                k = 1;
                for (Vertex v : this.getPyramidVertex()){
                    if (k < 4) {
                        s += "\"Vertex " + k + "\" : { "  + v.toString("JSON") + "},\n\n";
                    } else {
                        s += "\"Vertex " + k + "\" : { "  + v.toString("JSON") + "}\n\n";
                    }
                    k++;
                }
                s += "},\n";

                
                k = 1;
                s += "\"Triangle Faces\" : {\n";
                
                for (Triangle tri : this.getPyramidFace()) {
                    s += "\"Pyramid Triangle Faces"+ k + "\" : {\n";
                    s += tri.toString("JSON");
                    if (k < 4) {
                        s += "}, \n";
                    } else {
                        s += "} \n";
                    }
                    k++;
                }
                s += "},\n";
                
                k = 1;
                s += "\"Side MidVertex\" : {\n";
                for (Vertex ve : this.getSideMidVertex()) {
                    s += "\"Side MidVertex"+ k + "\" : {\n";
                    s += ve.toString("JSON");
                    if (k < 4) {
                        s += "}, \n";
                    } else {
                        s += "} \n";
                    }
                    k++;
                }
                s += "},\n";
                
                s += "\"Pyramid TopPoint\" : {\n";
                s += "" + this.getTopPoint().toString("JSON") + "\n";             
                s += "},\n";
                
                s += "\"Pyramid Face MidPoint\" : {\n";
                s += "" + this.getMidPoint().toString("JSON") + "\n";             
                s += "\t\t}\n";
                s += "\t}\n";
                s += "";
            break;
        } 
        
        return s;

    } 
}
