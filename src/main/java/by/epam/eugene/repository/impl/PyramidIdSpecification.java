package by.epam.eugene.repository.impl;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.repository.PyramidSpecification;

public class PyramidIdSpecification implements PyramidSpecification {
    private final long id;

    public PyramidIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        return pyramid.getPyramidId() == id;
    }
}
