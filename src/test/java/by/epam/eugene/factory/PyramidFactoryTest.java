package by.epam.eugene.factory;

import by.epam.eugene.entity.CustomPoint;
import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidFactoryTest {
    @DataProvider(name = "valid_data")
    public Object[][] createPyramidData() {
        return new Object[][] {
                {new double[]{1.0, 1.0, 0.0, 6.0, 4.0}, new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 6.0, 4.0)},
                {new double[]{2.0, 3.0, 4.0, 7.0, 2.0}, new Pyramid(new CustomPoint(2.0, 3.0, 4.0), 7.0, 2.0)}
        };
    }

    @DataProvider(name = "valid_data_list")
    public Object[][] createPyramidDataList() {
        return new Object[][] {
                {Arrays.asList(new double[]{1.0, 1.0, 0.0, 6.0, 4.0}), Arrays.asList(new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 6.0, 4.0))},
                {Arrays.asList(new double[]{2.0, 3.0, 4.0, 7.0, 2.0}), Arrays.asList(new Pyramid(new CustomPoint(2.0, 3.0, 4.0), 7.0, 2.0))}
        };
    }

    @Test(dataProvider = "valid_data")
    public void createPyramid(double[] parameters, Pyramid expected) throws PyramidException {
        Pyramid pyramid = PyramidFactory.createPyramid(parameters);
        assertEquals(pyramid, expected);
    }

    @Test(dataProvider = "valid_data_list")
    public void createPyramidList(List<double[]> doubles, List<Pyramid> expectedPyramids) throws PyramidException {
        List<Pyramid> pyramids = PyramidFactory.createListOfPyramids(doubles);
        assertEquals(pyramids, expectedPyramids);
    }
}
