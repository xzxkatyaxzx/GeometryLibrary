package org.example;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Прямоугольник";
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина должна быть положительным числом");
        }
        this.width = width;
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
        return String.format("%s [ширина=%.2f, высота=%.2f, площадь=%.2f, периметр=%.2f]",
                getName(), width, height, calculateArea(), calculatePerimeter());
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}