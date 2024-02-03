package ru.hse.software.construction.bridge.model;

import lombok.Getter;
import lombok.Setter;

public class TV implements Device {

    private String tvQuality = "DEFAULT";

    private boolean isOn = false;

    @Override
    public boolean isEnabled() {
        return isOn;
    }

    @Override
    public void enable() {
        connectToChannel();
        isOn = true;
    }

    @Override
    public void disable() {
        disconnectFromChannel();
        isOn = false;
    }

    @Override
    public void setSoundQuality(String quality) {
        tvQuality = quality;
    }

    @Override
    public String getSoundQuality() {
        return tvQuality;
    }

    @Override
    public void setVolume(double volume) {
        System.out.println("Volume on TV " + volume);
    }

    private void connectToChannel() {
        System.out.println("TV connected to channel");
    }

    private void disconnectFromChannel() {
        System.out.println("TV disconnect from channel");
    }
}
