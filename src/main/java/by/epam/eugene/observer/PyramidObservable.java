package by.epam.eugene.observer;

public interface PyramidObservable {
    void attach(PyramidObservable observable);

    void detach();

    void notifyObservers();
}
