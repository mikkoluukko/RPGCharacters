package heroes;

public class Ranger extends Hero {
    public Ranger() {
        setHerotype(HeroType.Ranger);
        setBaseHealth(120);
        setBaseStrength(5);
        setBaseDexterity(10);
        setBaseIntelligence(2);
    }

    public void levelUp() {
        super.levelUp();
        setBaseHealth(getBaseHealth() + 20);
        setBaseStrength(getBaseStrength() + 2);
        setBaseDexterity(getBaseDexterity() + 5);
        setBaseIntelligence(getBaseIntelligence() + 1);
    }
}
