package server.helpers;

import com.zeroc.IceInternal.Time;
import generated.ISmartHomeDevice;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DevicesStatusPrinter implements Runnable{
    private final List<ISmartHomeDevice> devices;


    public DevicesStatusPrinter() {
        this.devices = new LinkedList<>();
    }

    public void registerDevice(ISmartHomeDevice smartHomeDevice){
        this.devices.add(smartHomeDevice);
    }

    private void printAllDevices(){
        System.out.println("UPDATED - " + new Timestamp(new Date().getTime()));
        for( var device : devices){
            System.out.println(device.toString());
        }
    }

    public ISmartHomeDevice get(int index){
        return devices.get(index);
    }

    @Override
    public void run() {
        while (true)
        {
            printAllDevices();
            try { Thread.sleep(5000); }
            catch (InterruptedException ignored) { }
        }
    }
}
