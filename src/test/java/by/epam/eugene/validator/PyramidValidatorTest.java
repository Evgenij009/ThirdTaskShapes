package by.epam.eugene.validator;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class PyramidValidatorTest {
    @Test
    public void validateValidPyramid() {
        List<Double> parameters = Arrays.asList(1.0, 1.0, 1.0, 2.0, 3.0);
        assertTrue(PyramidValidator.isParametersValid(parameters));
    }

    @Test
    public void validateInvalidPyramid() {
        List<Double> parameters = Arrays.asList(1.0, 1.0, 1.0, -2.0, 3.0);
        assertFalse(PyramidValidator.isParametersValid(parameters));
    }
}
