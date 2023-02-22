package main;

import java.util.ArrayList;

public class Cube extends Face {
    protected ArrayList<Face> cube = new ArrayList<Face>();
    protected ArrayList<Vertex> cubeVertex = new ArrayList<Vertex>();
    protected Vertex midPoint = new Vertex();
    protected String name;


    //**********************************************************/
    public Cube() {
    }

    //**********************************************************/
    public Cube(Point a, double size) {
        generateCube(a,size);
        this.name = "default Cube";
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

    /***************************************************************************/
    private void generateCube(Point a, double size){
        Face face1 = new Face();
        Vertex vertex = new Vertex(a);
        // Face 1
        face1.face[0] = vertex;
        cubeVertex.add(face1.face[0]);
        face1.face[1] = addX(vertex,size);
        cubeVertex.add(face1.face[1]);
        face1.face[2] = addY(vertex,size);
        cubeVertex.add(face1.face[2]);
        face1.face[3] = addY(face1.face[1],size);
        cubeVertex.add(face1.face[3]);
        face1.midPoint = calcMidPoint(face1.face[0], face1.face[3]);
        face1.setDiagonal(face1.face[0], face1.face[3]);
        cube.add(face1);

        
        Face face2 = new Face();
        face2.face[0] = addZ(face1.face[0],size);
        cubeVertex.add(face2.face[0]);
        face2.face[1] = addZ(face1.face[1],size);
        cubeVertex.add(face2.face[1]);
        face2.face[2] = addZ(face1.face[2],size);
        cubeVertex.add(face2.face[2]);
        face2.face[3] = addZ(face1.face[3],size);
        cubeVertex.add(face2.face[3]);
        face2.midPoint = calcMidPoint(face2.face[0], face2.face[3]);
        face2.setDiagonal(face2.face[0], face2.face[3]);
        cube.add(face2);

        // Calculate Cube Midpoint
        this.setMidPoint(calcMidPoint(face1.face[0], face2.face[3]));
        
        Face face3 = new Face();
        face3.face[0] = face1.face[0];
        face3.face[1] = face1.face[1];
        face3.face[2] = face2.face[0];
        face3.face[3] = face2.face[1];
        face3.midPoint = calcMidPoint(face3.face[0], face3.face[3]);
        face3.setDiagonal(face3.face[0], face3.face[3]);
        cube.add(face3);

        Face face4 = new Face();
        face4.face[0] = face1.face[1];
        face4.face[1] = face1.face[3];
        face4.face[2] = face2.face[1];
        face4.face[3] = face2.face[3];
        face4.midPoint = calcMidPoint(face4.face[0], face4.face[3]);
        face4.setDiagonal(face4.face[0], face4.face[3]);
        cube.add(face4);

        Face face5 = new Face();
        face5.face[0] = face1.face[3];
        face5.face[1] = face1.face[2];
        face5.face[2] = face2.face[3];
        face5.face[3] = face2.face[2];
        face5.midPoint = calcMidPoint(face5.face[0], face5.face[3]);
        face5.setDiagonal(face5.face[0], face5.face[3]);
        cube.add(face5);

        Face face6 = new Face();
        face6.face[0] = face1.face[2];
        face6.face[1] = face1.face[0];
        face6.face[2] = face2.face[2];
        face6.face[3] = face2.face[0];
        face6.midPoint = calcMidPoint(face6.face[0], face6.face[3]);
        face6.setDiagonal(face6.face[0], face6.face[3]);
        cube.add(face6);

        
    }

    //**********************************************************/
    public Cube(Vertex a, double size) {

    }

    //**********************************************************/
    public Cube(Face face) {
    }

    //**********************************************************/
    public ArrayList<Face> getCube() {
        return this.cube;
    }

    //**********************************************************/
    public void setCube(ArrayList<Face> cube) {
        this.cube = cube;
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
    public ArrayList<Vertex> getCubeVertex() {
        return this.cubeVertex;
    }

    //**********************************************************/
    public void setCubeVertex(ArrayList<Vertex> cubeVertex) {
        this.cubeVertex = cubeVertex;
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
    public String toString(){
        String s = "Cube:\n";
        int k = 1;
        for (Face v : this.getCube()){
            s += "Face " + k + ": "  + v.toString() + "\n";
            k++;
        }
        
        return s;
    }

    //**********************************************************/
    public String toString(String format){
        String s = "";
        int k = 0;
        switch (format){
            case "Vertex": 
                s = "Vertex:\n";
                k = 1;
                for (Vertex v : this.getCubeVertex()){
                    s += "Vertex " + k + ": "  + v.toString() + "\n";
                    k++;
                }
            break;
            case "Midpoint": 
                s = "MidPoints:\n";
                k = 1;
                for (Face face : this.getCube()){
                    s += "Face " + k + " MidPoint: "  + face.toString("Midpoint") + "\n";
                    k++;
                }
            break;
            case "Cubemidpoint":
                s = "Cube MidPoint:\n";
                s += "" + this.getMidPoint() + "\n";            
            break;
            case "Diagonal":
                s = "Cube Face Diagonal:\n";
                k = 1;
                for (Face face : this.getCube()){
                    s += "Face " + k + " Diagonal: "  + face.toString("Diagonal") + "\n";
                    k++;
                }
            break;
            case "CSV":
                s = "Vertex:\n";
                k = 1;
                for (Vertex v : this.getCubeVertex()){
                    s += "Vertex " + k + ": "  + v.toString() + "\n";
                    k++;
                }
                s += "MidPoints:\n";
                k = 1;
                for (Face face : this.getCube()){
                    s += "Face " + k + " MidPoint: "  + face.toString("Midpoint") + "\n";
                    k++;
                }
                s += "Cube MidPoint:\n";
                s += "" + this.getMidPoint() + "\n";            
            break;
            case "JSON":
                s += "(JSON)\n";             
                s += "{ \"name\" : \"" + this.getName() + "\",\n"; 
                s += "\"type\"  : \"cube\",\n";
                s += "\"Vertex\" : {\n";
                k = 1;
                for (Vertex v : this.getCubeVertex()){
                    if (k < 8) {
                        s += "\"Vertex " + k + "\" : { "  + v.toString("JSON") + "},\n\n";
                    } else {
                        s += "\"Vertex " + k + "\" : { "  + v.toString("JSON") + "}\n\n";
                    }
                    k++;
                }
                s += "},\n";
                s += "\"MidPoints\" : {\n";
                k = 1;
                for (Face face : this.getCube()){
                    if (k < 6){
                        s += "\"Face " + k + " MidPoint\" : { "  + face.toString("JSON") + "},\n\n";
                    } else {
                        s += "\"Face " + k + " MidPoint\" : { "  + face.toString("JSON") + "}\n\n";
                    }
                    k++;
                }
                s += "},\n";
                // Face
                s += "\"Faces\" : {\n";
                k = 1;
                for (Face face : this.getCube()){
                    if (k < 6){
                        s += "\"Face " + k + "\" : { \n"  + face.toString("JSONFACE") + "}\n,\n\n";
                    } else {
                        s += "\"Face " + k + "\" : { \n"  + face.toString("JSONFACE") + "}\n\n\n";
                    }
                    k++;
                }
                s += "\n},\n";

                s += "\"Cube MidPoint\" : {\n";
                s += "" + this.getMidPoint().toString("JSON") + "\n";             
                s += "\t\t}\n";
                s += "\t}\n";
                s += "";

            break;
    
            case "JSONCOM":
                s = "Vertex:\n";
                k = 1;
                for (Vertex v : this.getCubeVertex()){
                    s += "Vertex " + k + ": "  + v.toString() + "\n";
                    k++;
                }
                s += "MidPoints:\n";
                k = 1;
                for (Face face : this.getCube()){
                    s += "Face " + k + " MidPoint: "  + face.toString("Midpoint") + "\n";
                    k++;
                }
                s += "Cube MidPoint:\n";
                s += "" + this.getMidPoint() + "\n";
             break;
        } 
        
        return s;
    }


}
