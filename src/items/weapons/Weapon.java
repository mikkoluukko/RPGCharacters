package items.weapons;

import items.Item;
import items.ItemType;
import items.SlotType;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int baseDamage;

    public Weapon(String name, int level, WeaponType weaponType) {
        super(ItemType.Weapon, name, level, SlotType.Weapon);
        setWeaponType(weaponType);
        switch (weaponType) {
            case Melee:
                setBaseDamage(15 + level * 2);
                break;
            case Ranged:
                setBaseDamage(5 + level * 3);
                break;
            case Magic:
                setBaseDamage(25 + level * 2);
                break;
        }
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nWeapon type: " + weaponType +
                "\nWeapon level: " + getLevel() +
                "\nDamage: " + baseDamage + "\n";
    }
}