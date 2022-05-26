package server.models;


import smartHome.SmartHomeDevice;

abstract public class Servant {
    private final SmartHomeDevice device;

    public Servant(SmartHomeDevice device) {
        this.device = device;
    }
}
