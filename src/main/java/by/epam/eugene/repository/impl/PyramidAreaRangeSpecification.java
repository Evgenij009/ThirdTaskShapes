package by.epam.eugene.repository.impl;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.entity.PyramidParameter;
import by.epam.eugene.entity.Warehouse;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.repository.PyramidSpecification;
import by.epam.eugene.service.PyramidCalculateService;
import by.epam.eugene.service.impl.PyramidCalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.WatchEvent;
import java.util.Optional;

public class PyramidAreaRangeSpecification implements PyramidSpecification {
    public static Logger logger = LogManager.getLogger();
    private final double fromArea;
    private final double toArea;

    public PyramidAreaRangeSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double area;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<PyramidParameter> optional = warehouse.get(pyramid.getPyramidId());
        if (optional.isPresent()) {
            PyramidParameter parameter = optional.get();
            area = parameter.getArea();
        } else {
            PyramidCalculateService service = new PyramidCalculateServiceImpl();
            try {
                area = service.calculateArea(pyramid);
            } catch (PyramidException e) {
                logger.error("Calculation failed: ", e);
                return result;
            }
        }
        result = (area <= toArea && area >=fromArea);
        return result;
    }
}
