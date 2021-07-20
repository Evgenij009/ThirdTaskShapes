package by.epam.eugene.factory;

import by.epam.eugene.entity.CustomPoint;
import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class PyramidFactory {
    private static Logger logger = LogManager.getLogger();
    private static final byte VALID_COUNT_DATA = 5;

    public static List<Pyramid> createListOfPyramids(List<double[]> parameters) throws PyramidException {
        if (parameters == null || parameters.isEmpty()) {
            throw new PyramidException("Unable to create Pyramid object. Argument contains null or empty.");
        }
        List<Pyramid> pyramidList = new ArrayList<>();
        for (double[] parameter : parameters) {
            Pyramid pyramid = createPyramid(parameter);
            pyramidList.add(pyramid);
        }
        logger.info("List of Pyramids is created successfully");
        return pyramidList;
    }

    public static Pyramid createPyramid(double[] parameters) throws PyramidException {
        if (parameters == null || parameters.length != VALID_COUNT_DATA) {
            throw new PyramidException("Unable to create Pyramid object." + "Argument contains null or wrong number of parameter");
        }
        CustomPoint centerOfTriangle = new CustomPoint(parameters[0], parameters[1], parameters[2]);
        Pyramid pyramid = new Pyramid(centerOfTriangle, parameters[3], parameters[4]);
        logger.debug("Pyramid is created successfully: " + pyramid);
        return pyramid;
    }
}
