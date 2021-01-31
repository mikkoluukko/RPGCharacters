import heroes.Hero;
import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.Item;
import items.ItemType;
import items.SlotType;
import items.armor.Armor;
import items.armor.Cloth;
import items.armor.Leather;
import items.armor.Plate;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.HashMap;
import java.util.Map;

public class Logic {
    private Map<String, Hero> heroes;
    private Map<String, Item> items;

    public Logic() {
        heroes = new HashMap<>();
        items = new HashMap<>();
    }

    public Map<String, Hero> getHeroes() {
        return heroes;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public boolean createHero(String heroClass, String name) {
        boolean heroCreated = true;
        switch (heroClass) {
            case "Warrior" -> heroes.put(name, new Warrior(name));
            case "Ranger" -> heroes.put(name, new Ranger(name));
            case "Mage" -> heroes.put(name, new Mage(name));
            default -> heroCreated = false;
        }
        return heroCreated;
    }

    public boolean createWeapon(String weaponType, String name, int level) {
        boolean weaponCreated = true;
        switch (weaponType) {
            case "Melee" -> items.put(name, new Weapon(name, level, WeaponType.Melee));
            case "Ranged" -> items.put(name, new Weapon(name, level, WeaponType.Ranged));
            case "Magic" -> items.put(name, new Weapon(name, level, WeaponType.Magic));
            default -> weaponCreated = false;
        }
        return weaponCreated;
    }

    public boolean createArmor(String armorType, String name, int level, String slot) {
        boolean slotTypeOk = true;
        boolean armorCreated = true;
        SlotType slotType = null;
        switch (slot) {
            case "Head" -> slotType = SlotType.Head;
            case "Body" -> slotType = SlotType.Body;
            case "Legs" -> slotType = SlotType.Legs;
            default -> slotTypeOk = false;
        }
        if (slotTypeOk) {
            switch (armorType) {
                case "Cloth" -> items.put(name, new Cloth(name, level, slotType));
                case "Leather" -> items.put(name, new Leather(name, level, slotType));
                case "Plate" -> items.put(name, new Plate(name, level, slotType));
                default -> armorCreated = false;
            }
        }
        return armorCreated;
    }

    public boolean checkHeroExists(String name) {
        return heroes.containsKey(name);
    }

    public boolean equipItem(String heroName, String itemName) {
        boolean equippingSuccessfull = false;
        if (items.containsKey(itemName)) {
            if (items.get(itemName).getItemType() == ItemType.Weapon) {
                equippingSuccessfull = heroes.get(heroName).equipWeapon((Weapon) items.get(itemName));
            } else if (items.get(itemName).getItemType() == ItemType.Armor) {
                equippingSuccessfull = heroes.get(heroName).equipArmor((Armor) items.get(itemName));
            }
        }
        return equippingSuccessfull;
    }

    public boolean removeItem(String heroName, String itemName) {
        boolean removingSuccessfull = false;
        if (items.containsKey(itemName)) {
            if (items.get(itemName).getItemType() == ItemType.Weapon) {
                removingSuccessfull = heroes.get(heroName).removeWeapon((Weapon) items.get(itemName));
            } else if (items.get(itemName).getItemType() == ItemType.Armor) {
                removingSuccessfull = heroes.get(heroName).removeArmor((Armor) items.get(itemName));
            }
        }
        return removingSuccessfull;
    }

    public boolean attack(String heroName, String opponentName) {
        boolean attackSuccesfull = false;
        if (heroes.containsKey(opponentName)) {
            heroes.get(heroName).performAttack(heroes.get(opponentName));
            attackSuccesfull = true;
        }
        return attackSuccesfull;
    }
}
