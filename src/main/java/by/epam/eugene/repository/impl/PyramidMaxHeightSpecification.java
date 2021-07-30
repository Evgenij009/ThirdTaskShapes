package by.epam.eugene.repository.impl;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.repository.PyramidSpecification;

public class PyramidMaxHeightSpecification implements PyramidSpecification {
    private final double maxHeight;

    public PyramidMaxHeightSpecification(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double height = pyramid.getHeight();
        return height <= maxHeight;
    }
}
