package heroes;

public class Attack {
    private int defaultDamage;
    private Hero attacker;
    private AttackType attackType;

    public Attack(Hero attacker) {
        this.attacker = attacker;
        defaultDamage = 0;
        attackType = AttackType.Normal;
    }

    public void updateDamage() {
        if (attacker.weapon != null) {
            switch (attacker.weapon.getWeaponType()) {
                case Melee:
                    defaultDamage = (int) Math.floor(attacker.weapon.getBaseDamage() +
                            1.5 * (attacker.baseStrength + attacker.equipmentStrength));
                    break;
                case Ranged:
                    defaultDamage = (int) Math.floor(attacker.weapon.getBaseDamage() +
                            2 * (attacker.baseDexterity + attacker.equipmentDexterity));
                    break;
                case Magic:
                    defaultDamage = (int) Math.floor(attacker.weapon.getBaseDamage() +
                            3 * (attacker.baseIntelligence + attacker.equipmentIntelligence));
                    break;
            }
        } else {
            defaultDamage = 0;
        }
    }

//     Each attack deals 0.5 ... 1.5 * averageDamage
    public int attackDamage() {
        return (int) Math.floor(Math.random() * defaultDamage + 0.5 * defaultDamage);
    }


}
