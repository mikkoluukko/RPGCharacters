package items.weapons;

import items.Item;

public interface Weapon extends Item {
    String getWeaponType();
    int getBaseDamage();
}