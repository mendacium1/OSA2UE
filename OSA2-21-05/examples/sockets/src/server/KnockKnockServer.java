package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer {

	public static void main(String[] args) {
		new KnockKnockServer().service();
	}

	private void service() {
		try (ServerSocket server = new ServerSocket(1200)) {
			while (true) {
				Socket client = server.accept();
				handle(client);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void handle(Socket client) {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true)) {

			System.out.println(in.readLine());

			out.println("Whose there?");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
