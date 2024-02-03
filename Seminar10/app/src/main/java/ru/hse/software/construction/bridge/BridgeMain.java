package ru.hse.software.construction.bridge;

import ru.hse.software.construction.bridge.client.AdvancedRemote;
import ru.hse.software.construction.bridge.client.Remote;
import ru.hse.software.construction.bridge.model.Device;
import ru.hse.software.construction.bridge.model.TV;

public class BridgeMain {

    public static void main(String[] args) {
        final Device device = new TV();
        final AdvancedRemote remote = new AdvancedRemote(device);

        remote.setSoundType("SURROUND");
        remote.turnOn();
        remote.mute();
    }
}
