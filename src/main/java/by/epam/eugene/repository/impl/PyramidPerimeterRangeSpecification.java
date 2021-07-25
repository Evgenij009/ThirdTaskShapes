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

import java.util.Optional;

public class PyramidPerimeterRangeSpecification implements PyramidSpecification {
    public static Logger logger = LogManager.getLogger();
    private final  double fromPerimeter;
    private final double toPerimeter;

    public PyramidPerimeterRangeSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double perimeter;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<PyramidParameter> optional = warehouse.get(pyramid.getPyramidId());
        if (optional.isPresent()) {
            PyramidParameter parameter = optional.get();
            perimeter = parameter.getPerimeter();
        } else {
            PyramidCalculateService service = new PyramidCalculateServiceImpl();
            try {
                perimeter = service.calculatePerimeter(pyramid);
            } catch (PyramidException e) {
                logger.error("Calculation failed: ", e);
                return result;
            }
        }
        result = (perimeter <= toPerimeter && perimeter >= fromPerimeter);
        return result;
    }
}
