package by.epam.eugene.parser;

import by.epam.eugene.exception.PyramidException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidParserTest {
    private PyramidParser parser;

    @BeforeClass
    public void createParser() {
        parser = new PyramidParser();
    }

    @DataProvider(name = "valid_data")
    public Object[][] pyramidValidDataCreate() {
        return new Object[][] {
                {Arrays.asList("1.0 2.0   3.0 0.5    5.0"), new Double[] {1.0, 2.0, 3.0, 0.5, 5.0}},
                {Arrays.asList("1.0 2.0 3.0 2.32    23.0"), new Double[] {1.0, 2.0, 3.0, 2.32, 23.0}}
        };
    }

    @DataProvider(name = "invalid_data") //fixme
    public Object[] pyramidInvalidDataCreate() {
        return new Object[]{
                Arrays.asList("1.0 1.0 0.0x 6.0 4.0"),
                Arrays.asList("1.0c 1.0 0.0 6.0 4.0")
        };
    }

    @Test(dataProvider = "invalid_data", expectedExceptions = PyramidException.class)
    public void parsePyramidTest(List<String> lines) throws PyramidException {
        parser.parseLineToDouble(lines);
    }

    @Test(dataProvider = "valid_data")
    public void parsePyramidTest(List<String> lines, double[] expected) throws PyramidException {
        List<double[]> parsesList = parser.parseLineToDouble(lines);
        assertEquals(parsesList.get(0), expected);
    }

}
