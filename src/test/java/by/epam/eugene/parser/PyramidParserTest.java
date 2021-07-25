package by.epam.eugene.parser;

import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.parser.PyramidParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PyramidParserTest {
    private PyramidParser parser;

    @BeforeClass
    public void createParser() {
        parser = new PyramidParser();
    }

    @DataProvider(name = "valid_data")
    public Object[][] coneValidDataCreate() throws PyramidException {
        return new Object[][]{
                {Arrays.asList("1.0 1.0 0.0 6.0 4.0"), new double[]{1.0, 1.0, 0.0, 6.0, 4.0}},
                {Arrays.asList("2.0 -1.0 2.0 9.0 5.0"), new double[]{2.0, -1.0, 2.0, 9.0, 5.0}}
        };
    }

    @DataProvider(name = "invalid_data")
    public Object[] coneInvalidDataCreate() throws PyramidException {
        return new Object[]{
                Arrays.asList("1.0 1.0 0.0x 6.0 4.0"),
                Arrays.asList("1.0c 1.0 0.0 6.0 4.0")
        };
    }

    @Test(dataProvider = "invalid_data", expectedExceptions = PyramidException.class)
    public void parseConeTest(List<String> line) throws PyramidException {
        parser.parseLineToDouble(line);
    }

    @Test(dataProvider = "valid_data")
    public void parseConeTest(List<String> line, double[] expected) throws PyramidException {
        List<double[]> parsedList = parser.parseLineToDouble(line);
        assertEquals(parsedList.get(0), expected);
    }
}