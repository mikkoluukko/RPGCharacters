package heroes;

public class Ranger extends Hero {
    public Ranger() {
        heroType = HeroType.Ranger;
        baseHealth = 120;
        baseStrength = 5;
        baseDexterity = 10;
        baseIntelligence = 2;
    }

    protected void levelUp() {
        super.levelUp();
        baseHealth += 20;
        baseStrength += 2;
        baseDexterity += 5;
        baseIntelligence += 1;
    }
}
