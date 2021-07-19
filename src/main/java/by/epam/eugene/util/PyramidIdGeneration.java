package by.epam.eugene.util;

public class PyramidIdGeneration {
    private static long idCounter;

    public static long generateId() {
        return ++idCounter;
    }
}
