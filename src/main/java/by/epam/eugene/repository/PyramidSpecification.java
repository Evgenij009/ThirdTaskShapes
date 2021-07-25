package by.epam.eugene.repository;

import by.epam.eugene.entity.Pyramid;

@FunctionalInterface
public interface PyramidSpecification {
    public boolean specify(Pyramid pyramid);
}
