using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ice;
using smartHome;

namespace SmartHome___Client
{
    class Program
    {
        public static int Main(string[] args)
        {
            using (Ice.Communicator communicator = Ice.Util.initialize(ref args))
            {
                var obj = communicator.stringToProxy("NetworkMonitoring/IPv6NetworkMonitor:tcp -h 127.0.0.11 -p 10000:udp -h 127.0.0.11 -p 10000");
                var printer = INetworkMonitorPrxHelper.checkedCast(obj);
                if (printer == null)
                {
                    throw new ApplicationException("Invalid proxy");
                }

                //printer.printString("Hello World!");
            }
            //try
            //{
                
            //}
            //catch (System.Exception e)
            //{
            //    Console.Error.WriteLine(e);
            //    return 1;
            //}
            System.Console.ReadKey();
            return 0;
        }
    }
}
