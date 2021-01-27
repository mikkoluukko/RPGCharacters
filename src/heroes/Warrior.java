package heroes;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name);
        heroType = HeroType.Warrior;
        baseHealth = 150;
        baseStrength = 10;
        baseDexterity = 3;
        baseIntelligence = 1;
        currentHealth = baseHealth;
    }

    protected void levelUp() {
        super.levelUp();
        baseHealth += 30;
        currentHealth += 30;
        baseStrength += 5;
        baseDexterity += 2;
        baseIntelligence += 1;
    }
}
