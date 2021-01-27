package items.weapons;

import items.Item;
import items.ItemType;
import items.SlotType;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int baseDamage;

    public Weapon(String name, int level, WeaponType weaponType) {
        super(ItemType.Weapon, SlotType.Weapon, name, level);
        this.weaponType = weaponType;
        switch (weaponType) {
            case Melee:
                baseDamage = 15 + level * 2;
                break;
            case Ranged:
                baseDamage = 5 + level * 3;
                break;
            case Magic:
                baseDamage = 25 + level * 2;
                break;
        }
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeapon type: " + weaponType +
                "\nWeapon level: " + level +
                "\nDamage: " + baseDamage + "\n";
    }
}