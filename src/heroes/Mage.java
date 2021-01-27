package heroes;

public class Mage extends Hero {
    public Mage() {
        heroType = HeroType.Mage;
        baseHealth = 100;
        baseStrength = 2;
        baseDexterity = 3;
        baseIntelligence = 10;
    }

    protected void levelUp() {
        super.levelUp();
        baseHealth += 15;
        baseStrength += 1;
        baseDexterity += 2;
        baseIntelligence += 5;
    }
}
