package by.epam.eugene.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String REX_EXP_NOT_VALIDATION_LINE = "\\p{Alpha}+";
    private static final int VALID_COUNT_DATA = 5;
    private static final int HEIGHT_INDEX = 3;
    private static final int SIDE_LENGTH_INDEX = 4;

    public static boolean isValidLineWithParameters(String source) {
        if (source == null || source.isEmpty()) {
            logger.debug("Source line is empty");
            return false;
        }
        Pattern pattern = Pattern.compile(REX_EXP_NOT_VALIDATION_LINE);
        Matcher matcher = pattern.matcher(source);
        while (!matcher.find()) {
            return true;
        }
        logger.info("Line is not valid: " + source);
        return false;
    }

    public static boolean isParametersValid(List<Double> pyramid) {
        if (pyramid == null || pyramid.isEmpty()) {
            logger.debug("Parameter pyramid is empty");
            return false;
        }
        if (pyramid.size() == VALID_COUNT_DATA &&
                pyramid.get(HEIGHT_INDEX) > 0 &&
                pyramid.get(SIDE_LENGTH_INDEX) > 0) {
            return true;
        }
        return false;
    }
}
