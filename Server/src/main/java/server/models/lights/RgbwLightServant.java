package server.models.lights;


import com.zeroc.Ice.Current;
import server.models.Servant;
import generated.*;

import java.util.HashMap;

public class RgbwLightServant extends Servant implements IRgbwLight {

    public RgbwLightServant(String name) {
        super(new RgbwLight());
         device.name = name;
         changeColor(((short) 0),((short) 0),((short) 0),((short) 0),new Current());
    }

    @Override
    public boolean changeBrightness(short newBrightness, Current current) throws IndexOutOfRangeException {
        System.out.println("brightness");
        if(newBrightness > 100 || newBrightness < 0)
            throw new IndexOutOfRangeException("Brightness should be between 0 and 100");
        ((RgbwLight) device).brightness = newBrightness;
        return true;
    }

    @Override
    public boolean changeLightMode(LightMode newLightMode, Current current) {
        System.out.println("lightMode");
        ((RgbwLight) device).lightMode = newLightMode;
        return true;
    }

    @Override
    public boolean toggleLight(Current current) {
        ((RgbwLight) device).isOn = !((RgbwLight) device).isOn;
        return true;
    }

    @Override
    public boolean changeColor(short R, short G, short B, short W, Current current) {

        System.out.println("color");
        ((RgbwLight) device).rgbwPallet = new HashMap<>();
        ((RgbwLight) device).rgbwPallet.put(Color.RED,R);
        ((RgbwLight) device).rgbwPallet.put(Color.GREEN,G);
        ((RgbwLight) device).rgbwPallet.put(Color.BLUE,B);
        ((RgbwLight) device).rgbwPallet.put(Color.WHITE,W);
        return true;
    }

    @Override
    public String getDeviceInfo(Current current) {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        RgbwLight rgbwLight = ((RgbwLight) this.device);
        result.append(device.name).append(":").append(newLine);
        result.append("isOn").append(": ").append(rgbwLight.isOn).append(newLine);
        result.append("Brightness").append(": ").append(rgbwLight.brightness).append(newLine);
        result.append("Lightmode").append(": ").append(rgbwLight.lightMode.name()).append(newLine);
        result.append("Current color").append(": ").append(getColor()).append(newLine);

        result.append("------------------------------------------").append(newLine);

        return result.toString();
    }

    private String getColor(){
        RgbwLight rgbwLight = ((RgbwLight) this.device);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("< ");
        for (var color : rgbwLight.rgbwPallet.keySet()){
            stringBuilder.append(color.name()).append(":").append(rgbwLight.rgbwPallet.get(color)).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
