import heroes.Hero;
import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.Item;
import items.SlotType;
import items.armor.Armor;
import items.armor.Plate;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Hero warrior = new Warrior("Conan the Barbarian");
        Hero ranger = new Ranger("Robin Hood");
        Hero mage = new Mage("Harry Potter");
        ArrayList<Item> items = new ArrayList<Item>();
        Weapon greatAxe = new Weapon("Great Axe", 5, WeaponType.Melee);
        Armor plateChest = new Plate("Plate Chest", 5, SlotType.Body);
        // Add weapon and armor into same list to demonstrate item polymorphism
        items.add(greatAxe);
        items.add(plateChest);
        System.out.println(greatAxe);
        warrior.addXp(90);
        warrior.addXp(90);
        System.out.println(warrior);
        warrior.addXp(90);
        System.out.println(warrior);
        warrior.addXp(900);
        System.out.println(warrior);
        warrior.performAttack(mage);
        warrior.equipWeapon(greatAxe);
        warrior.equipArmor(plateChest);
        System.out.println(warrior);
        warrior.performAttack(ranger);
        System.out.println(plateChest);
        mage.addXp(1400);
        System.out.println(mage);
        ranger.addXp(1900);
        System.out.println(ranger);
        System.out.println(ranger.showEquipment());

        warrior.removeArmor(plateChest);
        System.out.println(warrior.showEquipment());
    }
}
