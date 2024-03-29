package ru.hse.software.construction.observer.dependences.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public final class Profile {

    private String name;

    private String profileVideo;

    private OffsetDateTime birthday;
}
