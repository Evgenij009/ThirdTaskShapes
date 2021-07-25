package by.epam.eugene.repository;

import by.epam.eugene.entity.Pyramid;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class PyramidRepository {
    private List<Pyramid> pyramids = new ArrayList<>();

    private PyramidRepository() {
    }

    private static class SingletonHolder {
        private static final PyramidRepository instance = new PyramidRepository();
    }

    public static PyramidRepository getInstance() {
        return SingletonHolder.instance;
    }

    public int size() {
        return pyramids.size();
    }

    public boolean isEmpty() {
        return pyramids.isEmpty();
    }

    public boolean contains(Object object) {
        return pyramids.contains(object);
    }

    public  boolean add(Pyramid pyramid) {
        return pyramids.add(pyramid);
    }

    public  boolean remove(Object object) {
        return pyramids.remove(object);
    }

    public void clear() {
        pyramids.clear();
    }

    public Pyramid get(int index) {
        return pyramids.get(index);
    }

    public List<Pyramid> getAll() {
        return new ArrayList<Pyramid>(pyramids);
    }

    public Pyramid set(int index, Pyramid element) {
        return pyramids.set(index, element);
    }

    public void add(int indexx, Pyramid element) {
        pyramids.add(indexx, element);
    }

    public Pyramid remove(int index) {
        return pyramids.remove(index);
    }

    public boolean addAll(Collection<? extends Pyramid> collection) {
        return pyramids.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Pyramid> collection) {
        return pyramids.addAll(index, collection);
    }

    public  List<Pyramid> query(PyramidSpecification specification) {
        List<Pyramid> result = pyramids.stream().filter((specification::specify)).collect(Collectors.toList());
        return result;
    }

    public void sort(Comparator<? super Pyramid> comparator) {
        pyramids.sort(comparator);
    }
}
