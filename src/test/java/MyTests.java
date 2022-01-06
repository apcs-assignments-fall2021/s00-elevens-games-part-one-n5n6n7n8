import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTests {

    @Test
    public void testCardGetters() {
        Card c = new Card("jack", "spades", 11);
        assertEquals("jack", c.getRank(), "The rank of the Jack of Spades should be: jack");
        assertEquals("spades", c.getSuit(), "The suit of the Jack of Spades should be: spades");
        assertEquals(11, c.getPointValue(), "The point value of the Jack of Spades should be: 11");
    }

    @Test
    public void testCardEquals() {
        Card c1 = new Card("jack", "spades", 11);
        Card c2 = new Card("jack", "hearts", 11);
        Card c3 = new Card("queen", "spades", 12);
        Card c4 = new Card("jack", "spades", 11);

        assertEquals(false, c1.equals(c2), "The jack of spades shouldn't match the jack of hearts");
        assertEquals(false, c1.equals(c3), "The jack of spades shouldn't match the queen of spades");
        assertEquals(true, c1.equals(c4), "The jack of spades should match the jack of spades");
    }

    @Test
    public void testDeckConstructor() {
        String[] ranks = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
        String[] suits = { "spades", "hearts", "diamonds", "clubs" };
        int[] pointValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };
        Deck deck1 = new Deck(ranks, suits, pointValues);

        Card c1 = new Card("ace", "spades", 1);
        Card c2 = new Card("2", "spades", 2);
        Card c3 = new Card("3", "hearts", 3);


        assertEquals(c1, deck1.getCardAtIndex(0), "The 1st card in the deck should be: ace of spades");
        assertEquals(c2, deck1.getCardAtIndex(1), "The 2nd card in the deck should be: two of spades");
        assertEquals(c3, deck1.getCardAtIndex(15), "The 16th card in the deck should be: three of hearts");
    }

    @Test
    public void testDeal() {
        // Make a small deck
        String[] ranks = {"jack", "queen", "king", "ace"};
        String[] suits = {"spades", "hearts"};
        int[] values = {11, 12, 13, 14};
        Deck d1 = new Deck(ranks, suits, values);

        Card c1 = new Card("ace", "hearts", 14);
        Card c2 = new Card("king", "hearts", 13);


        assertEquals(c1, d1.deal(), "The 1st card to be dealt should be: ace of hearts");
        assertEquals(c2, d1.deal(), "The 2nd card to be dealt should be: king of hearts");
        d1.deal();
        d1.deal();
        d1.deal();
        d1.deal();
        d1.deal();
        d1.deal();
        assertEquals(null, d1.deal(), "When the deck is empty, dealing should return: null");
    }

    @Test
    public void testSelectionShuffle() {
        String[] ranks = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king" };
        String[] suits = { "spades", "hearts", "diamonds", "clubs" };
        int[] pointValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };
        Deck deck1 = new Deck(ranks, suits, pointValues);
        Deck deck2 = new Deck(ranks, suits, pointValues);

        deck1.shuffle();

        assertNotEquals(deck1, deck2, "The shuffled deck should not match the original deck");
    }

//    @Test
//    public void testPerfectShuffle() {
//        System.out.println("The perfect shuffle is being tested with a deck consisting of: ");
//        System.out.println("jack of spades, queen of spades, king of spades, ace of spades, jack of hearts, queen of hearts, king of hearts, ace of hearts");
//        System.out.println();
//        System.out.println("The result of a perfect shuffle should be:");
//        System.out.println("jack of spades, jack of hearts, queen of spades, queen of hearts, king of spades, king of hearts, ace of spades, ace of hearts");
//
//        String[] ranks = {"jack", "queen", "king", "ace" };
//        String[] suits = { "spades", "hearts" };
//        int[] pointValues = { 0, 0, 0, 0 };
//
//        // deck1 would be: JoS, QoS, KoS, AoS, JoH, QoH, KoH, AoH
//        Deck deck1 = new Deck(ranks, suits, pointValues);
//        deck1.perfectShuffle();
//
//        // perfect shuffle should give: JoS, JoH, QoS, QoH, KoS, KoH, AoS, AoH
//        Card c1 = new Card("jack", "spades", 0);
//        Card c2 = new Card("jack", "hearts", 0);
//        Card c3 = new Card("queen", "spades", 0);
//        Card c4 = new Card("ace", "hearts", 0);
//
//        assertEquals(c1, deck1.getCardAtIndex(0), "After the perfect shuffle, the first card should be: jack of spades");
//        assertEquals(c2, deck1.getCardAtIndex(1), "After the perfect shuffle, the second card should be: jack of hearts");
//        assertEquals(c3, deck1.getCardAtIndex(2), "After the perfect shuffle, the third card should be: queen of spades");
//        assertEquals(c4, deck1.getCardAtIndex(7), "After the perfect shuffle, the last card should be: ace of hearts");
//    }
}
