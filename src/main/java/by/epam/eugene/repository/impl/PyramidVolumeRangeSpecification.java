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

public class PyramidVolumeRangeSpecification implements PyramidSpecification {
    public static Logger logger = LogManager.getLogger();
    private final double fromVolume;
    private final double toVolume;

    public PyramidVolumeRangeSpecification(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        double volume;
        boolean result = false;
        Warehouse warehouse = Warehouse.getInstance();
        Optional<PyramidParameter> optional = warehouse.get(pyramid.getPyramidId());
        if (optional.isPresent()) {
            PyramidParameter parameter = optional.get();
            volume = parameter.getVolume();
        } else {
            PyramidCalculateService service = new PyramidCalculateServiceImpl();
            try {
                volume = service.calculateVolume(pyramid);
            } catch (PyramidException e) {
                logger.error("Calculation failed: ", e);
                return result;
            }
        }
        result = (volume <= toVolume && volume >= fromVolume);
        return result;
    }
}
