/* 6.29 (Coin Tossing) Write an application that simulates coin tossing. Let
the program toss a coin each time the user chooses the “Toss Coin”
menu option. Count the number of times each side of the coin appears.
Display the results. The program should call a separate method flip that
takes no arguments and returns a value from a Coin enum (HEADS and
TAILS). [Note:If the program realistically simulates coin tossing, each
side of the coin should appear approximately half the time.] */

package ch06.ex06_29;

import java.security.SecureRandom;
import java.util.Scanner;

public class CoinTossing {
	private static final SecureRandom random = new SecureRandom();

	private enum Coin {
		HEADS, TAILS
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int headsCount = 0;
		int tailsCount = 0;

		String message = "Options Menu\n" + "1 - Toss Coin\n" + "2 - Display the results\n" + "9 - To quit\n"
				+ "Enter an option: ";

		int option = 0;

		while (option != 9) {
			System.out.print(message);
			option = scanner.nextInt();

			switch (option) {
			case 1:
				if (flip() == Coin.HEADS)
					headsCount++;
				else
					tailsCount++;
				break;
			case 2:
				displayResults(headsCount, tailsCount);
				break;
			case 9:
				break;
			default:
				System.err.println("\nInvalid option. Try again\n");
			}
		}
		scanner.close();
	}

	public static void displayResults(int headsCount, int tailsCount) {
		System.out.println("\t Results");
		System.out.printf("\tHEADS TAILS%n");
		System.out.printf("\t%3d %4d%n", headsCount, tailsCount);
	}

	public static Coin flip() {
		return random.nextInt(2) == 0 ? Coin.HEADS : Coin.TAILS;
	}

}
