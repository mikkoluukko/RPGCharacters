package heroes;

public class Warrior extends Hero {
    public Warrior() {
        heroType = HeroType.Warrior;
        baseHealth = 150;
        baseStrength = 10;
        baseDexterity = 3;
        baseIntelligence = 1;
    }

    protected void levelUp() {
        super.levelUp();
        baseHealth += 30;
        baseStrength += 5;
        baseDexterity += 2;
        baseIntelligence += 1;
    }
}
