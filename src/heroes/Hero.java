package heroes;

import items.armor.Armor;
import items.weapons.Weapon;

public abstract class Hero {
    protected HeroType heroType;
    protected int baseHealth;
    protected int baseStrength;
    protected int baseDexterity;
    protected int baseIntelligence;
    protected int equipmentHealth;
    protected int equipmentStrength;
    protected int equipmentDexterity;
    protected int equipmentIntelligence;
    protected int xpTotal;
    protected int xpLimitToNext;
    protected int xpToNext;
    protected int xpPerLevel;
    protected int level;
    protected Weapon weapon;
    protected Armor headArmor;
    protected Armor bodyArmor;
    protected Armor legsArmor;

    public Hero() {
        equipmentHealth = 0;
        equipmentStrength = 0;
        equipmentDexterity = 0;
        equipmentIntelligence = 0;
        xpTotal = 0;
        level = 1;
        xpToNext = 100;
        xpLimitToNext = 100;
        xpPerLevel = 100;
    }

    protected void levelUp() {
        level++;
        xpPerLevel = (int) Math.floor(xpPerLevel * 1.1);
        xpLimitToNext = xpLimitToNext + xpPerLevel;
        checkLevel();
    }

    public void addXp(int xp) {
        xpTotal += xp;
        checkLevel();
        xpToNext = xpLimitToNext - xpTotal;
    }

    protected void checkLevel() {
        if (xpTotal >= xpLimitToNext) {
            levelUp();
        }
    }

    public void equipWeapon(Weapon weapon) {
        if (level >= weapon.getLevel()) {
            this.weapon = weapon;
        }
    }

    public void removeArmor(Armor armor) {
        equipmentHealth -= armor.getHealthBonus();
        equipmentStrength -= armor.getHealthBonus();
        equipmentDexterity -= armor.getHealthBonus();
        equipmentIntelligence -= armor.getHealthBonus();
    }

    public void equipArmor(Armor armor) {
        switch (armor.getSlotType()) {
            case Head:
                if (headArmor != null) {
                    removeArmor(headArmor);
                }
                headArmor = armor;
                updateEquipmentBonus(armor);
                break;
            case Body:
                if (bodyArmor != null) {
                    removeArmor(bodyArmor);
                }
                bodyArmor = armor;
                updateEquipmentBonus(armor);
                break;
            case Legs:
                if (legsArmor != null) {
                    removeArmor(legsArmor);
                }
                legsArmor = armor;
                updateEquipmentBonus(armor);
                break;
        }
    }

    protected void updateEquipmentBonus(Armor armor) {
        equipmentHealth += armor.getHealthBonus();
        equipmentStrength += armor.getStrengthBonus();
        equipmentDexterity += armor.getDexterityBonus();
        equipmentIntelligence += armor.getIntelligenceBonus();
    }

    public void attack() {
        int totalDamage = 0;
        if (weapon != null) {
            switch (weapon.getWeaponType()) {
                case Melee:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 1.5 * (baseStrength + equipmentStrength));
                    break;
                case Ranged:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 2 * (baseDexterity + equipmentDexterity));
                    break;
                case Magic:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 3 * (baseIntelligence + equipmentIntelligence));
                    break;
            }
        }
        System.out.println("Attacking for " + totalDamage + "\n");
    }

    @Override
    public String toString() {
        return heroType + " details:" +
                "\nHP: " + (baseHealth + equipmentHealth) +
                "\nStr: " + (baseStrength + equipmentStrength) +
                "\nDex: " + (baseDexterity + equipmentDexterity) +
                "\nInt: " + (baseIntelligence + equipmentIntelligence) +
                "\nLvl: " + level +
                //"\nTot. XP: " + xpTotal +
                //"\nXP total to next: " + xpTotalToNext +
                "\nXP to next: " + xpToNext + "\n";

    }
}
