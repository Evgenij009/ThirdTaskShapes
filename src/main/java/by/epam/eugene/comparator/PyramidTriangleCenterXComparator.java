package by.epam.eugene.comparator;

import by.epam.eugene.entity.Pyramid;

import java.util.Comparator;

public class PyramidTriangleCenterXComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        int result = 0;
        double triangleCenterX1 = o1.getPointCenterOfBase().getX();
        double triangleCenterX2 = o2.getPointCenterOfBase().getX();
        result = Double.compare(triangleCenterX1, triangleCenterX2);
        return result;
    }
}
