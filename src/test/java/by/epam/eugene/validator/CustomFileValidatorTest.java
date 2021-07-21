package by.epam.eugene.validator;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CustomFileValidatorTest {
    @Test
    public void validateValidFile() {
        String path = "test_data\\data.txt";
        assertTrue(CustomFileValidator.isFileValid(path));
    }

    @Test
    public void validateInvalidFile() {
        String path = "test_data\\dataFalse.txt";
        assertFalse(CustomFileValidator.isFileValid(path));
    }
}
