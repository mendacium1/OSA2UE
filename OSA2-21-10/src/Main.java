import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * The Main class is the entry point of the application.
 * It demonstrates the usage of the NameServer class by sending simulated client requests to the server.
 * The output for the simulation is color-coded in blue, so it is clearer what output belongs to the test.
 * Note: The simulation could also be done with netcat or a similar tool.
 * @author Jakob Mayr
 */
public class Main {
    /**
     * The main method starts the NameServer on a specified port and sends simulated client requests.
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Port between 1024-65535
        int port = 12345;
        NameServer nameServer = new NameServer(port);
        Thread serverThread = new Thread(() -> nameServer.start());
        serverThread.start();

        // Wait for the server to start (otherwise the tests start requesting to no server)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulate client requests for testing
        // OK tests
        sendRequest("PUT google.com 8.8.8.8", port);
        sendRequest("PUT github.com 140.82.121.3", port);
        sendRequest("GET google.com", port);
        sendRequest("GET github.com", port);
        sendRequest("DEL github.com", port);

        // Not Found tests
        sendRequest("GET github.com", port);
        sendRequest("GET microsoft.com", port);

        // Bad Request tests
        sendRequest("GIVE google.com", port);
        sendRequest("PUT rofl", port);
        sendRequest("GET 8.8.8.8", port);

        // Stopping server
        sendRequest("STOP", port);

        // Wait for the server to stop
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a request to the server using a specified request string and port number.
     * Prints the request and response to the console.
     *
     * @param request The request string to be sent.
     * @param port    The port number to connect to.
     */
    private static void sendRequest(String request, int port) {
        System.out.println("\u001B[34mSending request: " + request + "\u001B[0m");
        try (Socket socket = new Socket("localhost", port);
             OutputStream output = socket.getOutputStream();
             InputStream input = socket.getInputStream()) {
            output.write(request.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead > 0) {
                String response = new String(buffer, 0, bytesRead);
                System.out.println("\u001B[34mResponse: " + response + "\u001B[0m");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}