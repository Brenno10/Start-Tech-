package deck;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();

        for ( int i = 0; i < 7; i++ ) {
            System.out.println(
                    Deck.drawHand(7).get(0).type + " de " + Deck.drawHand(7).get(0).suit
            );
        }
    }
}
