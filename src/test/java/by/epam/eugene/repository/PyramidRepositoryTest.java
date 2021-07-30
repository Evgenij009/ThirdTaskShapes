package by.epam.eugene.repository;

import by.epam.eugene.comparator.PyramidIdComparator;
import by.epam.eugene.comparator.PyramidVolumeComparator;
import by.epam.eugene.entity.CustomPoint;
import by.epam.eugene.entity.Pyramid;
import by.epam.eugene.exception.PyramidException;
import by.epam.eugene.repository.impl.PyramidIdSpecification;
import by.epam.eugene.repository.impl.PyramidMaxHeightSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidRepositoryTest {
    private PyramidRepository repository;

    @BeforeClass
    public void createRepository() throws PyramidException {
        repository = PyramidRepository.getInstance();
        repository.add(new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 1.0, 3.0));
        repository.add(new Pyramid(new CustomPoint(1.0, 2.0, 0.0), 2.0, 4.0));
        repository.add(new Pyramid(new CustomPoint(1.0, 1.0, 2.0), 3.0, 5.0));
    }

    @DataProvider(name = "query_data")
    public Object[][] createQueryData() throws PyramidException {
        return new Object[][]{
                {new PyramidIdSpecification(1), Arrays.asList(new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 1.0, 3.0))},
                {new PyramidMaxHeightSpecification(4), Arrays.asList(
                        new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Pyramid(new CustomPoint(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Pyramid(new CustomPoint(1.0, 1.0, 2.0), 3.0, 5.0))}
        };
    }

    @DataProvider(name = "sort_data")
    public Object[][] createSortData() throws PyramidException {
        return new Object[][]{
                {new PyramidIdComparator(), Arrays.asList(
                        new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Pyramid(new CustomPoint(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Pyramid(new CustomPoint(1.0, 1.0, 2.0), 3.0, 5.0))
                },
                {new PyramidVolumeComparator(), Arrays.asList(
                        new Pyramid(new CustomPoint(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Pyramid(new CustomPoint(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Pyramid(new CustomPoint(1.0, 1.0, 2.0), 3.0, 5.0))
                }
        };
    }

    @Test(dataProvider = "query_data")
    public void queryTest(PyramidSpecification specification, List<Pyramid> expectedConeList) throws PyramidException {
        List<Pyramid> queryData = repository.query(specification);
        assertEquals(queryData, expectedConeList);
    }

    @Test(dataProvider = "sort_data")
    public void sortTest(Comparator comparator, List<Pyramid> expectedPyramidList) throws PyramidException{
        repository.sort(comparator);
        List<Pyramid> sortData = repository.getAll();
        assertEquals(sortData, expectedPyramidList);
    }
}
