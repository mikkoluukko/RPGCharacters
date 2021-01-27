package items.armor;

import items.SlotType;

public class Leather extends Armor {

    public Leather(String name, int level, SlotType slotType) {
        super(name, level, slotType);
        armorType = ArmorType.Leather;
        healthBonus = (int) Math.floor(getSlotMultiplier() * (20 + level * 8));
        strengthBonus = (int) Math.floor(getSlotMultiplier() * (1 + level));
        dexterityBonus = (int) Math.floor(getSlotMultiplier() * (3 + level * 2));
        intelligenceBonus = 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBonus HP: " + healthBonus +
                "\nBonus Str: " + strengthBonus +
                "\nBonus Dex: " + dexterityBonus + "\n";
    }
}