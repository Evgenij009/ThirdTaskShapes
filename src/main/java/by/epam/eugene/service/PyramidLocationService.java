package by.epam.eugene.service;

import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;

public interface PyramidLocationService {
    boolean isBaseOnCoordinateLineXY(Pyramid pyramid) throws PyramidException;
    boolean isBaseOnCoordinateLineXZ(Pyramid pyramid) throws PyramidException;
    boolean isBaseOnCoordinateLineYZ(Pyramid pyramid) throws PyramidException;
}
