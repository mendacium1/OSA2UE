import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class NameServer {
    private final int port;
    private final Map<String, String> nameToAddress;
    private ServerSocket serverSocket;
    private boolean running;
    private final String infoTag = "[I]: ";
    private final String warningTag = "[W]: ";
    private final String errorTag = "[E]: ";
    public NameServer(int port) {
        if (port < 1024 || port > 65535) {
            throw new IllegalArgumentException("Invalid port number. Port must be between 1024 and 65535.");
        }

        this.port = port;
        this.nameToAddress = new HashMap<>();
        this.serverSocket = null;
        this.running = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println(infoTag + "NameServer started on port " + port);

            while (running) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println(infoTag + "New client connected: " + clientSocket.getInetAddress());
                    // Handle client request in a separate thread
                    Thread requestHandlerThread = new Thread(new RequestHandler(clientSocket, nameToAddress, this));
                    requestHandlerThread.start();
                } catch (IOException e) {
                    System.out.println(errorTag + "Error occurred while handling Client connection: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println(errorTag + "Error occurred while starting NameServer: " + e.getMessage());
        } finally {
            stop();
        }
    }

    public void stop() {
        try {
            running = false;
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println(infoTag + "NameServer stopped.");
            }
        } catch (IOException e) {
            System.out.println(errorTag + "Error occurred while stopping NameServer: " + e.getMessage());
        }
    }
}
