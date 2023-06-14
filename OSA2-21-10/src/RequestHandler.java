import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

public class RequestHandler implements Runnable {
    private final Socket clientSocket;
    private final Map<String, String> nameToAddress;
    private final NameServer nameServer;
    private final String infoTag = "[I]: ";
    private final String warningTag = "[W]: ";
    private final String errorTag = "[E]: ";
    public RequestHandler(Socket clientSocket, Map<String, String> nameToAddress, NameServer nameServer) {
        this.clientSocket = clientSocket;
        this.nameToAddress = nameToAddress;
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
            System.out.println("Error occurred while handling client request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error occurred while closing client socket: " + e.getMessage());
            }
        }
    }

    private String processRequest(String request) {
        String[] parts = request.trim().split(" ");
        String command = parts[0];

        switch (command) {
            case "PUT":
                if (parts.length < 3) {
                    System.out.println(errorTag + "404 Bad request: " + request);
                    return "ERROR\n" + "400 Bad Request\n" + command + "\n";
                }
                String key = parts[1];
                String value = parts[2];
                synchronized (nameToAddress) {
                    nameToAddress.put(key, value);
                }
                System.out.println(infoTag + "200 OK: " + request);
                return "SUCCESS\n" + "Entry stored:\n" + value + "\n";
            case "GET":
                if (parts.length < 2) {
                    System.out.println(errorTag + "404 Bad request: " + request);
                    return "ERROR\n" + "400 Bad Request\n";
                }
                key = parts[1];
                synchronized (nameToAddress) {
                    value = nameToAddress.get(key);
                }
                if (value != null) {
                    System.out.println(infoTag + "200 OK: " + request);
                    return "SUCCESS\n" + "Entry:\n" + value + "\n";
                } else {
                    System.out.println(errorTag + "404 Not Found: " + request);
                    return "ERROR\n" + "404 Not Found\n";
                }
            case "DEL":
                if (parts.length < 2) {
                    System.out.println(errorTag + "404 Bad request: " + request);
                    return "ERROR\n" + "400 Bad Request\n";
                }
                key = parts[1];
                synchronized (nameToAddress) {
                    value = nameToAddress.remove(key);
                }
                if (value != null) {
                    System.out.println(infoTag + "200 OK: " + request);
                    return "SUCCESS\n" + "Entry deleted:\n" + value + "\n";
                } else {
                    System.out.println(errorTag + "404 Bad request: " + request);
                    return "ERROR\n" + "404 Not Found\n";
                }
            case "STOP":
                nameServer.stop();
                return "SUCCESS\n" + "Server stopped\n";
            default:
                System.out.println(errorTag + "404 Bad request: " + request);
                return "ERROR\n" + "400 Bad Request\n";
        }
    }
}
