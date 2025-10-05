package org.example.threed;

public class Sphere implements ThreeDimensionalShape {
    private double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус сферы должен быть положительным числом");
        }
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Сфера";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус сферы должен быть положительным числом");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Сфера [радиус=%.2f, объем=%.2f, площадь поверхности=%.2f]",
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