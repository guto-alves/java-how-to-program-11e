package ch28.ex28_14;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReaderServer {
	public static final int SERVER_PORT = 12349;

	private ServerSocket server;
	private Socket connection;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	private Path currentPath;

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
		System.out.println("Connected");
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();

		input = new ObjectInputStream(connection.getInputStream());
	}

	private void processConnection() throws IOException {
		String message = "";
		
		do {
			try { 
				message = (String) input.readObject();

				if (!message.equals("-1")) {

					try {
						Path path = Paths.get(message);

						if (!Files.isDirectory(path)) {
							sendData(getFileContent(path));
							currentPath = path;
						}
					} catch (InvalidPathException e) {
						saveFileChanges(message);
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
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
			System.out.println("Error sending message"); 
		}
	}

	public void saveFileChanges(String fileText) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(currentPath.toFile()));
			writer.write(fileText);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error the to save changes");
		}
	}

	public String getFileContent(Path path) {
		StringBuilder fileText = new StringBuilder();

		try {
			Scanner reader = new Scanner(path);

			while (reader.hasNext()) {
				fileText.append(reader.nextLine());
				fileText.append("\n");
			}
			reader.close();

		} catch (IOException e) {
			sendData("File not exists");
		}

		return fileText.toString();
	}
}
