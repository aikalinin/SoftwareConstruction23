package ru.hse.software.construction.memento.originator;

import ru.hse.software.construction.memento.Memento;

public interface Originator<T> {

    T getState();

    void setState(T state);

    Memento<T> saveStateToMemento();

    void loadStateFromMemento(Memento<T> memento);
}
