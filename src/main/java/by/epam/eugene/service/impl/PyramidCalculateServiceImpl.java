package by.epam.eugene.service.impl;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.service.PyramidCalculateService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidCalculateServiceImpl implements PyramidCalculateService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public double calculateVolume(Pyramid pyramid) throws PyramidException {
        if (pyramid == null) {
            throw new PyramidException("Calculation of volume cannot be completed. Argument contains null");
        }
        double volume = 1.0 / 3.0 * pyramid.getHeight() * calculateAreaBase(pyramid);
        logger.info("Calculation of volume is successful. Result is " + volume);
        return volume;
    }

    @Override
    public double calculateArea(Pyramid pyramid) throws PyramidException {
        double sideArea = 1.0 / 2.0 * (pyramid.getSideLengthBase() * 3) *
                calculateApofemOfPyramid(
                        calculateRadiusInnerCircleInTriangle(pyramid.getSideLengthBase()), pyramid.getHeight());

        double baseArea = calculateAreaBase(pyramid);

        double result = sideArea  + baseArea;
        logger.info("Calculation of Area surface is successful. Result is " + result);
        return result;
    }

    private double calculateApofemOfPyramid(double radius, double height) {
        return Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
    }

    private double calculateRadiusInnerCircleInTriangle(double sideLength) {
        return sideLength / (2 * Math.sqrt(3));
    }

    private double calculateAreaBase(Pyramid pyramid) {
        return Math.sqrt(3) / 4 * Math.pow(pyramid.getSideLengthBase(), 2);
    }
}
