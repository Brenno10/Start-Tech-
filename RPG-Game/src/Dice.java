import java.util.Random;

public class Dice {
    private static final Random rand = new Random();
    public int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int rollDice() {
        return rand.nextInt(1, sides);
    }
}
