// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.

package ch07.ex07_30;

public class DeckOfCardsTest {

	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order

		// print all 52 Cards in the order in which they are dealt
		for (int i = 1; i <= 5; i++) {
			// deal and display a Card
			System.out.printf("%-19s", myDeckOfCards.dealCard());
		}
	}
}
