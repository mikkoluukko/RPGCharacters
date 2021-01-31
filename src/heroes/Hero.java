package heroes;

import items.Item;
import items.armor.Armor;
import items.weapons.Weapon;

// All the variables are common to all the inheriting character classes
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

//    xpLimitToNext means the total xp character needs to have in order to level up,
//    xpPerLevel means the xp amount that character needs to gain after previous level up limit to level up again
//    xpToNext means the amount of xp still required to reach next level up limit, i.e. xpLimitToNext - xpTotal
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

    public boolean checkItemLevel(Item item) {
        if (level >= item.getLevel()) {
            System.out.println(name + " equipped " + item.getName());
        } else {
            System.out.println(name + "'s level is not high enough to equip " + item.getName());
        }
        return level >= item.getLevel();
    }

    public boolean equipWeapon(Weapon weapon) {
        if (checkItemLevel(weapon)) {
            this.weapon = weapon;
            attack.updateDamage();
            return true;
        } else {
            return false;
        }
    }

    public boolean removeWeapon(Weapon weapon) {
        if (this.weapon == weapon) {
            this.weapon = null;
            attack.updateDamage();
            System.out.println(name + " removed " + weapon.getName());
            return true;
        } else {
            return false;
        }
    }

    public boolean removeArmor(Armor armor) {
        boolean removingSuccessfull = false;
        equipmentHealth -= armor.getHealthBonus();
        equipmentStrength -= armor.getStrengthBonus();
        equipmentDexterity -= armor.getDexterityBonus();
        equipmentIntelligence -= armor.getIntelligenceBonus();
        currentHealth -= armor.getHealthBonus();
        attack.updateDamage();
        switch (armor.getSlotType()) {
            case Head -> {
                if (headArmor == armor) {
                    removingSuccessfull = true;
                    headArmor = null;
                }
            }
            case Body -> {
                if (bodyArmor == armor) {
                    removingSuccessfull = true;
                    bodyArmor = null;
                }
            }
            case Legs -> {
                if ( bodyArmor == armor) {
                    removingSuccessfull = true;
                    legsArmor = null;
                }
            }
        }
        if (removingSuccessfull) {
            System.out.println(name + " removed " + armor.getName());
        }
        return removingSuccessfull;
    }

    public boolean equipArmor(Armor armor) {
        if (checkItemLevel(armor)) {
            switch (armor.getSlotType()) {
                case Head -> {
                    if (headArmor != null) {
                        removeArmor(headArmor);
                    }
                    headArmor = armor;
                    updateEquipmentBonus(armor);
                }
                case Body -> {
                    if (bodyArmor != null) {
                        removeArmor(bodyArmor);
                    }
                    bodyArmor = armor;
                    updateEquipmentBonus(armor);
                }
                case Legs -> {
                    if (legsArmor != null) {
                        removeArmor(legsArmor);
                    }
                    legsArmor = armor;
                    updateEquipmentBonus(armor);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    protected void updateEquipmentBonus(Armor armor) {
        equipmentHealth += armor.getHealthBonus();
        equipmentStrength += armor.getStrengthBonus();
        equipmentDexterity += armor.getDexterityBonus();
        equipmentIntelligence += armor.getIntelligenceBonus();
        currentHealth += armor.getHealthBonus();
        attack.updateDamage();
    }

    public void performAttack(Hero opponent) {
        int damage = attack.attackDamage();
        System.out.println(name  + " attacks " + opponent.name + " for " + damage);
        opponent.receiveAttack(damage);
    }

    public void receiveAttack(int damage) {
        if (currentHealth - damage > 0) {
            currentHealth -= damage;
        } else {
            currentHealth = 0;
        }
        System.out.println(name + " lost " + damage + " HP. Current HP: " +
                currentHealth + "/" + (baseHealth + equipmentHealth));
    }

    // Added the displaying of currentHealth
    @Override
    public String toString() {
        return "\n" + name + " (" + heroType + ") " + "details:" +
                "\nAvg damage: " + attack.attackDamage() +
                "\nHP: " + currentHealth + "/" + (baseHealth + equipmentHealth) +
                "\nStr: " + (baseStrength + equipmentStrength) +
                "\nDex: " + (baseDexterity + equipmentDexterity) +
                "\nInt: " + (baseIntelligence + equipmentIntelligence) +
                "\nLvl: " + level +
                "\nXP to next: " + xpToNext;
    }

    public String showEquipment() {
        return "\n" + name + " (" + heroType + ") " + "has the following items equipped:" +
                "\nWeapon: " + (weapon != null ? weapon.getName() : " empty") +
                "\nHead: " + (headArmor != null ? headArmor.getName() : " empty") +
                "\nBody: " + (bodyArmor != null ? bodyArmor.getName() : " empty") +
                "\nLegs: " + (legsArmor != null ? legsArmor.getName() : " empty");
    }
}
