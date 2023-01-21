public class Game {
    private static final Character player = new Character( "Dainsleif", "Humano", 10, 0, 10);
    private static final Character orc = new Character( "Orc-san", "orc", 8, 0, 10);
    private static final Dice d8 = new Dice(8);
    private static final Dice d12 = new Dice(12);
    private static final Dice d20 = new Dice(20);

    public static void main(String[] args) throws InterruptedException {
        Equipment chainmail = new Equipment("Cota de Malha", "def", 4);
        chainmail.equip(player);
        Equipment sword = new Equipment("Espada", "pres", 2);
        sword.equip(player);

        Equipment axe = new Equipment("Machado", "pres", 0);
        axe.equip(orc);

        int i = 1;
        while ( !player.isDead() && !orc.isDead() ) {
            System.out.printf("\n - Rodada %d\n", i);

            if ( !player.isDead() )
                player.attack(orc, d20, d8);
            if ( !orc.isDead() )
                orc.attack(player, d20, d12);
            i++;
        }
    }
}
