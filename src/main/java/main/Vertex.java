package main;

public class Vertex extends Point {
    protected Point vertex = new Point();

    public Vertex() {
    }

    public Vertex(Point a) {
        this.x = a.getX();
        this.y = a.getY();
        this.z = a.getZ();
    }

    public Point getVertex() {
        return this.vertex;
    }

    public void setVertex(Point vertex) {
        this.vertex = vertex;
    }

    public Vertex getVertex(Cube cube) {
        return this;
    }

}
