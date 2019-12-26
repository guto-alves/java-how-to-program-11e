package ch28.ex28_13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class FileReaderClient {
	private String host;
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public FileReaderClient(String host) {
		this.host = host;
	}

	public void run() {
		try {
			connectToServer();
			getStreams();
			execute();
			processConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void connectToServer() throws IOException {
		client = new Socket(InetAddress.getByName(host), FileReaderServer.SERVER_PORT);
	}

	private void getStreams() throws IOException {
		input = new ObjectInputStream(client.getInputStream());
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
	}

	private void processConnection() throws IOException {
		String serverMessage = "";

		while (true) {
			try {
				serverMessage = (String) input.readObject();
				System.out.println(serverMessage);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeConnection() {
		try {
			input.close();
			output.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void execute() {
		Scanner scanner = new Scanner(System.in);

		String message = "";

		System.out.print("Enter the file path: ");
		message = scanner.nextLine();
		sendData(message);

		scanner.close();
	}

	private void sendData(String message) {
		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			System.out.println("Error writing message");
		}
	}

	public static void main(String[] args) {
		FileReaderClient client = new FileReaderClient("127.0.0.1");
		client.run();
	}

}
