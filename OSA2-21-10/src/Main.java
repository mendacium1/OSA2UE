import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 12345; // Replace with your desired port number
        NameServer nameServer = new NameServer(port);
        Thread serverThread = new Thread(() -> nameServer.start());
        serverThread.start();

        // Wait for the server to start
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The following section could also be simulated with netcat
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