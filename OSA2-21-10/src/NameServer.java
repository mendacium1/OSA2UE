import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class NameServer {
    private final int port;
    private final Map<String, String> keyValueStore;
    private ServerSocket serverSocket;
    private boolean running;

    public NameServer(int port) {
        if (port < 1024 || port > 65535) {
            throw new IllegalArgumentException("Invalid port number. Port must be between 1024 and 65535.");
        }

        this.port = port;
        this.keyValueStore = new HashMap<>();
        this.serverSocket = null;
        this.running = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println("NameServer started on port " + port);

            while (running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Handle client request in a separate thread
                Thread requestHandlerThread = new Thread(new RequestHandler(clientSocket, keyValueStore, this));
                requestHandlerThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error occurred while starting NameServer: " + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            running = false;
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println("NameServer stopped.");
            }
        } catch (IOException e) {
            System.err.println("Error occurred while stopping NameServer: " + e.getMessage());
        }
    }
}
