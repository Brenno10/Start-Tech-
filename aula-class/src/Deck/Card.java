package Deck;

public class Card {
    public static final String[] validNaipes = {
            "♠", "♣", "♥", "♦"
    };
    private static final String[] validTypes = {
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", ""
    };
    public String naipe;
    public String type;

    public Card(String naipe, String type) {
        this.naipe = naipe;
        this.type = type;
    }

    private boolean isValidCard(String str) {
        for (String n : validNaipes) {
            if (str.equalsIgnoreCase(n))
                return true;
        }
        for ( int i = 0; i < validTypes.length; i++ ) {
            if ( str.equalsIgnoreCase(validNaipes[i]) )
                return true;
        }
        return false;
    }
}
