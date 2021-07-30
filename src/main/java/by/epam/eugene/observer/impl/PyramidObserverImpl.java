package by.epam.eugene.observer.impl;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.entity.PyramidParameter;
import by.epam.eugene.entity.Warehouse;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.observer.PyramidEvent;
import by.epam.eugene.observer.PyramidObserver;
import by.epam.eugene.service.PyramidCalculateService;
import by.epam.eugene.service.impl.PyramidCalculateServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidObserverImpl implements PyramidObserver {
    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(PyramidEvent pyramidEvent) {
        Warehouse warehouse = Warehouse.getInstance();
        PyramidCalculateService pyramidCalculateService = new PyramidCalculateServiceImpl();
        Pyramid pyramid = pyramidEvent.getSource();
        try {
            double volume = pyramidCalculateService.calculateVolume(pyramid);
            double area = pyramidCalculateService.calculateArea(pyramid);
            double perimeter = pyramidCalculateService.calculatePerimeter(pyramid);
            PyramidParameter parameter = new PyramidParameter(volume, area, perimeter);
            warehouse.put(pyramid.getPyramidId(), parameter);
            logger.info("Parameter of the Pyramid has been update", pyramid);
        } catch (PyramidException e) {
            logger.error("Parameters of the Pyramid has not been update, ", pyramid);
        }
    }
}
