package by.epam.eugene.comparator;

import by.epam.eugene.entity.Pyramid;

import java.util.Comparator;

public class PyramidTriangleCenterYComparator implements Comparator<Pyramid> {
    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        int result = 0;
        double triangleCenterY1 = o1.getPointCenterOfBase().getY();
        double triangleCenterY2 = o2.getPointCenterOfBase().getY();
        result = Double.compare(triangleCenterY1, triangleCenterY2);
        return result;
    }
}
