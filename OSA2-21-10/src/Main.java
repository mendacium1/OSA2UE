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

        // Simulate client requests for testing
        sendRequest("PUT name John", port);
        sendRequest("PUT age 25", port);
        sendRequest("GET name", port);
        sendRequest("GET age", port);
        sendRequest("DEL age", port);
        sendRequest("GET age", port);
        sendRequest("STOP", port);

        // Wait for the server to stop
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void sendRequest(String request, int port) {
        System.out.println("Sending request: " + request);
        try (Socket socket = new Socket("localhost", port);
             OutputStream output = socket.getOutputStream();
             InputStream input = socket.getInputStream()) {
                output.write(request.getBytes());

                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                if (bytesRead > 0) {
                    String response = new String(buffer, 0, bytesRead);
                    System.out.println("Response: " + response);
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}