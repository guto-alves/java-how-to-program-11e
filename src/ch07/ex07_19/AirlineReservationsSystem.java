/* 14. 7.19 (Airline Reservations System) A small airline has just purchased a
computer for its new automated reservations system. You’ve been asked to
develop the new system. You’re to write an application to assign seats on
each flight of the airline’s only plane (capacity: 10 seats).
Your application should display the following alternatives: Please
type 1 for First Class and Please type 2 for
Economy. If the user types 1, your application should assign a seat in the
first-class section (seats 1–5). If the user types 2, your application should
assign a seat in the economy section (seats 6–10). Your application should
then display a boarding pass indicating the person’s seat number and
whether it’s in the first-class or economy section of the plane.
Use a one-dimensional array of primitive type boolean to represent the
seating chart of the plane. Initialize all the elements of the array to false
to indicate that all the seats are empty. As each seat is assigned, set the
corresponding element of the array to true to indicate that the seat is no
longer available.
Your application should never assign a seat that has already been assigned.
When the economy section is full, your application should ask the person
if it’s acceptable to be placed in the first-class section (and vice versa). If
yes, make the appropriate seat assignment. If no, display the message
"Next flight leaves in 3 hours." */

package ch07.ex07_19;

import java.util.Scanner;

public class AirlineReservationsSystem {
	private static final int TOTAL_SEATS = 11;
	private static boolean[] seats = new boolean[TOTAL_SEATS];

	private enum Class {
		FIRST, ECONOMIC
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int option = 0;
		int seatNumber = 0;

		while (option != 9) {
			System.out.print(" - Please type\n" + "1 for First Class and \n" + "2 for Economy or\n" + "9 to quit.\n"
					+ " --> Option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				seatNumber = checkAvailableSeat(Class.FIRST);

				if (seatNumber != -1) {
					assignSeat(seatNumber);
					displayBoardingPass(seatNumber, Class.FIRST);
				} else { // try in another section
					seatNumber = checkAvailableSeat(Class.ECONOMIC);

					if (seatNumber != -1) {
						System.out.print(
								"\n\tFirst class is full!\nAccepts to be placed in the economic section?\n1 - Yes\n2 - Not\nEnter your option: ");
						option = input.nextInt();

						if (option == 1) {
							assignSeat(seatNumber);
							displayBoardingPass(seatNumber, Class.ECONOMIC);
						} else
							System.out.println("\nNext flight leaves in 3 hours.\n");
					} else
						System.out.println("\nNo more seats available. The plane is full.\n");
				}
				break;
			case 2:
				seatNumber = checkAvailableSeat(Class.ECONOMIC);

				if (seatNumber != -1) {
					assignSeat(seatNumber);
					displayBoardingPass(seatNumber, Class.ECONOMIC);
				} else { // try in another section
					seatNumber = checkAvailableSeat(Class.FIRST);

					if (seatNumber != -1) {
						System.out.print(
								"\n\tEconomic section is full!\nAccepts to be placed in the first-class section?\n1 - Yes\n2 - Not\nEnter your option: ");
						option = input.nextInt();

						if (option == 1) {
							assignSeat(seatNumber);
							displayBoardingPass(seatNumber, Class.FIRST);
						} else
							System.out.println("\nNext flight leaves in 3 hours.\n");
					} else
						System.out.println("\nNo more seats available. The plane is full.\n");
				}
				break;
			case 9:
				break;
			default:
				System.out.println("\nInvalid option. Try again.\n");
				break;
			}
		}

		input.close();
	}

	public static void displayBoardingPass(int seatNumber, Class section) {
		System.out.println("\n\t  Boarding Pass");
		System.out.printf("\tSeat number: %d%n\tClass: %s%n%n", seatNumber, section);
	}

	public static void assignSeat(int seatNumber) {
		seats[seatNumber] = true;
	}

	public static int checkAvailableSeat(Class section) {
		int seatNumber = -1;

		switch (section) {
		case FIRST:
			for (int i = 1; i <= TOTAL_SEATS / 2; i++) {
				if (seats[i] == false) {
					seatNumber = i;
					break;
				}
			}
			break;
		case ECONOMIC:
			for (int i = TOTAL_SEATS / 2 + 1; i < TOTAL_SEATS; i++) {
				if (seats[i] == false) {
					seatNumber = i;
					break;
				}
			}
			break;
		}

		return seatNumber;
	}

}
