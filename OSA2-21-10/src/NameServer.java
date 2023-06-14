import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * The NameServer class represents a server that maps names to addresses.
 * It listens for client connections on a specified port and handles client requests.
 * @author Jakob Mayr
 */
public class NameServer {
    private final int port;
    private final Map<String, String> nameToAddress;
    private ServerSocket serverSocket;
    private boolean running;
    private final String infoTag = "[I]: ";
    private final String errorTag = "[E]: ";

    /**
     * Constructs a NameServer object with the specified port number.
     * @param port The port number to listen on.
     * @throws IllegalArgumentException If the port number is invalid (not within the range 1024-65535).
     */
    public NameServer(int port) throws IllegalArgumentException {
        if (port < 1024 || port > 65535) {
            throw new IllegalArgumentException("Invalid port number. Port must be between 1024 and 65535.");
        }

        this.port = port;
        this.nameToAddress = new HashMap<>();
        this.serverSocket = null;
        this.running = false;
    }

    /**
     * Starts the NameServer by creating a server socket and accepting client connections.
     * Each client connection is handled in a separate thread by a RequestHandler object.
     * The server continues running until explicitly stopped.
     */
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

    /**
     * Stops the NameServer by setting the running flag to false and closing the server socket.
     * The method also prints a message indicating that the NameServer has stopped.
     */
    public void stop() {
        try {
            running = false;
            if (serverSocket != null) {
                serverSocket.close();
                System.out.println(infoTag + "NameServer stopped.");
            }
        } catch (IOException e) {
            System.err.println(errorTag + "Error occurred while stopping NameServer: " + e.getMessage());
        }
    }
}

