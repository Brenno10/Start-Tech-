public class Character {
    public String name;
    public String species;
    public int hp;
    public int atk;
    public int def;
    public Equipment weapon;

    public Character(String name, String species, int hp, int atk, int def) {
        this.name = name;
        this.species = species;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void attack(Character character, Dice d20, Dice damageDice) throws InterruptedException {
        int diceRoll = d20.rollDice();
        int result = diceRoll + this.atk;
        int dmg = damageDice.rollDice();

        Thread.sleep(1000);
        System.out.printf( "\n%s ataca com %s!", this.name, weapon.name );
        Thread.sleep(1000);

        if ( result >= character.def ) {
            System.out.printf(  "\nO ataque foi %d e acertou! (%d + %d)", result, diceRoll, this.atk );
            character.hp -= dmg;

            System.out.printf("\n%s recebe %d pontos de dano.", character.name, dmg );
            Thread.sleep(1000);

            if ( character.hp <= 0 ) {
                character.hp = 0;
                System.out.printf("\n\n%s morreu!", character.name);
            }
        }
        else {
            System.out.printf("\nO ataque foi %d e errou! (%d + %d)", result, diceRoll, this.atk);
            Thread.sleep(1000);
        }
        System.out.println("");
    }

    public boolean isDead()  {
        return this.hp <= 0;
    }
}
