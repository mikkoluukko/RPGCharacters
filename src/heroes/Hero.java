package heroes;

import items.armor.Armor;
import items.weapons.Weapon;

public abstract class Hero {
    protected String name;
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
    protected int currentHealth;
    protected Weapon weapon;
    protected Armor headArmor;
    protected Armor bodyArmor;
    protected Armor legsArmor;
    protected Attack attack;

    public Hero(String name) {
        this.name = name;
        equipmentHealth = 0;
        equipmentStrength = 0;
        equipmentDexterity = 0;
        equipmentIntelligence = 0;
        xpTotal = 0;
        level = 1;
        xpToNext = 100;
        xpLimitToNext = 100;
        xpPerLevel = 100;
        attack = new Attack(this);
    }

    protected void levelUp() {
        level++;
        xpPerLevel = (int) Math.floor(xpPerLevel * 1.1);
        xpLimitToNext = xpLimitToNext + xpPerLevel;
        attack.updateDamage();
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
            attack.updateDamage();
            System.out.println(name + " equipped " + weapon.getName() + "\n");
        }
    }

    public void removeWeapon(Weapon weapon) {
        this.weapon = null;
        attack.updateDamage();
    }

    public void removeArmor(Armor armor) {
        equipmentHealth -= armor.getHealthBonus();
        equipmentStrength -= armor.getStrengthBonus();
        equipmentDexterity -= armor.getDexterityBonus();
        equipmentIntelligence -= armor.getIntelligenceBonus();
        currentHealth -= armor.getHealthBonus();
        attack.updateDamage();
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
        currentHealth += armor.getHealthBonus();
        attack.updateDamage();
        System.out.println("Equipped " + armor.getName() + "\n");
    }

    public void performAttack(Hero opponent) {
        int damage = attack.attackDamage();
        opponent.receiveAttack(damage);
        System.out.println("Attacking for " + damage + "\n");
    }

    public void receiveAttack(int damage) {
        if (currentHealth - damage > 0) {
            currentHealth -= damage;
        } else {
            currentHealth = 0;
        }
    }

    // Added the displaying of currentHealth
    @Override
    public String toString() {
        return name + " (" + heroType + ") " + "details:" +
                "\nAvg damage: " + attack.attackDamage() +
                "\nHP: " + currentHealth + "/" + (baseHealth + equipmentHealth) +
                "\nStr: " + (baseStrength + equipmentStrength) +
                "\nDex: " + (baseDexterity + equipmentDexterity) +
                "\nInt: " + (baseIntelligence + equipmentIntelligence) +
                "\nLvl: " + level +
                //"\nTot. XP: " + xpTotal +
                //"\nXP total to next: " + xpTotalToNext +
                "\nXP to next: " + xpToNext + "\n";

    }
}
