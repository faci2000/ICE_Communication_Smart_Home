package server.models.NetworkMonitor;

import com.zeroc.Ice.Current;
import server.models.Servant;
import smartHome.*;

public class IPv6NetworkMonitorServant extends Servant implements INetworkMonitor {


    public IPv6NetworkMonitorServant() {
        super(new IPv6NetworkMonitor());
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
    public String getDeviceInfo(Current current) {
        return null;
    }
}
