package server.models.network_monitors;

import com.zeroc.Ice.Current;
import server.models.Servant;
import generated.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IPv6NetworkMonitorServant extends Servant implements INetworkMonitor {


    public IPv6NetworkMonitorServant(String name) {
        super(new IPv6NetworkMonitor());
        ((IPv6NetworkMonitor) device).devices = new Ipv6Address[]{};
        device.name = name;
    }

    @Override
    public NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus, Current current) {
        return null;
    }

    @Override
    public boolean registerNewIpv6Device(Ipv6Address device, Current current) throws OperationNotSupportedException {
        try{
            List<Ipv6Address> ipv6Addresses = new ArrayList<Ipv6Address>(Arrays.asList(((IPv6NetworkMonitor) this.device).devices));
            ipv6Addresses.add(device);
            ((IPv6NetworkMonitor) this.device).devices = ipv6Addresses.toArray(((IPv6NetworkMonitor) this.device).devices);
            ((IPv6NetworkMonitor) this.device).connectedDevicesNo +=1;
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registerNewIpv4Device(IpAddress device, Current current) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Ipv4 not supported.");
    }

    @Override
    public boolean removeIpv6Device(Ipv6Address device, Current current) throws DeviceNotExistsException, OperationNotSupportedException {
        try{
            List<Ipv6Address> ipv6Addresses = new ArrayList<Ipv6Address>(Arrays.asList(((IPv6NetworkMonitor) this.device).devices));
            if(ipv6Addresses.removeIf(dev -> dev.ip.equals(device.ip) && dev.prefix == device.prefix)){
                ((IPv6NetworkMonitor) this.device).devices = ipv6Addresses.toArray(((IPv6NetworkMonitor) this.device).devices);
                ((IPv6NetworkMonitor) this.device).connectedDevicesNo -=1;
                return true;
            }
            throw new DeviceNotExistsException("Device with " + device.ip + " /" + device.prefix + "dose not exists.");
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeIpv4Device(IpAddress device, Current current) throws DeviceNotExistsException, OperationNotSupportedException {
        throw new OperationNotSupportedException("Ipv4 not supported.");
    }

    @Override
    public String getDeviceInfo(Current current) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        IPv6NetworkMonitor networkMonitor = ((IPv6NetworkMonitor) this.device);
        result.append(device.name).append(":").append(newLine);
        result.append("Network status").append(": ").append(networkMonitor.status).append(newLine);
        result.append("Network bandwidth").append(": ").append(networkMonitor.networkBandwidth).append(newLine);
        result.append("Connected devices").append(": ").append(networkMonitor.connectedDevicesNo).append(newLine);
        result.append("Devices").append(": ").append(getDevices()).append(newLine);

        result.append("------------------------------------------").append(newLine);

        return result.toString();
    }

    private String getDevices(){
        IPv6NetworkMonitor networkMonitor = ((IPv6NetworkMonitor) this.device);
        StringBuilder stringBuilder = new StringBuilder();
        if(networkMonitor.devices.length<1){
            return "[]";
        }
        stringBuilder.append("[ ");
        for (var ip : networkMonitor.devices){
            stringBuilder.append(ip.ip).append(" /").append(ip.prefix).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
