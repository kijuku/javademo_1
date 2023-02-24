package main;

public class Face extends Vertex {
    protected Vertex [] face = new Vertex [4];
    protected Vertex midPoint = new Vertex();
    protected String name;
    protected double diagonal;
   
    /***************************************************************************/
    public Face(Vertex[] face, Vertex midPoint, String name) {
        this.face = face;
        this.midPoint = midPoint;
        this.name = name;
    }    


    /***************************************************************************/
    public Face(Point a, Vertex[] face, Vertex midPoint, String name) {
        super(a);
        this.face = face;
        this.midPoint = midPoint;
        this.name = name;
        this.diagonal = 0.0D;
    }    

    /***************************************************************************/
    public Face() {
    }

    /***************************************************************************/
    public Face(Vertex a, Point b, String name) {

        this.name = name;
        this.diagonal = 0.0D;
    }

    /***************************************************************************/
    public Face(Vertex[] face, String name) {
        this.face = face;
        this.name = name;
        this.diagonal = 0.0D;
    }


    /***************************************************************************/
    public Vertex[] getFace() {
        return this.face;
    }

    /***************************************************************************/
    public void setFace(Vertex[] face) {
        this.face = face;
    }

    /***************************************************************************/
    public String getName() {
        return this.name;
    }

    /***************************************************************************/
    public void setName(String name) {
        this.name = name;
    }


    /***************************************************************************/
    public Vertex getMidPoint() {
        return this.midPoint;
    }

    /***************************************************************************/
    public void setMidPoint(Vertex midPoint) {
        this.midPoint = midPoint;
    }

    /***************************************************************************/
    public double getDiagonal() {
        return this.diagonal;
    }

    /***************************************************************************/
    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    /*
     * length - method calculates length between two points. 
     */
    /***************************************************************************/
    public double diagonal(Point point, Point point2){
        
        double x = (point.getX() - point2.getX())*(point.getX() - point2.getX());
        double y = (point.getY() - point2.getY())*(point.getY() - point2.getY());
        double z = (point.getZ() - point2.getZ())*(point.getZ() - point2.getZ());
        double sum = x+y+z;
        return (double)(Math.sqrt(sum));
    }

    /***************************************************************************/    
    public void setDiagonal(Vertex vertex, Vertex vertex2) {
        double x = (vertex.getX() - vertex2.getX())*(vertex.getX() - vertex2.getX());
        double y = (vertex.getY() - vertex2.getY())*(vertex.getY() - vertex2.getY());
        double z = (vertex.getZ() - vertex2.getZ())*(vertex.getZ() - vertex2.getZ());
        double sum = x+y+z;
        this.diagonal = (double)(Math.sqrt(sum));
    }
    
    /* toString() - method */
    /***************************************************************************/
    public String toString() {
        String s = "\n";
        
        for (Vertex v: this.getFace()  ){
            s += "" + v.toString() +"\n";
        }

        return s;
    }

    /* toString( String format ) - method */
    /***************************************************************************/
    public String toString(String format) {
        String s = "\n";
        int k = 1;
        switch(format){
            case "Midpoint":
                s += "" + this.getMidPoint() +"\n";
                
            break;
            case "Diagonal":
                s += "" + this.getDiagonal() +" cm \n";
            
            break;
            case "CSV":
                s += "" + this.getMidPoint().toString("CSV") +";\n";
                
            break;
            case "JSON":
                s += "" + this.getMidPoint().toString("JSON") +"\n";
            break;
            case "JSONFACE":
                k = 1;
                for(Vertex v : this.getFace()){
                    if (k < 4){
                        s += "\"FaceVertex"+k+"\":{" + v.toString("JSON") +"},\n";
                    }else{
                        s += "\"FaceVertex"+k+"\":{" + v.toString("JSON") +"}\n";
                    }
                    k++;
                }
            break;
            case "JSONCOM":
                s += "" + this.getMidPoint().toString("JSONCOM") +"\n";
                
            break;
            case "JSONARRAY":
                k = 1;
                for(Vertex v : this.getFace()){
                    if (k < 4){
                        s += "\t[" + v.toString("JSONARRAY") +"],\n";
                    }else{
                        s += "\t[" + v.toString("JSONARRAY") +"]\n";
                    }
                    k++;
                }
            break;
            case "JSONMIDPOINT":
                s += "" + this.getMidPoint().toString("JSONARRAY") +"\n";
                
            break;
        }

        return s;
    }


}
