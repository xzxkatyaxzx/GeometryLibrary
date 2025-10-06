package org.twod;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Triangle is not a valid triangle");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Triangle is not a valid triangle");
        }
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Triangle is not a valid triangle");
        }
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Triangle is not a valid triangle");
        }
        this.sideC = sideC;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

    @Override
    public String toString() {
        return String.format("%s [sides: %.2f, %.2f, %.2f, area=%.2f, perimeter=%.2f]",
                getName(), sideA, sideB, sideC, calculateArea(), calculatePerimeter());
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}