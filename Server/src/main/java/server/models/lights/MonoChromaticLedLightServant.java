package server.models.lights;

import com.zeroc.Ice.Current;
import server.models.Servant;
import generated.*;

public class MonoChromaticLedLightServant extends Servant implements ILedLight {

    public MonoChromaticLedLightServant(String name) {
        super(new MonoChromaticLedLight());
        device.name = name;
    }

    @Override
    public boolean changeBrightness(short newBrightness, Current current) throws IndexOutOfRangeException {
        return false;
    }

    @Override
    public boolean toggleLight(Current current) {
        return false;
    }

    @Override
    public boolean changeLightMode(LightMode newLightMode, Current current) {
        return false;
    }

    @Override
    public String getDeviceInfo(Current current) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        MonoChromaticLedLight rgbwLight = ((MonoChromaticLedLight) this.device);
        result.append(device.name).append(":").append(newLine);
        result.append("isOn").append(": ").append(rgbwLight.isOn).append(newLine);
        result.append("Brightness").append(": ").append(rgbwLight.brightness).append(newLine);
        result.append("Lightmode").append(": ").append(rgbwLight.lightMode.name()).append(newLine);
        result.append("Main color").append(": ").append(rgbwLight.mainColor).append(newLine);

        result.append("------------------------------------------").append(newLine);

        return result.toString();
    }
}
