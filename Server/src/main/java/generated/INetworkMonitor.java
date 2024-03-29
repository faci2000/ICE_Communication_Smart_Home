//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `smartHome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package generated;

public interface INetworkMonitor extends ISmartHomeDevice
{
    NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus, com.zeroc.Ice.Current current);

    boolean registerNewIpv6Device(Ipv6Address device, com.zeroc.Ice.Current current)
        throws OperationNotSupportedException;

    boolean registerNewIpv4Device(IpAddress device, com.zeroc.Ice.Current current)
        throws OperationNotSupportedException;

    boolean removeIpv6Device(Ipv6Address device, com.zeroc.Ice.Current current)
        throws DeviceNotExistsException,
               OperationNotSupportedException;

    boolean removeIpv4Device(IpAddress device, com.zeroc.Ice.Current current)
        throws DeviceNotExistsException,
               OperationNotSupportedException;

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::smartHome::INetworkMonitor",
        "::smartHome::ISmartHomeDevice"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::smartHome::INetworkMonitor";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_changeNetworkStatus(INetworkMonitor obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        NetworkStatus iceP_newNetworkStatus;
        iceP_newNetworkStatus = NetworkStatus.ice_read(istr);
        inS.endReadParams();
        NetworkStatus ret = obj.changeNetworkStatus(iceP_newNetworkStatus, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        NetworkStatus.ice_write(ostr, ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_registerNewIpv6Device(INetworkMonitor obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Ipv6Address iceP_device;
        iceP_device = Ipv6Address.ice_read(istr);
        inS.endReadParams();
        boolean ret = obj.registerNewIpv6Device(iceP_device, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_registerNewIpv4Device(INetworkMonitor obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        IpAddress iceP_device;
        iceP_device = IpAddress.ice_read(istr);
        inS.endReadParams();
        boolean ret = obj.registerNewIpv4Device(iceP_device, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_removeIpv6Device(INetworkMonitor obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Ipv6Address iceP_device;
        iceP_device = Ipv6Address.ice_read(istr);
        inS.endReadParams();
        boolean ret = obj.removeIpv6Device(iceP_device, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
     * @throws com.zeroc.Ice.UserException -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_removeIpv4Device(INetworkMonitor obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        IpAddress iceP_device;
        iceP_device = IpAddress.ice_read(istr);
        inS.endReadParams();
        boolean ret = obj.removeIpv4Device(iceP_device, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "changeNetworkStatus",
        "getDeviceInfo",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "registerNewIpv4Device",
        "registerNewIpv6Device",
        "removeIpv4Device",
        "removeIpv6Device"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return _iceD_changeNetworkStatus(this, in, current);
            }
            case 1:
            {
                return ISmartHomeDevice._iceD_getDeviceInfo(this, in, current);
            }
            case 2:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 4:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 5:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 6:
            {
                return _iceD_registerNewIpv4Device(this, in, current);
            }
            case 7:
            {
                return _iceD_registerNewIpv6Device(this, in, current);
            }
            case 8:
            {
                return _iceD_removeIpv4Device(this, in, current);
            }
            case 9:
            {
                return _iceD_removeIpv6Device(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
