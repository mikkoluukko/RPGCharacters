package heroes;

public class Ranger extends Hero {
    public Ranger(String name) {
        super(name);
        heroType = "Ranger";
        baseHealth = 120;
        baseStrength = 5;
        baseDexterity = 10;
        baseIntelligence = 2;
        currentHealth = baseHealth;
    }

    public void levelUp() {
        super.levelUp();
        baseHealth += 20;
        currentHealth += 20;
        baseStrength += 2;
        baseDexterity += 5;
        baseIntelligence += 1;
    }
}
