package ru.hse.software.construction.observer.dependences;

import ru.hse.software.construction.observer.dependences.model.Profile;

import java.time.format.DateTimeFormatter;

public class BadDateLabel {

    private Profile profile;
    private final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxx");

    public void setProfile(Profile profile) {
        this.profile = profile;
        update();
    }

    public void update() {
        System.out.println("Дата рождения: "
                + this.profile
                .getBirthday()
                .format(outputFormatter));
    }
}
