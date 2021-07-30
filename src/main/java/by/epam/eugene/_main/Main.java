package by.epam.eugene._main;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.factory.PyramidFactory;
import by.epam.eugene.parser.PyramidParser;
import by.epam.eugene.reader.PyramidReader;
import by.epam.eugene.service.impl.PyramidCalculateServiceImpl;

import java.util.List;

public class Main {

    public static void main(String... args) throws PyramidException {
//        Pyramid pyramid = new Pyramid(3131, new CustomPoint(3, 4, -2),5, 3);
//        PyramidCalculateServiceImpl pyramidCalculateService = new PyramidCalculateServiceImpl();
//        System.out.println(pyramidCalculateService.calculateArea(pyramid));
//        System.out.println(pyramidCalculateService.calculateVolume(pyramid));
//        System.out.println(pyramidCalculateService.calculatePerimeter(pyramid));

        String pathFile = "test_data/data.txt";

        PyramidReader pyramidReader = new PyramidReader();
        PyramidParser pyramidParser = new PyramidParser();
        PyramidCalculateServiceImpl pyramidCalculateService = new PyramidCalculateServiceImpl();

        List<String> list = pyramidReader.read(pathFile);
        List<double[]> doubleList = pyramidParser.parseLineToDouble(list);
        List<Pyramid> pyramidList =  PyramidFactory.createListOfPyramids(doubleList);
        for (Pyramid pyramid : pyramidList) {
            System.out.println(pyramid);
            pyramidCalculateService.calculateArea(pyramid);
            pyramidCalculateService.calculatePerimeter(pyramid);
            pyramidCalculateService.calculateVolume(pyramid);
        }
    }
}
