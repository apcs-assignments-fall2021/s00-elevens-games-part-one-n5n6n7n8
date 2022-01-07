import java.lang.reflect.Array;
import java.util.ArrayList;

// The Deck class represents a shuffled deck of cards.
// It provides several operations including
// initialize, shuffle, deal, and check if empty.
public class Deck {
	// cards is an ArrayList of all the Card objects in our deck
	private ArrayList<Card> cardsList;

	// size is the number of not-yet-dealt cards.
	// Cards are dealt from the top (highest index) down.
	// The next card to be dealt is at size - 1.
	private int size;

	// Creates a new Deck instance given arrays of ranks, suits, and values
	// You will need to initialize both the cardsList and size instance variables
	// You should go through and make all possible pairs of suits and ranks
	public Deck(String[] ranks, String[] suits, int[] values) {
		cardsList = new ArrayList<Card>();
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				cardsList.add(new Card(ranks[j], suits[i], values[j]));
			}
		}
		size = cardsList.size();
	}
	// Deals a card from this deck.
	// return the card just dealt, or null if all the cards have been dealt already
	// Recall that the cards are dealt from top (highest-index) down
	// Updates the size as well
	public Card deal() {
		Card cardToRemove = cardsList.get(size-1);
		cardsList.remove(size-1);
		size = cardsList.size();
        return cardToRemove;
	}

	// Determines if this deck is empty (there are no undealt cards).
	// returns true if this deck is empty, false otherwise.
	public boolean isEmpty() {
		return size==0;
	}

	// Returns the size (number of undealt cards) in this deck.
	public int getSize() {
		return size;
	}

	// Shuffles the deck by repeatedly randomly swapping pairs of cards
	// This method should change the order of the cards in cardsList
	// Shuffling should also reset the size variable to its original value
	public void shuffle() {
		if(size==1||size==0) {
			return;
		}
		for (int i = 0; i < 20; i++) {
			int indexA = (int) (Math.random()*size);
			int indexB = (int) (Math.random()*size);
			Boolean matching = true;
			while(matching) {
				indexB = (int) (Math.random()*size);
				matching = indexA==indexB;
			}
			swapCards(indexA, indexB);
		}

	}
	public void swapCards(int indexA, int indexB) {
		Card A = cardsList.get(indexA);
		Card B = cardsList.get(indexB);
		cardsList.set(indexB, A);
		cardsList.set(indexA, B);
	}

	// OPTIONAL: Write code that carries out a "perfect" shuffle
	// that perfectly interweaves the two halves of the deck
	public void perfectShuffle() {
		ArrayList<Card> pS = new ArrayList();
		int halfwayindex = size/2;
		for (int i = 0; i < size/2; i++) {
			pS.add(cardsList.get(i));
			pS.add(cardsList.get(halfwayindex+i));
		}
		cardsList = pS;
	}








	// CODE BELOW HERE IS ALREADY WRITTEN:

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		if (cardsList == null) {
			return "";
		}

		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cardsList.size() - 1; k >= size; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cardsList.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	// Returns the card at the given index of the deck
	// This method should only be used in testing code
	public Card getCardAtIndex(int idx) {
		return cardsList.get(idx);
	}

	// This version of equals() is used in the testing code
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		else {
			return cardsList.equals(((Deck) o).cardsList);
		}
	}
}
