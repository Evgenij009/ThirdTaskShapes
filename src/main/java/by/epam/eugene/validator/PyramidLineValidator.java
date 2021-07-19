package by.epam.eugene.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidLineValidator {
    private static Logger logger = LogManager.getLogger();
    private static final String REX_EXP_NOT_VALIDATION_LINE = "\\p{Alpha}+";

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
}
