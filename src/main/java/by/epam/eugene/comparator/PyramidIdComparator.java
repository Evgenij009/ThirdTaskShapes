package by.epam.eugene.comparator;

import by.epam.eugene.entity.Pyramid;

import java.util.Comparator;

public class PyramidIdComparator implements Comparator<Pyramid> {

    @Override
    public int compare(Pyramid p1, Pyramid p2) {
        int result = Long.compare(p1.getPyramidId(), p2.getPyramidId());
        return result;
    }
}
