import heroes.Hero;
import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.Item;
import items.armor.ClothArmor;
import items.armor.LeatherArmor;
import items.armor.PlateArmor;
import items.weapons.MagicWeapon;
import items.weapons.MeleeWeapon;
import items.weapons.RangedWeapon;

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
        boolean isCreated = true;
        switch (heroClass) {
            case "Warrior" -> heroes.put(name, new Warrior(name));
            case "Ranger" -> heroes.put(name, new Ranger(name));
            case "Mage" -> heroes.put(name, new Mage(name));
            default -> isCreated = false;
        }
        return isCreated;
    }

    public boolean createWeapon(String weaponType, String name, int level) {
        boolean isCreated = true;
        switch (weaponType) {
            case "Melee" -> items.put(name, new MeleeWeapon(name, level));
            case "Ranged" -> items.put(name, new RangedWeapon(name, level));
            case "Magic" -> items.put(name, new MagicWeapon(name, level));
            default -> isCreated = false;
        }
        return isCreated;
    }

    public boolean createArmor(String armorType, String name, int level, String slotType) {
        boolean isCreated = false;
        if (isLegalSlot(slotType) && isLegalArmorType(armorType)) {
            switch (armorType) {
                case "Cloth" -> items.put(name, new ClothArmor(name, level, slotType));
                case "Leather" -> items.put(name, new LeatherArmor(name, level, slotType));
                case "Plate" -> items.put(name, new PlateArmor(name, level, slotType));
            }
            isCreated = true;
        }
        return isCreated;
    }

    public boolean isLegalSlot(String slot) {
        return switch (slot) {
            case "Head", "Body", "Legs" -> true;
            default -> false;
        };
    }

    public boolean isLegalArmorType(String armorType) {
        return switch (armorType) {
            case "Cloth", "Leather", "Plate" -> true;
            default -> false;
        };
    }

    public boolean checkHeroExists(String name) {
        return heroes.containsKey(name);
    }

    public boolean equipItem(String heroName, String itemName) {
        boolean equippingSuccessful = false;
        if (items.containsKey(itemName)) {
            equippingSuccessful = heroes.get(heroName).equipItem(items.get(itemName));
        }
        return equippingSuccessful;
    }

    public boolean removeItem(String heroName, String itemName) {
        boolean isRemoved = false;
        if (items.containsKey(itemName)) {
            if (items.containsKey(itemName)) {
                isRemoved = heroes.get(heroName).removeItem(items.get(itemName));
            }
        }
        return isRemoved;
    }

    public boolean attack(String heroName, String opponentName) {
        boolean didAttack = false;
        if (heroes.containsKey(opponentName)) {
            heroes.get(heroName).performAttack(heroes.get(opponentName));
            didAttack = true;
        }
        return didAttack;
    }
}
