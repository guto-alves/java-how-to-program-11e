// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing.

package ch07.ex07_31;

public class DeckOfCardsTest {

	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order

		Card[] hand1 = new Card[5];
		Card[] hand2 = new Card[5];

		for (int i = 0; i < 5; i++) {
			hand1[i] = myDeckOfCards.dealCard();
			hand2[i] = myDeckOfCards.dealCard();
		}

		System.out.print("Hand 1: ");
		displayHand(hand1);
		System.out.print("Hand 2: ");
		displayHand(hand2);

		System.out.println();

		if (myDeckOfCards.compareHands(hand1, hand2) == 1)
			System.out.println("Hand 1 won!");
		else if (myDeckOfCards.compareHands(hand1, hand2) == -1)
			System.out.println("Hand 2 won!");
		else
			System.out.println("Draw");

	}

	public static void displayHand(Card[] hand) {
		for (Card card : hand)
			System.out.printf("%s - ", card);

		System.out.println();
	}
}
