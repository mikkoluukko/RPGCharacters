package items.armor;

import items.SlotType;

public class Cloth extends Armor {

    public Cloth(String name, int level, SlotType slotType) {
        super(name, level, slotType);
        setArmorType(ArmorType.Cloth);
        setHealthBonus((int) Math.floor(getSlotMultiplier() * (10 + level * 5)));
        setStrengthBonus(0);
        setDexterityBonus((int) Math.floor(getSlotMultiplier() * (1 + level)));
        setIntelligenceBonus((int) Math.floor(getSlotMultiplier() * (3 + level * 2)));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBonus HP: " + getHealthBonus() +
                "\nBonus Dex: " + getDexterityBonus() +
                "\nBonus Int: " + getIntelligenceBonus() + "\n";
    }
}
