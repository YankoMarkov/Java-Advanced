package geometry;

public class Triangle extends PlaneShape {

    public Triangle(double x, double y,
                    double x1, double y1,
                    double x2, double y2) {
        super(x, y);
        this.vertices[1] = new geometry.Vertex2D(x1, y1);
        this.vertices[2] = new geometry.Vertex2D(x2, y2);

        this.isValidTriangle();
    }

    private double calculateSideA() {
        double sideA = geometry.Vertex.distance(this.vertices[0], this.vertices[1]);
        return sideA;
    }

    private double calculateSideB() {
        double sideB = geometry.Vertex.distance(this.vertices[1], this.vertices[2]);
        return sideB;
    }

    private double calculateSideC() {
        double sideC = geometry.Vertex.distance(this.vertices[2], this.vertices[0]);
        return sideC;
    }

    private void isValidTriangle() {
        if (this.calculateSideA() >= this.calculateSideB() + this.calculateSideC() ||
                this.calculateSideB() >= this.calculateSideA() + this.calculateSideC() ||
                this.calculateSideC() >= this.calculateSideB() + this.calculateSideA()) {
            throw new IllegalArgumentException("Your incoming data does not form a triangle!");
        }
    }

    @Override
    public double getArea() {
        double p = (this.calculateSideA() + this.calculateSideB() + this.calculateSideC()) / 2;
        double triangleArea = Math.sqrt(p * p - this.calculateSideA() * p - this.calculateSideB() * p - this.calculateSideC());
        return triangleArea;
    }

    @Override
    public double getPerimeter() {
        double trianglePerimeter = this.calculateSideA() + this.calculateSideB() + this.calculateSideC();
        return trianglePerimeter;
    }
}