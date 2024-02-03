package ru.hse.software.construction.concurrency.model;

import lombok.Builder;

@Builder
public class Profile implements Imaginable {

    private String imageUrl;

    private String iconUrl;

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getIconUrl() {
        return iconUrl;
    }
}
