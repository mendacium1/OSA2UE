package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class KnockKnockClient {

	public static void main(String[] args) {
		new KnockKnockClient().knock();
	}

	private void knock() {
		try (Socket client = new Socket("127.0.0.1", 1200)) {
			PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
			writer.println("KnockKnock");

			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
