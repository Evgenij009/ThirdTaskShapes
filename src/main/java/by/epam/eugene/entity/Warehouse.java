package by.epam.eugene.entity;

import by.epam.eugene._main.Main;
import by.epam.eugene.parser.PyramidParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private Map<Long, PyramidParameter> parameterMap = new HashMap<>();

    private Warehouse() {
    }

    private static class SingletonHolder {
        private static final  Warehouse instance = new Warehouse();
    }

    public static Warehouse getInstance() {
        return SingletonHolder.instance;
    }

    public PyramidParameter put(long id, PyramidParameter parameter) {
        return parameterMap.put(id, parameter);
    }

    public Optional<PyramidParameter> remove(long id) {
        PyramidParameter pyramidParameter = parameterMap.remove(id);
        return (pyramidParameter != null ? Optional.of(pyramidParameter) : Optional.empty());
    }

    public Optional get(long id) {
        PyramidParameter pyramidParameter = parameterMap.get(id);
        return (pyramidParameter != null ? Optional.of(pyramidParameter) : Optional.empty());
    }
}
