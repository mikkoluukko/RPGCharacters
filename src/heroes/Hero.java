package heroes;

import items.armor.Armor;
import items.weapons.Weapon;

public abstract class Hero {
    private HeroType herotype;
    private int baseHealth;
    private int baseStrength;
    private int baseDexterity;
    private int baseIntelligence;
    private int equipmentHealth;
    private int equipmentStrength;
    private int equipmentDexterity;
    private int equipmentIntelligence;
    private int xpTotal;
    private int xpTotalToNext;
    private int xpToNext;
    private int xpPerLevel;
    private int level;
    private Weapon weapon;
    private Armor head;
    private Armor body;
    private Armor legs;

    public Hero() {
        setEquipmentHealth(0);
        setEquipmentStrength(0);
        setEquipmentDexterity(0);
        setEquipmentIntelligence(0);
        setXpTotal(0);
        setLevel(1);
        setXpTotalToNext(100);
        setXpToNext(100);
        setXpPerLevel(100);
    }

    public void levelUp() {
        level++;
        setXpPerLevel((int) Math.floor(getXpPerLevel() * 1.1));
        setXpTotalToNext(getXpTotalToNext() + getXpPerLevel());
        checkLevel();
    }

    public HeroType getHerotype() {
        return herotype;
    }

    public void setHerotype(HeroType herotype) {
        this.herotype = herotype;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int health) {
        this.baseHealth = health;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseDexterity() {
        return baseDexterity;
    }

    public void setBaseDexterity(int baseDexterity) {
        this.baseDexterity = baseDexterity;
    }

    public int getBaseIntelligence() {
        return baseIntelligence;
    }

    public void setBaseIntelligence(int baseIntelligence) {
        this.baseIntelligence = baseIntelligence;
    }

    public int getEquipmentHealth() {
        return equipmentHealth;
    }

    public void setEquipmentHealth(int equipmentHealth) {
        this.equipmentHealth = equipmentHealth;
    }

    public int getEquipmentStrength() {
        return equipmentStrength;
    }

    public void setEquipmentStrength(int equipmentStrength) {
        this.equipmentStrength = equipmentStrength;
    }

    public int getEquipmentDexterity() {
        return equipmentDexterity;
    }

    public void setEquipmentDexterity(int equipmentDexterity) {
        this.equipmentDexterity = equipmentDexterity;
    }

    public int getEquipmentIntelligence() {
        return equipmentIntelligence;
    }

    public void setEquipmentIntelligence(int equipmentIntelligence) {
        this.equipmentIntelligence = equipmentIntelligence;
    }

    public int getXpTotal() {
        return xpTotal;
    }

    public void setXpTotal(int xpTotal) {
        this.xpTotal = xpTotal;
    }

    public void addXp(int xp) {
        setXpTotal(getXpTotal() + xp);
        checkLevel();
        setXpToNext(getXpTotalToNext() - getXpTotal());
    }

    public int getXpTotalToNext() {
        return xpTotalToNext;
    }

    public void setXpTotalToNext(int xpTotalToNext) {
        this.xpTotalToNext = xpTotalToNext;
    }

    public int getXpToNext() {
        return xpToNext;
    }

    public void setXpToNext(int xpToNext) {
        this.xpToNext = xpToNext;
    }

    public int getXpPerLevel() {
        return xpPerLevel;
    }

    public void setXpPerLevel(int xpPerLevel) {
        this.xpPerLevel = xpPerLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void checkLevel() {
        if (xpTotal >= xpTotalToNext) {
            levelUp();
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (getLevel() >= weapon.getLevel()) {
            this.weapon = weapon;
        }
    }

    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
        if (getHead() != null) {
            removeArmor(getHead());
        }
        this.head = head;
        equipArmor(head);
    }

    public Armor getBody() {
        return body;
    }

    public void setBody(Armor body) {
        if (getBody() != null) {
            removeArmor(getBody());
        }
        this.body = body;
        equipArmor(body);
    }

    public Armor getLegs() {
        return legs;
    }

    public void setLegs(Armor legs) {
        if (getLegs() != null) {
            removeArmor(getLegs());
        }
        this.legs = legs;
        equipArmor(legs);
    }

    public void removeArmor(Armor armor) {
        setEquipmentHealth(getEquipmentHealth() - armor.getHealthBonus());
        setEquipmentStrength(getEquipmentStrength() - armor.getStrengthBonus());
        setEquipmentDexterity(getEquipmentDexterity() - armor.getDexterityBonus());
        setEquipmentIntelligence(getEquipmentIntelligence() - armor.getIntelligenceBonus());
    }

    public void equipArmor(Armor armor) {
        setEquipmentHealth(getEquipmentHealth() + armor.getHealthBonus());
        setEquipmentStrength(getEquipmentStrength() + armor.getStrengthBonus());
        setEquipmentDexterity(getEquipmentDexterity() + armor.getDexterityBonus());
        setEquipmentIntelligence(getEquipmentIntelligence() + armor.getIntelligenceBonus());
    }

    public void attack() {
        int totalDamage = 0;
        if (getWeapon() != null) {
            switch (getWeapon().getWeaponType()) {
                case Melee:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 1.5 * (getBaseStrength() + getEquipmentStrength()));
                    break;
                case Ranged:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 2 * (getBaseDexterity() + getEquipmentDexterity()));
                    break;
                case Magic:
                    totalDamage = (int) Math.floor(weapon.getBaseDamage() + 3 * (getBaseIntelligence() + getEquipmentIntelligence()));
                    break;
            }
        }
        System.out.println("Attacking for " + totalDamage + "\n");
    }

    @Override
    public String toString() {
        return getHerotype() + " details:" +
                "\nHP: " + (getBaseHealth() + getEquipmentHealth()) +
                "\nStr: " + (getBaseStrength() + getEquipmentStrength()) +
                "\nDex: " + (getBaseDexterity() + getEquipmentDexterity()) +
                "\nInt: " + (getBaseIntelligence() + getEquipmentIntelligence()) +
                "\nLvl: " + getLevel() +
                //"\nTot. XP: " + xpTotal +
                //"\nXP total to next: " + xpTotalToNext +
                "\nXP to next: " + getXpToNext() + "\n";

    }
}
