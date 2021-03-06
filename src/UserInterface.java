import heroes.Hero;
import heroes.Mage;
import heroes.Ranger;
import heroes.Warrior;
import items.armor.Armor;
import items.armor.ClothArmor;
import items.armor.LeatherArmor;
import items.armor.PlateArmor;
import items.weapons.MagicWeapon;
import items.weapons.MeleeWeapon;
import items.weapons.RangedWeapon;
import items.weapons.Weapon;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    Logic logic;
    String selectedHero;

    public UserInterface(Scanner scanner, Logic logic) {
        this.scanner = scanner;
        this.logic = logic;
    }

    public int getInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Enter a valid integer");
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void runUserInterface() {
        System.out.println("Welcome to RPG Characters demonstration");
        boolean runProgram = true;
        while (runProgram) {
            System.out.println("-----------------------------------------------------");
            System.out.println("To select an action input the number and press Enter:");
            System.out.println("1 - Create a new hero");
            System.out.println("2 - Create a new item");
            System.out.println("3 - Display all heroes");
            System.out.println("4 - Display all items");
            System.out.println("5 - Select a hero");
            System.out.println("6 - Use the selected hero");
            System.out.println("7 - Run the pre-defined demo");
            System.out.println("0 - Quit");
            String mainCommand = scanner.nextLine();
            switch (mainCommand) {
                case "1" -> createCharacter();
                case "2" -> createItem();
                case "3" -> logic.getHeroes().values().forEach(System.out::println);
                case "4" -> logic.getItems().values().forEach(System.out::println);
                case "5" -> selectHero();
                case "6" -> useCharacter();
                case "7" -> runDemo();
                case "0" -> {
                    runProgram = false;
                    System.out.println("Goodbye");
                }
                default -> System.out.println("Illegal input: " + mainCommand);
            }
        }
    }

    private void createCharacter() {
        System.out.println("Input hero's class (Warrior, Ranger, Mage):");
        String heroClass = scanner.nextLine();
        System.out.println("Input hero's name:");
        String heroName = scanner.nextLine();
        if (logic.createHero(heroClass, heroName)) {
            System.out.println(heroClass + " named: " + heroName + " successfully created");
        } else {
            System.out.println("Invalid hero class: " + heroClass);
        }
    }

    private void createItem() {
        System.out.println("Input item's type (Weapon, Armor):");
        String itemType = scanner.nextLine();
        if (itemType.equals("Weapon")) {
            createWeapon();
        } else if (itemType.equals("Armor")) {
            createArmor();
        } else {
            System.out.println("Invalid item type: " + itemType);
        }
    }

    public void createWeapon() {
        System.out.println("Input weapon's type (Melee, Ranged, Magic):");
        String weaponType = scanner.nextLine();
        System.out.println("Input weapon's name:");
        String weaponName = scanner.nextLine();
        System.out.println("Input weapon's level:");
        int weaponLevel = getInt();
        if (logic.createWeapon(weaponType, weaponName, weaponLevel)) {
            System.out.println("Level " + weaponLevel + " " + weaponType +
                    " weapon named: " + weaponName + " successfully created");
        } else {
            System.out.println("Invalid weapon type: " + weaponType);
        }
    }

    public void createArmor() {
        System.out.println("Input armor's type (Cloth, Leather, Plate):");
        String armorType = scanner.nextLine();
        System.out.println("Input armor's name:");
        String armorName = scanner.nextLine();
        System.out.println("Input armor's level:");
        int armorLevel = getInt();
        System.out.println("Input armor's slot (Head, Body, Legs):");
        String slot = scanner.nextLine();
        if (logic.createArmor(armorType, armorName, armorLevel, slot)) {
            System.out.println("Level " + armorLevel + " " + armorType + " armor for slot: " + slot +
                    " named: " + armorName + " successfully created");
        } else {
            System.out.println("Invalid armor type: " + armorType + " or slot: " + slot);
        }
    }

    public void selectHero() {
        System.out.println("Input hero's name:");
        String heroName = scanner.nextLine();
        if (logic.checkHeroExists(heroName)) {
            selectedHero = heroName;
            System.out.println("The selected hero is now: " + heroName);
        } else {
            System.out.println("Hero named: " + heroName + " does not exist");
        }
    }

    public void useCharacter() {
        if (selectedHero != null) {
            System.out.println("Select an action:");
            System.out.println("1 - Display hero's all information");
            System.out.println("2 - Equip an item");
            System.out.println("3 - Remove an item");
            System.out.println("4 - Increase XP");
            System.out.println("5 - Attack another character");
            String command = scanner.nextLine();
            switch (command) {
                case "1" -> displayHero(selectedHero);
                case "2" -> equipItem(selectedHero);
                case "3" -> removeItem(selectedHero);
                case "4" -> increaseXP(selectedHero);
                case "5" -> attack(selectedHero);
            }
        }
    }

    public void displayHero(String heroName) {
        Hero hero = logic.getHeroes().get(heroName);
        System.out.println(hero);
        System.out.println(hero.getEquipmentInfo());
    }

    private void equipItem(String heroName) {
        System.out.println("Input item's name:");
        String itemName = scanner.nextLine();
        if (logic.equipItem(heroName, itemName)) {
            System.out.println(heroName + " successfully equipped " + itemName);
        } else {
            System.out.println();
        }
    }

    private void removeItem(String heroName) {
        System.out.println("Input item's name:");
        String itemName = scanner.nextLine();
        if (logic.removeItem(heroName, itemName)) {
            System.out.println(heroName + " successfully removed " + itemName);
        } else {
            System.out.println();
        }
    }

    private void increaseXP(String heroName) {
        System.out.println("Input the amount of xp to be added");
        int xp = getInt();
        logic.getHeroes().get(heroName).addXp(xp);
    }

    private void attack(String heroName) {
        System.out.println("Input the name of the opponent to be attacked against");
        String opponentName = scanner.nextLine();
        if (!logic.attack(heroName, opponentName)) {
            System.out.println("Opponent named: " + opponentName + " not found");
        }
    }

    private void runDemo() {
        Hero warrior = new Warrior("Conan the Barbarian");
        Hero ranger = new Ranger("Robin Hood");
        Hero mage = new Mage("Harry Potter");
        Weapon beginnerSword = new MeleeWeapon("Beginner Sword", 1);
        Weapon averageBow = new RangedWeapon("Average Bow", 5);
        Weapon masterWand = new MagicWeapon("Master Wand", 10);
        Armor plateChest = new PlateArmor("Plate Chest", 2, "Body");
        Armor oldPants = new ClothArmor("Old Pants", 1, "Legs");
        Armor leatherHat = new LeatherArmor("Leather Hat", 6, "Head");
        warrior.equipItem(beginnerSword);
        warrior.addXp(90);
        warrior.equipItem(plateChest);
        warrior.addXp(90);
        warrior.equipItem(plateChest);
        warrior.addXp(1000);
        warrior.equipItem(leatherHat);
        System.out.println(warrior.getEquipmentInfo());
        System.out.println(warrior);
        warrior.removeItem(plateChest);
        warrior.removeItem(leatherHat);
        System.out.println(warrior.getEquipmentInfo());
        System.out.println(warrior);
        mage.addXp(500);
        warrior.performAttack(mage);
        System.out.println(mage);
        mage.addXp(1000);
        mage.equipItem(masterWand);
        System.out.println(mage);
        mage.performAttack(warrior);
    }
}
