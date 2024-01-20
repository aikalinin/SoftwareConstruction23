package ru.hse.software.construction.observer.dependences.subject;

import ru.hse.software.construction.observer.dependences.Observer;

public interface Subject<T> {

    T getState();

    void setState(T state);

    void attach(String name, Observer<T> observer);

    void notifyAllObservers();

    void notifyObserver(String observerName);
}
