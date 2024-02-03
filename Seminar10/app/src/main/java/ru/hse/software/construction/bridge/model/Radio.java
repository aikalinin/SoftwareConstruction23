package ru.hse.software.construction.bridge.model;

public class Radio implements Device {

    private boolean isOn = false;

    private String radioQuality = "DEFAULT";

    @Override
    public boolean isEnabled() {
        return isOn;
    }

    @Override
    public void enable() {
        isOn = true;
    }

    @Override
    public void disable() {
        isOn = false;
    }

    @Override
    public void setSoundQuality(String quality) {
        radioQuality = quality;
    }

    @Override
    public String getSoundQuality() {
        return radioQuality;
    }

    @Override
    public void setVolume(double volume) {
        System.out.println("Volume on Radio " + volume);
    }
}
