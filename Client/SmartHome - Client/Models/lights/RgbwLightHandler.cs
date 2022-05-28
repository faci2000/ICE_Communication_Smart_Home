using Ice;
using smartHome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SmartHome___Client.Models.lights
{
    class RgbwLightHandler : Handler
    {
        public RgbwLightHandler(String name, Communicator communicator) : base()
        {
            this.communicator = communicator;
            var proxy_ = IRgbwLightPrxHelper.checkedCast(communicator.stringToProxy(name + Handler.SERVER_CREDENTIALS));
            this.proxy = proxy_;

            availableFunctions.Add("toggleLight", new Func<OptionalContext, bool>(proxy_.toggleLight));
            functionsArguments.Add("toggleLight", " - ");

            availableFunctions.Add("changeBrightness", new Func<short, OptionalContext, bool>(proxy_.changeBrightness));
            functionsArguments.Add("changeBrightness", "short");

            availableFunctions.Add("changeLightMode", new Func<LightMode, OptionalContext, bool>(proxy_.changeLightMode));
            functionsArguments.Add("changeLightMode", "LightMode");

            availableFunctions.Add("changeColor", new Func<short, short, short, short, OptionalContext, bool>(proxy_.changeColor));
            functionsArguments.Add("changeColor", "short, short, short, short");
        }

        public override bool callFunction()
        {
            Console.WriteLine("Specify function to use and its arguments (separated by spaces)");
            printAvailableFuncs();
            Console.Write("> ");
            var selectedFunc = Console.ReadLine();
            try
            {
                try
                {
                    var functionName = selectedFunc.Split(' ')[0];
                    if (functionName.Equals("changeColor"))
                    {
                        var R = selectedFunc.Split(' ')[1];
                        var G = selectedFunc.Split(' ')[2];
                        var B = selectedFunc.Split(' ')[3];
                        var W = selectedFunc.Split(' ')[4];
                        availableFunctions[functionName].DynamicInvoke(R,G,B,W, new OptionalContext());;
                    }
                    else if (functionName.Equals("changeLightMode"))
                    {
                        Enum.TryParse(selectedFunc.Split(' ')[1], out LightMode lightMode);
                        availableFunctions[functionName].DynamicInvoke(lightMode, new OptionalContext());
                    }
                    else if (functionName.Equals("changeBrightness"))
                    {
                        var brightness = short.Parse(selectedFunc.Split(' ')[1]);
                        availableFunctions[functionName].DynamicInvoke(brightness, new OptionalContext());
                    }
                    else if (functionName.Equals("toggleLight"))
                    {
                        availableFunctions[functionName].DynamicInvoke( new OptionalContext());
                    }
                    else
                    {
                        Console.WriteLine("Invalid function call");
                    }
                }
                catch (Ice.Exception e)
                {
                    Console.WriteLine(e.Message);
                    Console.WriteLine("ICE ERROR!");
                }
                return true;
            }
            catch (System.Exception e)
            {
                Console.WriteLine(e.Message);
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
