using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ice;
using smartHome;
using SmartHome___Client.Models;
using SmartHome___Client.Models.lights;
using SmartHome___Client.Models.network_monitors;

namespace SmartHome___Client
{
    class Client
    {
        private Communicator communicator;
        private Dictionary<String, Handler> availableDeviceHandlers;

        public void initializeComunicator(string[] args)
        {
            try
            {
                this.communicator = Ice.Util.initialize(ref args);
            }catch (Ice.Exception)
            {
                throw new DeviceNotExistsException("Cannot establish connection to server!");
            } 
        }

        public void initializeCompomnentHandlers()
        {
            availableDeviceHandlers = new Dictionary<string, Handler>();
            availableDeviceHandlers.Add("IPv6NetworkMonitor", new IPv6NetworkMonitorHandler("NetworkMonitoring/IPv6NetworkMonitor", communicator));
            availableDeviceHandlers.Add("RgbwLight", new RgbwLightHandler("Lighting/RgbwLight", communicator));
        }

        public void startLoop()
        {
            for(; ; )
            {
                Console.WriteLine("Specify device to use");
                printAvailableDevics();
                Console.Write("> ");
                var selectedDevice = Console.ReadLine();
                if (availableDeviceHandlers.ContainsKey(selectedDevice))
                {
                    availableDeviceHandlers[selectedDevice].callFunction();
                }
                else
                {
                    Console.WriteLine("Selected unknown device!!!");
                }
            }
        }

        public void printAvailableDevics()
        {
            Console.WriteLine("Available devices:");
            foreach(var device in availableDeviceHandlers.Keys)
            {
                Console.WriteLine(" - " + device);
            }
        }
        public static int Main(string[] args)
        {

            try
            {
                Client client = new Client();
                client.initializeComunicator(args);
                client.initializeCompomnentHandlers();
                client.startLoop();

            }
            catch (System.Exception e)
            {
                Console.Error.WriteLine(e);
                return 1;
            }
            System.Console.ReadKey();
            return 0;
        }
    }
}
