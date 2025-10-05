package org.example;

import org.example.threed.ThreeDimensionalShape;
import java.util.Arrays;
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
                .filter(shape -> shape.calculatePerimeter() > 0) // Исключаем 3D фигуры
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

    public static Optional<ThreeDimensionalShape> findMaxVolume(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return Optional.empty();
        }

        return shapes.stream()
                .filter(ThreeDimensionalShape.class::isInstance)
                .map(ThreeDimensionalShape.class::cast)
                .max(Comparator.comparingDouble(ThreeDimensionalShape::calculateVolume));
    }

    public static double calculateTotalVolume(List<Shape> shapes) {
        if (shapes == null || shapes.isEmpty()) {
            return 0.0;
        }

        return shapes.stream()
                .filter(ThreeDimensionalShape.class::isInstance)
                .map(ThreeDimensionalShape.class::cast)
                .mapToDouble(ThreeDimensionalShape::calculateVolume)
                .sum();
    }

    public static ShapeCollectionResult separate2DAnd3D(List<Shape> shapes) {
        if (shapes == null) {
            return new ShapeCollectionResult(List.of(), List.of());
        }

        List<Shape> twoDShapes = shapes.stream()
                .filter(shape -> !(shape instanceof ThreeDimensionalShape))
                .toList();

        List<ThreeDimensionalShape> threeDShapes = shapes.stream()
                .filter(ThreeDimensionalShape.class::isInstance)
                .map(ThreeDimensionalShape.class::cast)
                .toList();

        return new ShapeCollectionResult(twoDShapes, threeDShapes);
    }

    public static class ShapeCollectionResult {
        private final List<Shape> twoDShapes;
        private final List<ThreeDimensionalShape> threeDShapes;

        public ShapeCollectionResult(List<Shape> twoDShapes, List<ThreeDimensionalShape> threeDShapes) {
            this.twoDShapes = twoDShapes;
            this.threeDShapes = threeDShapes;
        }

        public List<Shape> getTwoDShapes() { return twoDShapes; }
        public List<ThreeDimensionalShape> getThreeDShapes() { return threeDShapes; }
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