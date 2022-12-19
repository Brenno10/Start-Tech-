public class Character {
    public String name;
    public String species;
    public int hp;
    public int atk;
    public int def;

    public Character(String name, String species, int hp, int atk, int def) {
        this.name = name;
        this.species = species;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void attack(Character character, Dice d20, Dice damageDice) {
        int result = d20.rollDice();
        int dmg = damageDice.rollDice() + this.atk;

        if ( result >= character.def ) {
            System.out.println("\nhit!");
            character.hp -= dmg;

            if ( character.hp <= 0 ) {
                character.hp = 0;
            }
        }
        else {
            System.out.println("\nmiss");
        }
    }
}
