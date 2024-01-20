package ru.hse.software.construction.observer.dependences;


import ru.hse.software.construction.observer.dependences.model.Profile;
import ru.hse.software.construction.observer.dependences.subject.Subject;

import java.text.MessageFormat;

public class ProfileIcon extends Observer<Profile> {

    public ProfileIcon(Subject<Profile> subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println(MessageFormat.format(
                "Shows {0} profile with video {1}",
                this.subject.getState().getName().toUpperCase(),
                this.subject.getState().getProfileVideo()));
    }
}
