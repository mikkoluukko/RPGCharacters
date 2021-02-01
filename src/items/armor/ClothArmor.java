package items.armor;

public class ClothArmor extends Armor {

    public ClothArmor(String name, int level, String slotType) {
        super(name, level, slotType);
        armorType = "Cloth";
        healthBonus = (int) Math.floor(getSlotMultiplier() * (10 + level * 5));
        strengthBonus = 0;
        dexterityBonus = (int) Math.floor(getSlotMultiplier() * (1 + level));
        intelligenceBonus = (int) Math.floor(getSlotMultiplier() * (3 + level * 2));
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nBonus HP: " + healthBonus +
                "\nBonus Dex: " + dexterityBonus +
                "\nBonus Int: " + intelligenceBonus + "\n";
    }
}
