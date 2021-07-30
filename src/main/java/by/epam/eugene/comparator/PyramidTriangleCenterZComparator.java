package by.epam.eugene.comparator;

import by.epam.eugene.entity.Pyramid;

import java.util.Comparator;

public class PyramidTriangleCenterZComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid o1, Pyramid o2) {
        int result = 0;
        double triangleCenterZ1 = o1.getPointCenterOfBase().getZ();
        double triangleCenterZ2 = o2.getPointCenterOfBase().getZ();
        result = Double.compare(triangleCenterZ1, triangleCenterZ2);
        return result;
    }
}
