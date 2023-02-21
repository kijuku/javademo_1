package main;

public class Face extends Vertex {
    protected Vertex [] face = new Vertex [4];
    protected String name;


    public Face() {
    }

    public Face(Vertex a, Point b, String name) {

        this.name = name;
    }

    public Face(Vertex[] face, String name) {
        this.face = face;
        this.name = name;
    }


    public Vertex[] getFace() {
        return this.face;
    }

    public void setFace(Vertex[] face) {
        this.face = face;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


   /*  @Override
    public String toString() {
        return "{" +
            " face='" + getFace() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }*/

    public String toString() {
        String s = "\n";
        
        for (Vertex v: this.getFace()  ){
            s += "" + v.toString() +"\n";
        }

        return s;
    }

}
