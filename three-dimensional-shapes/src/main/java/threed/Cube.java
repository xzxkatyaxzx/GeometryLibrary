package threed;

public class Cube implements ThreeDimensionalShape {
    private double side;

    public Cube(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Cube side must be greater than 0");
        }
        this.side = side;
    }

    @Override
    public String getName() {
        return "Cube";
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Cube side must be greater than 0");
        }
        this.side = side;
    }

    @Override
    public String toString() {
        return String.format("Cube [side=%.2f, volume=%.2f, surface area=%.2f]",
                side, calculateVolume(), calculateSurfaceArea());
    }

    @Override
    public double calculatePerimeter() {
        // = 0
        return 0;
    }

    @Override
    public double calculateArea() {
        return calculateSurfaceArea();
    }

    @Override
    public double calculateVolume() {
        return side * side * side;
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * side * side;
    }
}