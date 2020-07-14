package ch28.ex28_13;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileReaderServer {
	public static final int SERVER_PORT = 12348;

	private ServerSocket server;
	private Socket connection;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public void runServer() {
		try {
			server = new ServerSocket(SERVER_PORT, 100);

			while (true) {
				try {
					waitForConnection();
					getStreams();
					processConnection();
				} catch (EOFException e) {
					System.out.println("Client terminated the connection");
				} finally {
					closeConnection();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void waitForConnection() throws IOException {
		System.out.println("Waiting for connection... ");
		connection = server.accept();
		System.out.println("Connection received from: " + 
				connection.getInetAddress().getHostName());
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();

		input = new ObjectInputStream(connection.getInputStream());
		System.out.println("Got I/O streams");
	}

	private void processConnection() throws IOException {
		String message = "";

		do {
			try {
				message = (String) input.readObject();

				if (!message.equals("-1")) {
					try {
						Path path = Paths.get(message);

						if (!Files.exists(path) || Files.isDirectory(path)) {
							sendData("The file does not exists.");
						} else {
							sendData(getFileContent(path));
						}
					} catch (InvalidPathException e) {
						sendData("Invalid Path");
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception ignored) {
			}
		} while (!message.equals("-1"));
	}

	private void closeConnection() {
		try {
			input.close();
			output.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendData(String message) {
		try {
			output.writeObject(message);
			output.flush();
		} catch (IOException e) {
			System.out.println("Error sending data");
		}
	}

	public String getFileContent(Path path) {		
		try {
			return Files.lines(path)
				.collect(Collectors.joining("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
