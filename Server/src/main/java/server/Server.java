package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import server.helpers.DevicesStatusPrinter;
import server.models.lights.MonoChromaticLedLightServant;
import server.models.lights.RgbwLightServant;
import server.models.network_monitors.IPv6NetworkMonitorServant;
import server.models.network_monitors.NatNetworkMonitorServant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{

    public final DevicesStatusPrinter devicesStatusPrinter;
    private final Communicator communicator;

    public Server(String[] args) {
        devicesStatusPrinter = new DevicesStatusPrinter();
        communicator = Util.initialize(args);
    }

    @Override
    public void run()
    {
        int status = 0;

        try	{
            // 1. Inicjalizacja ICE - utworzenie communicatora


            // 2. Konfiguracja adaptera
            // METODA 1 (polecana produkcyjnie): Konfiguracja adaptera Adapter1 jest w pliku konfiguracyjnym podanym jako parametr uruchomienia serwera
//            ObjectAdapter adapter = communicator.createObjectAdapter("Server1");
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Server1", "tcp -h 127.0.0.11 -p 10000");

               // 3. Stworzenie serwanta/serwantów
            devicesStatusPrinter.registerDevice(new IPv6NetworkMonitorServant("IPv6NetworkMonitor"));
            devicesStatusPrinter.registerDevice(new NatNetworkMonitorServant("NatNetworkMonitor"));
            devicesStatusPrinter.registerDevice(new RgbwLightServant("RgbwLight"));
            devicesStatusPrinter.registerDevice(new MonoChromaticLedLightServant("MonoChromaticLedLight"));

            // 4. Dodanie wpisów do tablicy ASM, skojarzenie nazwy obiektu (Identity) z serwantem
            adapter.add(devicesStatusPrinter.get(0), new Identity("IPv6NetworkMonitor", "NetworkMonitoring"));
            adapter.add(devicesStatusPrinter.get(1), new Identity("NatNetworkMonitor", "NetworkMonitoring"));
            adapter.add(devicesStatusPrinter.get(2), new Identity("RgbwLight", "Lighting"));
            adapter.add(devicesStatusPrinter.get(3), new Identity("MonoChromaticLedLight", "Lighting"));

            // 5. Aktywacja adaptera i wejście w pętlę przetwarzania żądań
            adapter.activate();
            System.out.println("Entering event processing loop...");
            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Server server = new Server(args);
        executorService.submit(server);
        executorService.submit(server.devicesStatusPrinter);

    }
}
