package main;

public class Face extends Vertex {
    protected Vertex [] face = new Vertex [4];
    protected Vertex midPoint = new Vertex();
    protected String name;
   
    public Face(Vertex[] face, Vertex midPoint, String name) {
        this.face = face;
        this.midPoint = midPoint;
        this.name = name;
    }    


    public Face(Point a, Vertex[] face, Vertex midPoint, String name) {
        super(a);
        this.face = face;
        this.midPoint = midPoint;
        this.name = name;
    }    

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


    public Vertex getMidPoint() {
        return this.midPoint;
    }

    public void setMidPoint(Vertex midPoint) {
        this.midPoint = midPoint;
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

    public String toString(String format) {
        String s = "\n";
        switch(format){
            case "Midpoint":
                s += "" + this.getMidPoint() +"\n";
                
            break;
        }

        return s;
    }
}
