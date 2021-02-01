package items.weapons;

public class MeleeWeapon implements Weapon {
    private String name;
    private int level;
    private String itemType;
    private String slotType;
    private String weaponType;
    private int baseDamage;

    public MeleeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
        itemType = "Weapon";
        slotType = "Weapon";
        weaponType = "Melee";
        baseDamage = 15 + level * 2;
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

    @Override
    public String getWeaponType() {
        return weaponType;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "Item stats for: " + name +
                "\nWeapon type: Melee" +
                "\nWeapon level: " + level +
                "\nDamage: " + baseDamage + "\n";
    }
}
