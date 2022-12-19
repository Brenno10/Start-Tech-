package deck;

public class Card {
    public static final String[] validSuit = {
            "♠", "♣", "♥", "♦"
    };
    public static final String[] validTypes = {
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };
    public String suit;
    public String type;

    public Card(String suit, String type) {
        this.suit = suit;
        this.type = type;
    }
}
