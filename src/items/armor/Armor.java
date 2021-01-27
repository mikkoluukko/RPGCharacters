package items.armor;

import items.Item;
import items.ItemType;
import items.SlotType;

public abstract class Armor extends Item {
    protected ArmorType armorType;
    protected double slotMultiplier;
    protected int healthBonus;
    protected int strengthBonus;
    protected int dexterityBonus;
    protected int intelligenceBonus;

    public Armor(String name, int level, SlotType slotType) {
        super(ItemType.Armor, slotType, name, level);
        switch (slotType) {
            case Body:
                slotMultiplier = 1;
                break;
            case Head:
                slotMultiplier = 0.8;
                break;
            case Legs:
                slotMultiplier = 0.6;
                break;
        }
    }

    public ArmorType getArmorType() {
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
        return super.toString() +
                "\nArmor type: " + armorType +
                "\nSlot: " + slotType +
                "\nArmor level: " + level;
    }
}
