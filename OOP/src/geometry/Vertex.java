package geometry;

public class Vertex {

    private double x;
    private double y;

    public Vertex(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distance(Vertex... vertices) {
        double sumDistance = 0;
        for (int i = 1; i < vertices.length; i++) {
            double differenceXY = Math.pow(vertices[i].getX() - vertices[i - 1].getX(), 2) + Math.pow(vertices[i].getY() - vertices[i - 1].getY(), 2);
            sumDistance += differenceXY;
        }
        double distance = Math.sqrt(sumDistance);
        return distance;
    }

    @Override
    public String toString() {
        return "X = " + this.x + ", Y = " + this.y;
    }
}
