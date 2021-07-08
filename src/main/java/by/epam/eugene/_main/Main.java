package by.epam.eugene._main;

import by.epam.eugene.entity.CustomPoint;
import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.service.impl.PyramidCalculateServiceImpl;

public class Main {

    public static void main(String... args) throws PyramidException {
        Pyramid pyramid = new Pyramid(3131, new CustomPoint(3, 4, -2),5, 3);
        PyramidCalculateServiceImpl pyramidCalculateService = new PyramidCalculateServiceImpl();
        System.out.println(pyramidCalculateService.calculateArea(pyramid));
        System.out.println(pyramidCalculateService.calculateVolume(pyramid));
        System.out.println(pyramidCalculateService.calculatePerimeter(pyramid));
    }
}
