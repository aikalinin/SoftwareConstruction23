package ru.hse.software.construction.bridge.model;

public interface Device {

    boolean isEnabled();

    void enable();

    void disable();

    void setSoundQuality(String quality);

    String getSoundQuality();

    void setVolume(double volume);
}
