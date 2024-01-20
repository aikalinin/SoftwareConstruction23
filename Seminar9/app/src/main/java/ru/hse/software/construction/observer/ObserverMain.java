package ru.hse.software.construction.observer;

import ru.hse.software.construction.observer.dependences.BadDateLabel;
import ru.hse.software.construction.observer.dependences.DateLabel;
import ru.hse.software.construction.observer.dependences.Observer;
import ru.hse.software.construction.observer.dependences.ProfileIcon;
import ru.hse.software.construction.observer.dependences.model.Profile;
import ru.hse.software.construction.observer.dependences.subject.DefaultSubject;
import ru.hse.software.construction.observer.dependences.subject.Subject;

import java.time.OffsetDateTime;

public class ObserverMain {

    public static void main(String[] args) {
        final Subject<Profile> subject = new DefaultSubject();

        final Observer<Profile> dateLabel = new DateLabel(subject);
        final Observer<Profile> profileObserver = new ProfileIcon(subject);

        subject.attach(DefaultSubject.ObserverNames.DATE_LABEL_OBSERVER, dateLabel);
        subject.attach(DefaultSubject.ObserverNames.PROFILE_ICON_OBSERVER, profileObserver);
        logicWithSubject(subject);

        final BadDateLabel badDateLabel1 = new BadDateLabel();
        final BadDateLabel badDateLabel2 = new BadDateLabel();
        badLogic(badDateLabel1, badDateLabel2);
    }

    private static void logicWithSubject(final Subject<Profile> subject) {
        final Profile profile = profileProvider();

        System.out.println();
        subject.setState(profile);

        System.out.println();
        subject.notifyObserver(DefaultSubject.ObserverNames.PROFILE_ICON_OBSERVER);

        profile.setName("Anton");
        profile.setBirthday(OffsetDateTime.MIN);

        System.out.println();
        subject.setState(profile);
    }

    private static void badLogic(final BadDateLabel badDateLabel1, final BadDateLabel badDateLabel2) {
        final Profile profile = profileProvider();
        badDateLabel1.setProfile(profile);
        badDateLabel1.update();
        badDateLabel2.setProfile(profile);
        badDateLabel2.update();
    }

    private static Profile profileProvider() {
        return new Profile(
                "Vasya",
                "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                OffsetDateTime.now());
    }
}
