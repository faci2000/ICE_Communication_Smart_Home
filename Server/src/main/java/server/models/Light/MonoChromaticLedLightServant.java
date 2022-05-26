package server.models.Light;

import com.zeroc.Ice.Current;
import server.models.Servant;
import smartHome.*;

public class MonoChromaticLedLightServant extends Servant implements ILedLight {

    public MonoChromaticLedLightServant() {
        super(new MonoChromaticLedLight());
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
}
