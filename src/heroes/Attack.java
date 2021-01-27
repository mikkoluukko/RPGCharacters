package heroes;

import items.weapons.Weapon;
import items.weapons.WeaponType;

public class Attack {
    private int averageDamage;
    private Hero attacker;
    private AttackType attackType;

    public Attack(Hero attacker) {
        this.attacker = attacker;
        averageDamage = 0;
        attackType = AttackType.Normal;
    }

    public void updateDamage() {
        if (attacker.weapon != null) {
            switch (attacker.weapon.getWeaponType()) {
                case Melee:
                    averageDamage = (int) Math.floor(attacker.weapon.getBaseDamage() + 1.5 * (attacker.baseStrength + attacker.equipmentStrength));
                    break;
                case Ranged:
                    averageDamage = (int) Math.floor(attacker.weapon.getBaseDamage() + 2 * (attacker.baseDexterity + attacker.equipmentDexterity));
                    break;
                case Magic:
                    averageDamage = (int) Math.floor(attacker.weapon.getBaseDamage() + 3 * (attacker.baseIntelligence + attacker.equipmentIntelligence));
                    break;
            }
        } else {
            averageDamage = 0;
        }
    }

    // Each attack deals 0.5 ... 1.5 * averageDamage
    public int attackDamage() {
        // return averageDamage;
        return (int) Math.floor(Math.random() * averageDamage + 0.5 * averageDamage);
    }


}
