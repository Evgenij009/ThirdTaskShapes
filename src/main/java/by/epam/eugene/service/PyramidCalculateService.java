package by.epam.eugene.service;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;

public interface PyramidCalculateService {
    double calculateVolume(Pyramid pyramid) throws PyramidException;
    double calculateArea(Pyramid pyramid) throws PyramidException;
    double calculatePerimeter(Pyramid pyramid) throws PyramidException;
}
