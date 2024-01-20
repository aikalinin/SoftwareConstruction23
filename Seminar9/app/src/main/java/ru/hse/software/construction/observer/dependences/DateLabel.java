package ru.hse.software.construction.observer.dependences;

import ru.hse.software.construction.observer.dependences.model.Profile;
import ru.hse.software.construction.observer.dependences.subject.Subject;

import java.time.format.DateTimeFormatter;

public class DateLabel extends Observer<Profile> {

    private final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ssxxx");

    public DateLabel(Subject<Profile> subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Дата рождения: "
                + getProfile()
                .getBirthday()
                .format(outputFormatter));
    }

    private Profile getProfile() {
        return this.subject.getState();
    }
}
