// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.

package ch07.ex07_31;

import java.security.SecureRandom;

public class DeckOfCards {
	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

	private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
	private int currentCard = 0; // index of next Card to be dealt (0-51)

	// constructor fills deck of Cards
	public DeckOfCards() {
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

		// populate deck with Card objects
		for (int count = 0; count < deck.length; count++) {
			deck[count] = new Card(faces[count % 13], suits[count / 13]);
		}
	}

	// shuffle deck of Cards with one-pass algorithm
	public void shuffle() {
		// next call to method dealCard should start at deck[0] again
		currentCard = 0;

		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < deck.length; first++) {
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			// swap current Card with randomly selected Card
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	// deal one Card
	public Card dealCard() {
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length) {
			return deck[currentCard++]; // return current Card in array
		} else {
			return null; // return null to indicate that all Cards were dealt
		}
	}

	public int compareHands(Card[] hand1, Card[] hand2) {
		int handPower1 = 0;
		int handPower2 = 0;

		if (isFullHouse(hand1))
			handPower1 = 10;
		else if (isStraight(hand1))
			handPower1 = 9;
		else if (isFlush(hand1))
			handPower1 = 8;
		else if (isFourOfAKind(hand1))
			handPower1 = 7;
		else if (isThreeOfAKind(hand1))
			handPower1 = 6;
		else if (isTwoPairs(hand1))
			handPower1 = 5;
		else if (isPair(hand1))
			handPower1 = 4;

		if (isFullHouse(hand2))
			handPower2 = 10;
		else if (isStraight(hand2))
			handPower2 = 9;
		else if (isFlush(hand2))
			handPower2 = 8;
		else if (isFourOfAKind(hand2))
			handPower2 = 7;
		else if (isThreeOfAKind(hand2))
			handPower2 = 6;
		else if (isTwoPairs(hand2))
			handPower2 = 5;
		else if (isPair(hand2))
			handPower2 = 4;

		if (handPower1 > handPower2)
			return 1;
		else if (handPower2 > handPower1)
			return -1;
		else
			return 0;
	}

	public boolean isPair(Card... cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getFace().equals(cards[j].getFace()))
					return true;
			}
		}

		return false;
	}

	public boolean isTwoPairs(Card... cards) {
		Card firstPair = null;
		Card secondPair = null;

		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getFace().equals(cards[j].getFace())) {
					firstPair = cards[i];
					break;
				}
			}
		}

		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getFace().equals(cards[j].getFace()) && !(cards[i].getSuit().equals(firstPair.getSuit())
						&& cards[i].getFace().equals(firstPair.getFace())))
					secondPair = cards[i];
			}
		}

		return firstPair != null && secondPair != null;
	}

	public boolean isThreeOfAKind(Card... cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			int faceCount = 1;

			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getFace().equals(cards[j].getFace()))
					faceCount++;
			}

			if (faceCount == 3)
				return true;
		}

		return false;
	}

	public boolean isFourOfAKind(Card... cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			int faceCount = 1;

			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getFace().equals(cards[j].getFace()))
					faceCount++;
			}

			if (faceCount == 4)
				return true;
		}

		return false;
	}

	public boolean isFlush(Card... cards) {
		Card firstCard = cards[0];

		int suitCount = 1;

		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getSuit().equals(firstCard.getSuit()))
				suitCount++;
		}

		return suitCount == 5;
	}

	public boolean isStraight(Card... cards) {
		Card[] sortedCards = new Card[cards.length];
		System.arraycopy(cards, 0, sortedCards, 0, cards.length);

		sortCards(sortedCards);

		int currentValue = valueOf(sortedCards[0].getFace());

		for (int i = 1; i < sortedCards.length; i++) {
			if (valueOf(sortedCards[i].getFace()) == currentValue + 1)
				currentValue++;
			else
				return false;
		}

		return true;
	}

	public boolean isFullHouse(Card... cards) {
		int firstValueCount = 1;
		int firstValue = valueOf(cards[0].getFace());

		for (int i = 1; i < cards.length; i++) {
			if (valueOf(cards[i].getFace()) == firstValue)
				firstValueCount++;
		}

		if (firstValueCount == 2 || firstValueCount == 3) {
			int secondValueCount = 1;
			int secondValue = 0;
			int initialIndex = 0;

			for (int i = 0; i < cards.length; i++) {
				if (valueOf(cards[i].getFace()) != firstValue) {
					secondValue = valueOf(cards[i].getFace());
					initialIndex = i;
					break;
				}
			}

			for (int i = initialIndex + 1; i < cards.length; i++) {
				if (valueOf(cards[i].getFace()) == secondValue)
					firstValueCount++;
			}

			if (secondValueCount == 2 || secondValueCount == 3)
				return true;
		}

		return false;
	}

	private void sortCards(Card... cards) {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (valueOf(cards[i].getFace()) > valueOf(cards[j].getFace())) {
					Card card = cards[i];
					cards[i] = cards[j];
					cards[j] = card;
				}
			}
		}
	}

	private int valueOf(String face) {
		String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };

		for (int i = 0; i < faces.length; i++) {
			if (faces[i].equals(face))
				return i;
		}

		return -1;
	}

}
