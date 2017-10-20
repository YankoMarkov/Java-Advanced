package geometry;

public class SquarePyramid extends SpaceShape {

    private double baseWidth;
    private double hight;
    private double slantHight;

    public SquarePyramid(double x, double y, double z, double baseWidth, double hight, double slantHight) {
        super(x, y, z);
        this.baseWidth = baseWidth;
        this.hight = hight;
        this.slantHight = slantHight;
    }

    public double getBaseWidth() {
        return baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getSlantHight() {
        return slantHight;
    }

    public void setSlantHight(double slantHight) {
        this.slantHight = slantHight;
    }

    private double getBaseArea() {
        return this.baseWidth * this.baseWidth;
    }

    @Override
    public double getArea() {
        double faceArea = (1.0 / 2.0) * (4.0 * this.baseWidth) * this.hight;
        double baseArea = this.getBaseArea();
        return faceArea + baseArea;
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * this.getBaseArea() * this.hight;
    }
}
