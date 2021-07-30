package by.epam.eugene.comparator;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.entity.PyramidParameter;
import by.epam.eugene.entity.Warehouse;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.service.PyramidCalculateService;
import by.epam.eugene.service.impl.PyramidCalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Optional;

public class PyramidAreaComparator implements Comparator<Pyramid> {
    private static Logger logger = LogManager.getLogger();

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        double volume1 = 0;
        double volume2 = 0;
        int result = 0;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<PyramidParameter> parameterPyramid1 = warehouse.get(o1.getPyramidId());
        Optional<PyramidParameter> parameterPyramid2 = warehouse.get(o2.getPyramidId());
        if (parameterPyramid1.isPresent()) {
            PyramidParameter parameter1 = parameterPyramid1.get();
            volume1 = parameter1.getArea();
        } else {
            PyramidCalculateService service = new PyramidCalculateServiceImpl();
            try {
                volume1 = service.calculateArea(o1);
            } catch (PyramidException e) {
                logger.error("Calculation error: ", e);
                return -1;
            }
        }
        if (parameterPyramid2.isPresent()) {
            PyramidParameter parameter2 = parameterPyramid2.get();
            volume2 = parameter2.getArea();
        } else {
            PyramidCalculateService service = new PyramidCalculateServiceImpl();
            try {
                volume2 = service.calculateArea(o2);
            } catch (PyramidException e) {
                logger.error("Calculation error: ", e);
                return 1;
            }
        }
        result = Double.compare(volume1, volume2);
        return result;
    }
}
