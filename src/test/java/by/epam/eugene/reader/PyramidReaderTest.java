package by.epam.eugene.reader;

import by.epam.eugene.exception.PyramidException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidReaderTest {
    PyramidReader pyramidReader;

    @BeforeClass
    public void initReader() {
        pyramidReader = new PyramidReader();
    }

    @Test
    public void readValidFile() throws PyramidException {
        String path = "test_data/data.txt";
        List<String> listOfStringFromFile = pyramidReader.read(path);
        List<String> expected = Arrays.asList("1. 2.0 3.0     0.5 5.0",
                "1.0 2.0 3.0 0.5 5.0",
                "",
                "1.0 2.0 3a.0 0.5 5.0",
                "121.,0 2.0 3.0 0.5 5.0",
                "1.0 2.0 3.0",
                "0.5 5.0",
                "1.0 2.0 3.0 2.32 23.0",
                "12  43  67     23 8",
                "234.9 2.1 0.1 -1.0 4.0",
                "234.9 2.1 0.1             1.0 4.0");
        assertEquals(expected, listOfStringFromFile);
    }

    @Test(expectedExceptions =  PyramidException.class)
    public void readInvalidFile() throws PyramidException {
        String path = "test_data/data_empty.txt";
        List<String> stringList = pyramidReader.read(path);

    }
}
