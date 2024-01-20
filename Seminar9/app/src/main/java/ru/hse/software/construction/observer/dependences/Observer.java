package ru.hse.software.construction.observer.dependences;

import ru.hse.software.construction.observer.dependences.subject.Subject;

public abstract class Observer<T> {
    protected Subject<T> subject;

    public abstract void update();
}
