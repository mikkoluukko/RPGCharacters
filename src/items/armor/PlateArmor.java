package items.armor;

public class PlateArmor extends Armor {

    public PlateArmor(String name, int level, String slotType) {
        super(name, level, slotType);
        armorType = "Plate";
        healthBonus = (int) Math.floor(getSlotMultiplier() * (30 + level * 12));
        strengthBonus = (int) Math.floor(getSlotMultiplier() * (3 + level * 2));
        dexterityBonus = (int) Math.floor(getSlotMultiplier() * (1 + level));
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