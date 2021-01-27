import heroes.Hero;
import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.Item;
import items.SlotType;
import items.armor.Armor;
import items.armor.ArmorType;
import items.armor.Plate;
import items.weapons.Weapon;
import items.weapons.WeaponType;

public class Main {

    public static void main(String[] args) {
	    Hero warrior = new Warrior("Conan the Barbarian");
        Hero ranger = new Ranger("Robin Hood");
        Hero mage = new Mage("Harry Potter");
        Weapon greatAxe = new Weapon("Great Axe", 5, WeaponType.Melee);
        Armor plateChest = new Plate("Plate Chest", 5, SlotType.Body);
        System.out.println(greatAxe.toString());
        warrior.addXp(90);
        //System.out.println(warrior.toString());
        warrior.addXp(90);
        System.out.println(warrior.toString());
        warrior.addXp(90);
        System.out.println(warrior.toString());
        warrior.addXp(900);
        System.out.println(warrior.toString());
        warrior.performAttack(mage);
        warrior.equipWeapon(greatAxe);
        warrior.equipArmor(plateChest);
        System.out.println(warrior.toString());
        warrior.performAttack(ranger);
        System.out.println(plateChest.toString());
        mage.addXp(1400);
        System.out.println(mage);
        ranger.addXp(1900);
        System.out.println(ranger);
    }
}
