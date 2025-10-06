package threed;

public class Sphere implements ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Sphere radius must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Sphere";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Sphere radius must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Sphere [radius=%.2f, volume=%.2f, surface area=%.2f]",
                radius, calculateVolume(), calculateSurfaceArea());
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }

    @Override
    public double calculateArea() {
        return calculateSurfaceArea();
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

}