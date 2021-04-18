public abstract class Unit {
    private String name; //unit's name
    private int health; //unit's health
    private int strength; //unit's strength
    private int dexterity; //unit's dexterity
    private int xp; //unit's experience
    private int gold; //unit's gold

    public Unit(String name, int health, int strength, int dexterity, int xp, int gold) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > 100) this.health = 100;
        else if (health < 0) this.health = 0;
        else this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) this.strength = 0;
        else this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        if (dexterity < 0) this.dexterity = 0;
        this.dexterity = dexterity;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if (xp < 0) this.xp = 0;
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if (gold < 0) this.gold = 0;
        this.gold = gold;
    }

    public int attack() {
        if (dexterity * 3 > (int) (Math.random() * 100)) return strength;
        else return 0;
    }
    public String toString() {
        return (name+" with "+health+" health points");
    }

}
