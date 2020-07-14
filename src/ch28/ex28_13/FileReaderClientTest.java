package ch28.ex28_13;

public class FileReaderClientTest {

	public static void main(String[] args) {
		FileReaderClient application = new FileReaderClient("localhost"); // or 127.0.0.1
		application.run();
	}

}
