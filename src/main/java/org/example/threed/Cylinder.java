package org.example.threed;

public class Cylinder implements ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            throw new IllegalArgumentException("Радиус и высота должны быть положительными числами");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Цилиндр";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Высота должна быть положительным числом");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Цилиндр [радиус=%.2f, высота=%.2f, объем=%.2f, площадь поверхности=%.2f]",
                radius, height, calculateVolume(), calculateSurfaceArea());
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
        return Math.PI * radius * radius * height;
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}