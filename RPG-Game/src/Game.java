public class Game {
    private static final Character player = new Character( "Brenno", "Humano", 10, 0, 10);
    private static final Character orc = new Character( "Orc-san", "orc", 8, 0, 10);
    private static final Dice d20 = new Dice(20);

    public static void main(String[] args) {
        Equipment chainmail = new Equipment("chainmail", "def", 4);
        chainmail.equip(player);
        Equipment sword = new Equipment("sword", "atk", 2);
        sword.equip(player);

        Equipment axe = new Equipment("axe", "atk", 0);
        axe.equip(orc);

        player.attack(orc, d20, new Dice(8));
        orc.attack(player, d20, new Dice(12));
    }
}

// gimp