
#ifndef IOT_ICE
#define IOT_ICE

module smartHome
{
    exception IndexOutOfRangeException{
        string message;
    };

    exception OperationNotSupportedException{
        string message;
    };

    exception DeviceNotExistsException{
            string message;
    };

    enum DeviceType{
        RGBWxLEDxLIGHT,
        MONOCHROMATICxLEDxLIGHT,
        IPV6xNETWORKxMONITOR,
        NATxNETWORKxMONITOR,
    };

    class SmartHomeDevice{
        string name;
        DeviceType deviceType;
        string serialNumber;
    };

    interface ISmartHomeDevice{
        string getDeviceInfo();
    };

    struct IpAddress{
        string ip;
        string mask;
    };

    struct Ipv6Address{
        string ip;
        short prefix;
    };

    enum NetworkStatus{
        ON,
        OFF,
        OUTxOFxRANGE
    };

    dictionary<IpAddress, IpAddress> NatTable;
    sequence<IpAddress> IpAddresses;
    sequence<Ipv6Address> Ipv6Addresses;

    interface INetworkMonitor extends ISmartHomeDevice{
                                                NetworkStatus changeNetworkStatus(NetworkStatus newNetworkStatus);
                                                bool registerNewIpv6Device(Ipv6Address device) throws OperationNotSupportedException;
                                                bool registerNewIpv4Device(IpAddress device) throws OperationNotSupportedException;
                                                bool removeIpv6Device(Ipv6Address device) throws OperationNotSupportedException, DeviceNotExistsException;
                                                bool removeIpv4Device(IpAddress device) throws OperationNotSupportedException, DeviceNotExistsException;
                                            };

    class NetworkMonitor extends SmartHomeDevice{
        NetworkStatus status;
        short connectedDevicesNo;
        short networkBandwidth;
    };

    interface INatNetworkMonitor extends INetworkMonitor{
                  bool registerNewIpTranslation(IpAddress inside, IpAddress outside) throws OperationNotSupportedException;
                  bool removeIpTranslation(IpAddress inside) throws OperationNotSupportedException, DeviceNotExistsException;
          };

    class NatNetworkMonitor extends NetworkMonitor{
        NatTable natTable;
        IpAddresses devices;
    };

    class IPv6NetworkMonitor extends NetworkMonitor {
        Ipv6Addresses devices;
    };

    enum LightMode{
            STROBE,
            BLINK,
            FADE,
            SOLID
    };

    enum Color{
        RED,
        BLUE,
        GREEN,
        WHITE
    };

    dictionary<Color, short> RgbwPallet;

    interface ILedLight extends ISmartHomeDevice{
        bool changeBrightness(short newBrightness) throws IndexOutOfRangeException;
        bool toggleLight();
        bool changeLightMode(LightMode newLightMode);
    };

    class LedLight extends SmartHomeDevice{
        bool isOn;
        short brightness;
        LightMode lightMode;
    };

    interface IRgbwLight extends ILedLight{
            bool changeColor(short R, short G, short B, short W);
    };

    class RgbwLight extends LedLight{
        RgbwPallet rgbwPallet;
    };

    class MonoChromaticLedLight extends LedLight{
        Color mainColor;
    };
};

#endif
