import java.net.Socket;
import java.io.IOException;

public class PortScanner {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java PortScanner <IP address> <start port> <end port>");
            return;
        }

        String host = args[0];
        int startPort = Integer.parseInt(args[1]);
        int endPort = Integer.parseInt(args[2]);

        scanPorts(host, startPort, endPort);
    }

    private static void scanPorts(String host, int startPort, int endPort) {
        System.out.println("Scanning ports on " + host + "...");

        for (int port = startPort; port <= endPort; port++) {
            if (isPortOpen(host, port)) {
                System.out.println("Port " + port + " is open");
            }
        }

        System.out.println("Port scan on " + host + " completed");
    }

    private static boolean isPortOpen(String host, int port) {
        try {
            Socket socket = new Socket(host, port);
            socket.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
