using Ice;
using smartHome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartHome___Client.Models.network_monitors
{
    class IPv6NetworkMonitorHandler : Handler
    {
        public IPv6NetworkMonitorHandler(String name, Communicator communicator):base()
        {
            this.communicator = communicator;
            INetworkMonitorPrx proxy_= INetworkMonitorPrxHelper.checkedCast(communicator.stringToProxy( name + Handler.SERVER_CREDENTIALS));
            this.proxy = proxy_;

            availableFunctions.Add("registerNewIpv6Device", new Func<Ipv6Address, OptionalContext, bool>(proxy_.registerNewIpv6Device));
            functionsArguments.Add("registerNewIpv6Device", "Ipv6Address [string, string]");

            //availableFunctions.Add("registerNewIpv4Device", new Func<IpAddress, OptionalContext, bool>(proxy_.registerNewIpv4Device));
            //functionsArguments.Add("registerNewIpv6Device", "Ipv6Address [string, string]");

            availableFunctions.Add("removeIpv6Device", new Func<Ipv6Address, OptionalContext, bool>(proxy_.removeIpv6Device));
            functionsArguments.Add("removeIpv6Device", "Ipv6Address [string, string]");

            //availableFunctions.Add("registerNewIpv6Device", new Func<IpAddress, OptionalContext, bool>(proxy_.removeIpv4Device));
            //functionsArguments.Add("registerNewIpv6Device", "Ipv6Address [string, string]");
        }

        public override bool callFunction()
        {
            Console.WriteLine("Specify function to use and its arguments (separated by spaces)");
            printAvailableFuncs();
            Console.Write("> ");
            var selectedFunc = Console.ReadLine();
            try
            {
                var functionName = selectedFunc.Split(' ')[0];
                var ipv6adrr = selectedFunc.Split(' ')[1];
                var ipv6pref = short.Parse(selectedFunc.Split(' ')[2]);
                try
                {
                    availableFunctions[functionName].DynamicInvoke(new Ipv6Address(ipv6adrr, ipv6pref), new OptionalContext());
                }
                catch(Ice.Exception e)
                {
                    Console.WriteLine(e.Message);
                }
                return true;
            }
            catch(System.Exception e)
            {
                Console.WriteLine( e.Message ); 
                Console.WriteLine("Invalid function call");
                return false;
            }
        }

        private void printAvailableFuncs()
        {
            Console.WriteLine("Available functions:");
            foreach (var func in availableFunctions.Keys)
            {
                Console.WriteLine(" - " + func + " (" + functionsArguments[func] + ")");
            }
        }
    }
}
