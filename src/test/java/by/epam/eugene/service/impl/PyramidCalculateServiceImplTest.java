package by.epam.eugene.service.impl;

import by.epam.eugene.entity.CustomPoint;
import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidCalculateServiceImplTest {
    private PyramidCalculateServiceImpl service;
    private Pyramid pyramid;
    private static final double EXPECTED_AREA = 16.093354620187192;
    private static final double EXPECTED_VOLUME = 2.309401076758503;
    private static final double EXPECTED_PERIMETER = 13.040832999733066;

    @BeforeClass
    public void createCalculateService() {
        service = new PyramidCalculateServiceImpl();
        pyramid = new Pyramid(new CustomPoint(234.9, 2.1, 0.1), 1.0, 4.0);
    }

    @Test
    public void calculateVolumeTest() throws PyramidException {
        double volume = service.calculateVolume(pyramid);
        assertEquals(volume, EXPECTED_VOLUME);
    }

    @Test
    public void  calculateAreaTest() throws PyramidException {
        double area = service.calculateArea(pyramid);
        assertEquals(area, EXPECTED_AREA);
    }

    @Test
    public void calculatePerimeterTest() throws PyramidException {
        double perimeter = service.calculatePerimeter(pyramid);
        assertEquals(perimeter, EXPECTED_PERIMETER);
    }
}
