package items.armor;

import items.SlotType;

public class Plate extends Armor {

    public Plate(String name, int level, SlotType slotType) {
        super(name, level, slotType);
        setArmorType(ArmorType.Plate);
        setHealthBonus((int) Math.floor(getSlotMultiplier() * (30 + level * 12)));
        setStrengthBonus((int) Math.floor(getSlotMultiplier() * (3 + level * 2)));
        setDexterityBonus((int) Math.floor(getSlotMultiplier() * (1 + level)));
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