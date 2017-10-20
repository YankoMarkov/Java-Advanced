package geometry;

public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable {

    public PlaneShape(double x, double y) {
        this.vertices = new geometry.Vertex2D[3];
        this.vertices[0] = new geometry.Vertex2D(x, y);
    }

    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public String toString() {
        return "Shape = " + this.getClass().getSimpleName() + "\n" +
                "Area = " + this.getArea() + "\n" +
                "Perimeter = " + this.getPerimeter() + "\n" +
                super.toString();
    }
}
