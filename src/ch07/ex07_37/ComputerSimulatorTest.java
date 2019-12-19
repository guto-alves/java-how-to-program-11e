package ch07.ex07_37;

public class ComputerSimulatorTest {

	public static void main(String[] args) {
		ComputerSimulator computerSimulator = new ComputerSimulator();

		computerSimulator.readInstructions();
		computerSimulator.runSML();
		computerSimulator.printDump();
	}

}
