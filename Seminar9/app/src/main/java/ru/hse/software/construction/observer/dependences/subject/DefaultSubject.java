package ru.hse.software.construction.observer.dependences.subject;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import ru.hse.software.construction.observer.dependences.Observer;
import ru.hse.software.construction.observer.dependences.model.Profile;

import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

@RequiredArgsConstructor
public class DefaultSubject implements Subject<Profile> {

    private final Map<String, Observer<Profile>> observers = new WeakHashMap<>();

    private Profile state;

    @Override
    public Profile getState() {
        return state;
    }

    @Override
    public void setState(Profile state) {
        if (this.state == state) {
            return;
        }

        this.state = state;
        notifyAllObservers();
    }

    @Override
    public void attach(String name, Observer<Profile> observer) {
        observers.put(name, observer);
    }

    @Override
    public void notifyAllObservers() {
        observers.values().forEach(Observer::update);
    }

    @Override
    public void notifyObserver(String observerName) {
        Optional.ofNullable(observers.get(observerName))
                .ifPresent(Observer::update);
    }

    @UtilityClass
    public class ObserverNames {

        public static final String DATE_LABEL_OBSERVER = "DATE_LABEL_OBSERVER";

        public static final String PROFILE_ICON_OBSERVER = "PROFILE_ICON_OBSERVER";
    }
}
