package heroes;

public class Mage extends Hero {
    public Mage(String name) {
        super(name);
        heroType = HeroType.Mage;
        baseHealth = 100;
        baseStrength = 2;
        baseDexterity = 3;
        baseIntelligence = 10;
        currentHealth = baseHealth;
    }

    protected void levelUp() {
        super.levelUp();
        baseHealth += 15;
        currentHealth += 15;
        baseStrength += 1;
        baseDexterity += 2;
        baseIntelligence += 5;
    }
}
