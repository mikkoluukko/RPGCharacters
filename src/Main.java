import heroes.Hero;
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
	    Hero warrior = new Warrior();
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
        warrior.attack();
        warrior.setWeapon(greatAxe);
        warrior.setBody(plateChest);
        System.out.println(warrior.toString());
        warrior.attack();
        System.out.println(plateChest.toString());
    }
}
