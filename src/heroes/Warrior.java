package heroes;

public class Warrior extends Hero {
    public Warrior() {
        setHerotype(HeroType.Warrior);
        setBaseHealth(150);
        setBaseStrength(10);
        setBaseDexterity(3);
        setBaseIntelligence(1);
    }

    public void levelUp() {
        super.levelUp();
        setBaseHealth(getBaseHealth() + 30);
        setBaseStrength(getBaseStrength() + 5);
        setBaseDexterity(getBaseDexterity() + 2);
        setBaseIntelligence(getBaseIntelligence() + 1);
    }
}
