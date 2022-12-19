public class Equipment {
    public String name;
    public String type;
    public int value;

    public Equipment(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public void equip(Character character) {
        switch (this.type.toLowerCase()) {
            case "atk" -> character.atk += this.value;
            case "def" -> character.def += this.value;
        }
    }
}
