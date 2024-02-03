package ru.hse.software.construction.bridge.client;

import lombok.Getter;
import lombok.Setter;
import ru.hse.software.construction.bridge.model.Device;

@Getter
@Setter
public class AdvancedRemote extends Remote {

    private String soundType = "DEFAULT";

    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }

    public void halfVolumeSound() {
        device.setVolume(0.5);
    }
}
