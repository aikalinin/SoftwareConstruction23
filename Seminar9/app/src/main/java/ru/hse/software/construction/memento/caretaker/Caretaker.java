package ru.hse.software.construction.memento.caretaker;

import ru.hse.software.construction.memento.Memento;

import java.util.List;

public interface Caretaker<T> {
    void add(Memento<T> mementoState);

    Memento<T> get(int index);

    Memento<T> getLast();

    List<Memento<T>> getAll();
}
