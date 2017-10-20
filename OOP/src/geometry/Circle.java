package geometry;

public class Circle extends geometry.PlaneShape {

    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (this.radius * this.radius);
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * this.radius;
    }
}
