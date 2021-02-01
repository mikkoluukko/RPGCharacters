package heroes;

import items.Item;
import items.armor.Armor;
import items.weapons.Weapon;

// Hero is implemented as an abstract class instead of an interface because besides constructor there is
// is only one method ( levelUp() ) that has unique implementation for different character classes.
// Usage of the variables is also similar in all the subclasses.
public abstract class Hero {
    protected String name;
    protected String heroType;
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
//    These are spread to their own variables to increase readability of all the xp-related methods.
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

    public void levelUp() {
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
        System.out.println(name + " gained " + xp + " XP. Level is now: " + level + ", XP to next level: " + xpToNext);
    }

    protected void checkLevel() {
        if (xpTotal >= xpLimitToNext) {
            levelUp();
        }
    }

    public boolean isEquipable(Item item) {
        if (level >= item.getLevel()) {
            System.out.println(name + " equipped " + item.getName());
        } else {
            System.out.println(name + "'s level is not high enough to equip " + item.getName());
        }
        return level >= item.getLevel();
    }

    public boolean equipItem(Item item) {
        boolean isEquipped = false;
        if (isEquipable(item)) {
            switch (item.getItemType()) {
                case "Weapon" -> isEquipped = equipWeapon((Weapon) item);
                case "Armor" -> isEquipped = equipArmor((Armor) item);
            }
        }
        return isEquipped;
    }

    public boolean removeItem(Item item) {
        boolean isRemoved = false;
        switch (item.getItemType()) {
            case "Weapon" -> isRemoved = removeWeapon((Weapon) item);
            case "Armor" -> isRemoved = removeArmor((Armor) item);
        }
        return isRemoved;
    }

    public boolean equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        attack.updateDamage();
        return true;
    }

    public boolean removeWeapon(Weapon weapon) {
        if (this.weapon == weapon) {
            this.weapon = null;
            attack.updateDamage();
            System.out.println(name + " removed " + weapon.getName());
            return true;
        } else {
            System.out.println(name + " doesn't have " + weapon.getName() + " equipped");
            return false;
        }
    }

//    First remove the possibly currently equipped armor in the selected slot
//    to avoid errors in equipment stat bonuses.
    public boolean equipArmor(Armor armor) {
        switch (armor.getSlotType()) {
            case "Head" -> {
                if (headArmor != null) {
                    removeArmor(headArmor);
                }
                headArmor = armor;
                addEquipmentBonus(armor);
            }
            case "Body" -> {
                if (bodyArmor != null) {
                    removeArmor(bodyArmor);
                }
                bodyArmor = armor;
                addEquipmentBonus(armor);
            }
            case "Legs" -> {
                if (legsArmor != null) {
                    removeArmor(legsArmor);
                }
                legsArmor = armor;
                addEquipmentBonus(armor);
            }
        }
        return true;
    }

    public boolean removeArmor(Armor armor) {
        boolean isRemoved = false;
        switch (armor.getSlotType()) {
            case "Head" -> {
                if (headArmor == armor) {
                    isRemoved = true;
                    headArmor = null;
                }
            }
            case "Body" -> {
                if (bodyArmor == armor) {
                    isRemoved = true;
                    bodyArmor = null;
                }
            }
            case "Legs" -> {
                if (bodyArmor == armor) {
                    isRemoved = true;
                    legsArmor = null;
                }
            }
        }
        if (isRemoved) {
            removeEquipmentBonus(armor);
            System.out.println(name + " removed " + armor.getName());
        } else {
            System.out.println(name + " doesn't have " + armor.getName() + " equipped");
        }
        return isRemoved;
    }

    public void addEquipmentBonus(Armor armor) {
        equipmentHealth += armor.getHealthBonus();
        equipmentStrength += armor.getStrengthBonus();
        equipmentDexterity += armor.getDexterityBonus();
        equipmentIntelligence += armor.getIntelligenceBonus();
        currentHealth += armor.getHealthBonus();
        attack.updateDamage();
    }

    public void removeEquipmentBonus(Armor armor) {
        equipmentHealth -= armor.getHealthBonus();
        equipmentStrength -= armor.getStrengthBonus();
        equipmentDexterity -= armor.getDexterityBonus();
        equipmentIntelligence -= armor.getIntelligenceBonus();
        currentHealth -= armor.getHealthBonus();
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

    public String getEquipmentInfo() {
        return "\n" + name + " (" + heroType + ") " + "has the following items equipped:" +
                "\nWeapon: " + (weapon != null ? weapon.getName() : " empty") +
                "\nHead: " + (headArmor != null ? headArmor.getName() : " empty") +
                "\nBody: " + (bodyArmor != null ? bodyArmor.getName() : " empty") +
                "\nLegs: " + (legsArmor != null ? legsArmor.getName() : " empty");
    }
}
