package items.armor;

import items.Item;
import items.ItemType;
import items.SlotType;

public abstract class Armor extends Item {
    private ArmorType armorType;
    private double slotMultiplier;
    private int healthBonus;
    private int strengthBonus;
    private int dexterityBonus;
    private int intelligenceBonus;

    public Armor(String name, int level, SlotType slotType) {
        super(ItemType.Armor, name, level, slotType);
        switch (slotType) {
            case Body:
                setSlotMultiplier(1);
                break;
            case Head:
                setSlotMultiplier(0.8);
                break;
            case Legs:
                setSlotMultiplier(0.6);
                break;
        }
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public double getSlotMultiplier() {
        return slotMultiplier;
    }

    public void setSlotMultiplier(double slotMultiplier) {
        this.slotMultiplier = slotMultiplier;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getDexterityBonus() {
        return dexterityBonus;
    }

    public void setDexterityBonus(int dexterityBonus) {
        this.dexterityBonus = dexterityBonus;
    }

    public int getIntelligenceBonus() {
        return intelligenceBonus;
    }

    public void setIntelligenceBonus(int intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nArmor type: " + getArmorType() +
                "\nSlot: " + getSlotType() +
                "\nArmor level: " + getLevel();
    }
}
