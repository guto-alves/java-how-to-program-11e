package ch07.ex07_37;

import java.util.Scanner;

public class ComputerSimulator {
	private static final Scanner input = new Scanner(System.in);

	private static final int TOTAL_MEMORY = 100;
	private static int[] memory = new int[TOTAL_MEMORY];

	private int accumulator;
	private int operationCode;
	private int operand;
	private int instructionCounter;
	private int instructionRegister;

	// Operation codes
	private static final int READ = 10;
	private static final int WRITE = 11;
	private static final int LOAD = 20;
	private static final int STORE = 21;
	private static final int ADD = 30;
	private static final int SUBTRACT = 31;
	private static final int DIVIDE = 32;
	private static final int MULTIPLY = 33;
	private static final int BRANCH = 40;
	private static final int BRANCHNEG = 41;
	private static final int BRANCHZERO = 42;
	private static final int HALT = 43;

	public void readInstructions() {
		System.out
				.println("*** Welcome to Simpletron! ***\r\n" + "*** Please enter your program one instruction ***\r\n"
						+ "*** (or data word) at a time. I will display ***\r\n"
						+ "*** the location number and a question mark (?). ***\r\n"
						+ "*** You then type the word for that location. ***\r\n"
						+ "*** Type -99999 to stop entering your program. ***");

		int instruction = 0;
		instructionCounter = 0;

		System.out.printf("%02d ? ", instructionCounter);
		instruction = input.nextInt();

		while (instruction != -99999) {
			if (instruction / 1000 > 0 && instruction / 1000 < 10) {
				memory[instructionCounter] = instruction;
				instructionCounter++;
			} else
				printError("Warning: invalid instruction. Try again.");

			System.out.printf("%02d ? ", instructionCounter);
			instruction = input.nextInt();
		}

		System.out.println("*** Program loading completed ***\r");
	}

	public void runSML() {
		System.out.println("*** Program execution begins ***");
		instructionCounter = 0;

		while (instructionRegister != HALT * 100) {
			instructionRegister = memory[instructionCounter];
			instructionCounter++;

			operationCode = instructionRegister / 100;
			operand = instructionRegister % 100;

			switch (operationCode) {
			case READ:
				System.out.print("Enter an integer: ");
				int number = input.nextInt();

				memory[operand] = number;

				if (number < -9999 || number > 9999) {
					System.err.println(
							"*** Register overflow ***\r\n" + "*** Simpletron execution abnormally terminated ***\n");
					return;
				}
				break;
			case WRITE:
				System.out.println(memory[operand]);
				break;
			case LOAD:
				accumulator = memory[operand];
				break;
			case STORE:
				memory[operand] = accumulator;
				break;
			case ADD:
				accumulator += memory[operand];

				if (accumulator > 9999) {
					printError(
							"*** Accumulator overflow ***\r\n" + "*** Simpletron execution abnormally terminated ***");
					return;
				}

				break;
			case SUBTRACT:
				accumulator -= memory[operand];

				if (accumulator < -9999) {
					printError(
							"*** Accumulator overflow ***\r\n" + "*** Simpletron execution abnormally terminated ***");
					return;
				}

				break;
			case DIVIDE:
				if (memory[operand] == 0) {
					printError("*** Attempt to divide by zero ***\r\n"
							+ "*** Simpletron execution abnormally terminated ***");
					return;
				}

				accumulator /= memory[operand];
				break;
			case MULTIPLY:
				accumulator *= memory[operand];

				if (accumulator > 9999) {
					printError("*** Accumulator overflow ***\r\n"
							+ "*** Simpletron execution abnormally terminated ***\n");
					return;
				}

				break;
			case BRANCH:
				instructionCounter = operand;
				break;
			case BRANCHNEG:
				if (accumulator < 0)
					instructionCounter = operand;
				break;
			case BRANCHZERO:
				if (accumulator == 0)
					instructionCounter = operand;
				break;
			case HALT:
				System.out.println("*** Simpletron execution terminated ***");
				break;
			default:
				printError("*** Attempt to execute invalid operation code ***\r\n"
						+ "*** Simpletron execution abnormally terminated ***");
				return;
			}
		}
	}

	public void printDump() {
		System.out.println("\n\nREGISTERS:");
		System.out.printf("accumulator %s%04d%n", accumulator >= 0 ? "+" : "-",
				accumulator < 0 ? accumulator * -1 : accumulator);
		System.out.printf("instructionCounter %02d%n", instructionCounter);
		System.out.printf("instructionRegister +%04d%n", instructionRegister);
		System.out.printf("operationCode %02d%n", operationCode);
		System.out.printf("operand %02d%n", operand);

		System.out.println("\nMEMORY:");
		for (int i = 0; i < 10; i++)
			System.out.printf("%6d", i);

		for (int i = 0; i < memory.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
				System.out.printf("%2d ", i);
			}

			System.out.printf("%s%04d ", memory[i] >= 0 ? "+" : "-", memory[i] < 0 ? memory[i] * -1 : memory[i]);
		}
	}

	private void printError(String message) {
		System.out.printf("%n%s%n%n", message);
	}

}
