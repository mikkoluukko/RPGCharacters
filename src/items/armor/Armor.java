package items.armor;

import items.Item;

// Armor is  implemented as an abstract class instead of an interface because besides constructor there is
// is only one method ( toString() ) that has unique implementation for different character classes.
// Usage of the variables is also similar in all the subclasses.
public abstract class Armor implements Item {
    private String name;
    private int level;
    private String itemType;
    private String slotType;
    protected String armorType;
    protected double slotMultiplier;
    protected int healthBonus;
    protected int strengthBonus;
    protected int dexterityBonus;
    protected int intelligenceBonus;

    public Armor(String name, int level, String slotType) {
        this.name = name;
        this.level = level;
        this.slotType = slotType;
        this.itemType = "Armor";
        switch (slotType) {
            case "Body" -> slotMultiplier = 1;
            case "Head" -> slotMultiplier = 0.8;
            case "Legs" -> slotMultiplier = 0.6;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getItemType() {
        return itemType;
    }

    @Override
    public String getSlotType() {
        return slotType;
    }

    public String getArmorType() {
        return armorType;
    }

    public double getSlotMultiplier() {
        return slotMultiplier;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public int getDexterityBonus() {
        return dexterityBonus;
    }

    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    @Override
    public String toString() {
        return "Item stats for: " + name +
                "\nArmor type: " + armorType +
                "\nSlot: " + slotType +
                "\nArmor level: " + level;
    }
}
