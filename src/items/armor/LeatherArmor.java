package items.armor;

public class LeatherArmor extends Armor {

    public LeatherArmor(String name, int level, String slotType) {
        super(name, level, slotType);
        armorType = "Leather";
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