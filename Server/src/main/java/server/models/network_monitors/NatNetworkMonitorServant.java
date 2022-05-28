package server.models.network_monitors;

import com.zeroc.Ice.Current;
import server.models.Servant;
import generated.*;

import java.util.HashMap;

public class NatNetworkMonitorServant extends Servant implements INatNetworkMonitor {

    public NatNetworkMonitorServant(String name) {
        super(new NatNetworkMonitor());
        ((NatNetworkMonitor) device).natTable = new HashMap<>();
        ((NatNetworkMonitor) device).devices = new IpAddress[]{};
        device.name = name;
    }

    @Override
    public boolean registerNewIpTranslation(IpAddress inside, IpAddress outside, Current current) throws OperationNotSupportedException {
        return false;
    }

    @Override
    public boolean removeIpTranslation(IpAddress inside, Current current) throws DeviceNotExistsException, OperationNotSupportedException {
        return false;
    }

    @Override
    public String getDeviceInfo(Current current) {
        return null;
    }

    @Override
    public NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus, Current current) {
        return null;
    }

    @Override
    public boolean registerNewIpv6Device(Ipv6Address device, Current current) throws OperationNotSupportedException {
        return false;
    }

    @Override
    public boolean registerNewIpv4Device(IpAddress device, Current current) throws OperationNotSupportedException {
        return false;
    }

    @Override
    public boolean removeIpv6Device(Ipv6Address device, Current current) throws DeviceNotExistsException, OperationNotSupportedException {
        return false;
    }

    @Override
    public boolean removeIpv4Device(IpAddress device, Current current) throws DeviceNotExistsException, OperationNotSupportedException {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        NatNetworkMonitor networkMonitor = ((NatNetworkMonitor) this.device);
        result.append(device.name).append(":").append(newLine);
        result.append("Network status").append(": ").append(networkMonitor.status).append(newLine);
        result.append("Network bandwidth").append(": ").append(networkMonitor.networkBandwidth).append(newLine);
        result.append("Connected devices").append(": ").append(networkMonitor.connectedDevicesNo).append(newLine);
        result.append("Devices").append(": ").append(getDevices()).append(newLine);
        result.append("NAT table").append(": ").append(getNatTable()).append(newLine);

        result.append("------------------------------------------").append(newLine);

        return result.toString();
    }

    private String getNatTable(){
        NatNetworkMonitor networkMonitor = ((NatNetworkMonitor) this.device);
        StringBuilder stringBuilder = new StringBuilder();
        if(networkMonitor.natTable.size()<1){
            return "<>";
        }
        stringBuilder.append("< ");
        for (var ip : networkMonitor.natTable.keySet()){
            stringBuilder.append(ip).append(":").append(networkMonitor.natTable.get(ip)).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    private String getDevices(){
        NatNetworkMonitor networkMonitor = ((NatNetworkMonitor) this.device);
        StringBuilder stringBuilder = new StringBuilder();
        if(networkMonitor.devices.length<1){
            return "[]";
        }
        stringBuilder.append("[ ");
        for (var ip : networkMonitor.devices){
            stringBuilder.append(ip).append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
