package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class GeometryUtils {
    public static int compareByArea(Shape shape1, Shape shape2) {
        validateShapes(shape1, shape2);
        return Double.compare(shape1.calculateArea(), shape2.calculateArea());
    }

    public static int compareByPerimeter(Shape shape1, Shape shape2) {
        validateShapes(shape1, shape2);
        return Double.compare(shape1.calculatePerimeter(), shape2.calculatePerimeter());
    }

    public static Optional<Shape> findMaxArea(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return Optional.empty();
        }

        return shapes.stream()
                .max(Comparator.comparingDouble(Shape::calculateArea));
    }

    public static Optional<Shape> findMinPerimeter(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return Optional.empty();
        }

        return shapes.stream()
                .min(Comparator.comparingDouble(Shape::calculatePerimeter));
    }

    public static double calculateTotalArea(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return 0.0;
        }

        return shapes.stream()
                .mapToDouble(Shape::calculateArea)
                .sum();
    }

    public static double calculateTotalPerimeter(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return 0.0;
        }

        return shapes.stream()
                .mapToDouble(Shape::calculatePerimeter)
                .sum();
    }

    private static void validateShapes(Shape shape1, Shape shape2) {
        validateShape(shape1);
        validateShape(shape2);
    }

    private static void validateShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Фигура не может быть null");
        }
    }
}