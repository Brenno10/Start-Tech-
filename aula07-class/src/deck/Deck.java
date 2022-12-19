package deck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final Random rand = new Random();
    private static final List<String> suits = Arrays.asList(Card.validSuit);
    private static final List<String> types = Arrays.asList(Card.validTypes);
    private static final List<Card> cardDeck = new ArrayList<>();

    public Deck() {
        for (String suit : suits) {
            for (String type : types) {
                cardDeck.add( new Card(suit, type) );
            }
        }
    }

    public static List<Card> drawHand( int handSize ) {
        List<Card> hand = new ArrayList<>();
        hand.add(drawCard(0, cardDeck.size()));

        for ( int i = 0; i < handSize; i++ ) {
            Card card = drawCard(0, cardDeck.size());

            if ( hand.get(i) != card ) {
                hand.add(card);
            }
            else {
                i--;
            }
        }

        return hand;
    }

    public static Card drawCard( int base, int handSize ) {
        return cardDeck.get( rand.nextInt(base, handSize) );
    }
}
