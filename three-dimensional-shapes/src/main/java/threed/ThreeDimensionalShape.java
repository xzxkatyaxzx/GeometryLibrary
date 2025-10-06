package threed;

import twod.Shape;

public interface ThreeDimensionalShape extends Shape {
    double calculateVolume();
    double calculateSurfaceArea();
}