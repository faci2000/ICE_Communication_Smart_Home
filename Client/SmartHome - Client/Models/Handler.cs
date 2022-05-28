using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ice;
using smartHome;

namespace SmartHome___Client.Models
{
    abstract class Handler
    {

        protected static String SERVER_CREDENTIALS = ":tcp -h 127.0.0.11 -p 10000:udp -h 127.0.0.11 -p 10000";
        protected Communicator communicator;
        protected Dictionary<String, Delegate> availableFunctions;
        protected Dictionary<String, String> functionsArguments;
        protected ISmartHomeDevicePrx proxy;
        protected Handler()
        {
            availableFunctions = new Dictionary<String, Delegate>();
            functionsArguments = new Dictionary<String, String>();
        }

        public abstract bool callFunction();
    }
}
