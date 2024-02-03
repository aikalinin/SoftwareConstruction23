package ru.hse.software.construction.bridge.client;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.bridge.model.Device;

@RequiredArgsConstructor
public class Remote {

    protected final Device device;

    public void turnOn() {
        device.enable();
    }

    public void turnOff() {
        device.disable();
    }
}
