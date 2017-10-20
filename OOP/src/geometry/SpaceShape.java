package geometry;

public abstract class SpaceShape extends Shape implements AreaMeasurable, geometry.VolumeMeasurable {

    public SpaceShape(double x, double y, double z) {
        this.vertices = new geometry.Vertex3D[1];
        this.vertices[0] = new geometry.Vertex3D(x, y, z);
    }

    public abstract double getArea();
    public abstract double getVolume();

    @Override
    public String toString() {
        return "Shape = " + this.getClass().getSimpleName() + '\n' +
                "Area = " + this.getArea() + '\n' +
                "Volume = " + this.getVolume() + '\n' +
                super.toString();
    }
}
