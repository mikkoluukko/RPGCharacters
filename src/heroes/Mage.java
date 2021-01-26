package heroes;

public class Mage extends Hero {
    public Mage() {
        setHerotype(HeroType.Mage);
        setBaseHealth(100);
        setBaseStrength(2);
        setBaseDexterity(3);
        setBaseIntelligence(10);
    }

    public void levelUp() {
        super.levelUp();
        setBaseHealth(getBaseHealth() + 15);
        setBaseStrength(getBaseStrength() + 1);
        setBaseDexterity(getBaseDexterity() + 2);
        setBaseIntelligence(getBaseIntelligence() + 5);
    }
}
