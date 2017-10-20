package geometry;

public class Sphere extends SpaceShape {

    private double radius;

    public Sphere(double x, double y, double z, double radius) {
        super(x, y, z);
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
        return 4.0 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }
}
