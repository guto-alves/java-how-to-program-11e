package ch28.ex28_14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {
	private String host;
	private Socket client;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	private MessageReceivedListener messageReceivedListener;

	public Client(String host, MessageReceivedListener messageReceivedListener) throws IOException {
		this.host = host;
		this.messageReceivedListener = messageReceivedListener;
		connectToServer();
		getStreams();
	}

	@Override
	public void run() {
		try {
			processConnection();
		} catch (IOException e) {
		}
	}

	private void connectToServer() throws IOException {
		client = new Socket(InetAddress.getByName(host), Server.SERVER_PORT);
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
				messageReceivedListener.messageReceived(serverMessage);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeConnection() {
		try {
			input.close();
			output.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendData(String message) {
		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			System.out.println("Error writing message");
		}
	}

	public interface MessageReceivedListener {
		public abstract void messageReceived(String message);
	}
}
