import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

public class RequestHandler implements Runnable {
    private final Socket clientSocket;
    private final Map<String, String> keyValueStore;
    private final NameServer nameServer;

    public RequestHandler(Socket clientSocket, Map<String, String> keyValueStore, NameServer nameServer) {
        this.clientSocket = clientSocket;
        this.keyValueStore = keyValueStore;
        this.nameServer = nameServer;
    }

    @Override
    public void run() {
        try (InputStream input = clientSocket.getInputStream();
             OutputStream output = clientSocket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);

            if (bytesRead > 0) {
                String request = new String(buffer, 0, bytesRead);
                String response = processRequest(request);
                output.write(response.getBytes());
            }
        } catch (IOException e) {
            System.err.println("Error occurred while handling client request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error occurred while closing client socket: " + e.getMessage());
            }
        }
    }

    private String processRequest(String request) {
        String[] parts = request.trim().split(" ");
        String command = parts[0];

        switch (command) {
            case "PUT":
                if (parts.length < 3) {
                    return "ERROR\n" + "400 Bad Request\n" + command + "\n";
                }
                String key = parts[1];
                String value = parts[2];
                synchronized (keyValueStore) {
                    keyValueStore.put(key, value);
                }
                return "SUCCESS\n" + "Entry stored:\n" + value + "\n";
            case "GET":
                if (parts.length < 2) {
                    return "ERROR\n" + "400 Bad Request\n" + command + "\n";
                }
                key = parts[1];
                synchronized (keyValueStore) {
                    value = keyValueStore.get(key);
                }
                return value != null ? "SUCCESS\n" + "Entry:\n" + value + "\n":
                        "ERROR\n" + "404 Not Found\n" + command + "\n";
            case "DEL":
                if (parts.length < 2) {
                    return "ERROR\n" + "400 Bad Request\n" + command + "\n";
                }
                key = parts[1];
                synchronized (keyValueStore) {
                    value = keyValueStore.remove(key);
                }
                return value != null ? "SUCCESS\n" + "Entry deleted:\n" + value + "\n":
                        "ERROR\n" + "404 Not Found\n" + command + "\n";
            case "STOP":
                nameServer.stop();
                return "SUCCESS\n" + "Server stopped\n";
            default:
                return "ERROR\n" + "400 Bad Request\n" + command + "\n";
        }
    }
}
