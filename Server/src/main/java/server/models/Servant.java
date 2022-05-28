package server.models;


import generated.SmartHomeDevice;

abstract public class Servant {
    protected final SmartHomeDevice device;

    public Servant(SmartHomeDevice device) {
        this.device = device;
    }
}
