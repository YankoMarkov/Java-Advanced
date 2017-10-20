package geometry;

public class Cuboid extends geometry.SpaceShape {

    private double width;
    private double height;
    private double depth;

    public Cuboid(double x, double y, double z, double width, double height, double depth) {
        super(x, y, z);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public double getArea() {
        return this.width * this.depth + this.width * this.height + this.depth * this.height;
    }

    @Override
    public double getVolume() {
        return this.width * this.height * this.depth;
    }
}
