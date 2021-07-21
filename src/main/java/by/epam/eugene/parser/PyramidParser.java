package by.epam.eugene.parser;

import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.validator.PyramidValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidParser {
    private static Logger logger = LogManager.getLogger();
    private static final  String REG_EXP_STRING_FOR_DOUBLE = "\\s?(-?\\d+\\.\\d+)";
    private static final int VALID_COUNT_DATA = 5;

    public List<double[]> parseLineToDouble(List<String> arrayLines) throws PyramidException {
        if (arrayLines == null || arrayLines.size() == 0) {
            logger.error("Array lines is empty or size zero");
            throw new PyramidException("Array lines is empty or size zero");
        }
        Pattern pattern = Pattern.compile(REG_EXP_STRING_FOR_DOUBLE);
        List<double[]> pyramids = new ArrayList<>();
        for (String line : arrayLines) {
            List<Double> pyramidTmp = new ArrayList<>();
            if (PyramidValidator.isValidLineWithParameters(line)) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    pyramidTmp.add(Double.valueOf(matcher.group(1)));
                }
            }
            if (PyramidValidator.isParametersValid(pyramidTmp)) { 
                pyramids.add(pyramidTmp.stream().mapToDouble(Double::doubleValue).toArray());
            }
        }
        if (pyramids.size() == 0) {
            logger.error("There was no correct information in the data");
            throw new PyramidException("There was no correct information in the data");
        }
        logger.info("List of Parameters for make Pyramids has been created");
        return pyramids;
    }
}
