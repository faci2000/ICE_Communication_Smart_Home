package server.models.Light;


import com.zeroc.Ice.Current;
import server.models.Servant;
import smartHome.*;

public class RgbwLightServant extends Servant implements IRgbwLight {

    public RgbwLightServant() {
        super(new RgbwLight());
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
    public boolean changeColor(short R, short G, short B, short W, Current current) {
        return false;
    }

    @Override
    public String getDeviceInfo(Current current) {
        return null;
    }
}
