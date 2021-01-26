package items.armor;

import items.SlotType;

public class Leather extends Armor {

    public Leather(String name, int level, SlotType slotType) {
        super(name, level, slotType);
        setArmorType(ArmorType.Leather);
        setHealthBonus((int) Math.floor(getSlotMultiplier() * (20 + level * 8)));
        setStrengthBonus((int) Math.floor(getSlotMultiplier() * (1 + level)));
        setDexterityBonus((int) Math.floor(getSlotMultiplier() * (3 + level * 2)));
        setIntelligenceBonus(0);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBonus HP: " + getHealthBonus() +
                "\nBonus Str: " + getStrengthBonus() +
                "\nBonus Dex: " + getDexterityBonus() + "\n";
    }
}