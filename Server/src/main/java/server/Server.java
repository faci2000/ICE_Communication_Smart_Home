package server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import server.models.Light.MonoChromaticLedLightServant;
import server.models.Light.RgbwLightServant;
import server.models.NetworkMonitor.IPv6NetworkMonitorServant;
import server.models.NetworkMonitor.NatNetworkMonitorServant;

public class Server {

    public void listen(String[] args)
    {
        int status = 0;
        Communicator communicator = null;

        try	{
            // 1. Inicjalizacja ICE - utworzenie communicatora
            communicator = Util.initialize(args);

            // 2. Konfiguracja adaptera
            // METODA 1 (polecana produkcyjnie): Konfiguracja adaptera Adapter1 jest w pliku konfiguracyjnym podanym jako parametr uruchomienia serwera
//            ObjectAdapter adapter = communicator.createObjectAdapter("Server1");
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Server1", "tcp -h 127.0.0.11 -p 10000");

               // 3. Stworzenie serwanta/serwantów
//            CalcI calcServant1 = new CalcI();
//            CalcI calcServant2 = new CalcI();
//            CalcI calcServant3 = new CalcI();

            // 4. Dodanie wpisów do tablicy ASM, skojarzenie nazwy obiektu (Identity) z serwantem
            adapter.add(new IPv6NetworkMonitorServant(), new Identity("IPv6NetworkMonitor", "NetworkMonitoring"));
            adapter.add(new NatNetworkMonitorServant(), new Identity("NatNetworkMonitor", "NetworkMonitoring"));
            adapter.add(new RgbwLightServant(), new Identity("RgbwLight", "Lighting"));
            adapter.add(new MonoChromaticLedLightServant(), new Identity("MonoChromaticLedLight", "Lighting"));

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
        Server server = new Server();
        server.listen(args);
    }
}
