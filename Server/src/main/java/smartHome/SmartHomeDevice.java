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

package smartHome;

public class SmartHomeDevice extends com.zeroc.Ice.Value
{
    public SmartHomeDevice()
    {
        this.name = "";
        this.deviceType = DeviceType.RGBWxLEDxLIGHT;
        this.serialNumber = "";
    }

    public SmartHomeDevice(String name, DeviceType deviceType, String serialNumber)
    {
        this.name = name;
        this.deviceType = deviceType;
        this.serialNumber = serialNumber;
    }

    public String name;

    public DeviceType deviceType;

    public String serialNumber;

    public SmartHomeDevice clone()
    {
        return (SmartHomeDevice)super.clone();
    }

    public static String ice_staticId()
    {
        return "::smartHome::SmartHomeDevice";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    /** @hidden */
    public static final long serialVersionUID = 1454934058L;

    /** @hidden */
    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, true);
        ostr_.writeString(name);
        DeviceType.ice_write(ostr_, deviceType);
        ostr_.writeString(serialNumber);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        name = istr_.readString();
        deviceType = DeviceType.ice_read(istr_);
        serialNumber = istr_.readString();
        istr_.endSlice();
    }
}
