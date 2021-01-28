# Task 3: RPG Characters
## About
This program is a simple RPG character system. 
The goal was to make it as extendable as possible by following good modelling and class design conventions.

## Requirements / task definition
### The characters
There are several attributes that all characters have:
- <b>Health</b>
- <b>Strength</b>
- <b>Dexterity</b>
- <b>Intelligence</b>
#### Health
Health determines how much health a character has
#### Strength
Strength boosts the character's damage done with melee weapons.
1 point of Strength results in 1.5 additional melee weapon damage.
#### Dexterity
Dexterity boosts the character's damage done with ranged weapons.
1 point of Strength results in 2 additional ranged weapon damage.
#### Intelligence
Intelligence boosts the character's damage done with magic weapons.
1 point of Strength results in 3 additional magic weapon damage.

In addition to these attributes, a character has a <b>Level</b>. 
All characters start at level 1 and require 100 <b>xp</b> to get to level 2.
The required xp to get to the next level is increased by 10% each time (rounded down), i.e. 100 -> 110 -> 121 -> 133 -> 146 -> 160 etc..

A character can interact with <b>Item</b>s in various ways. 
A character has 4 slots where they can equip items:
- <b>Weapon</b>
- <b>Head</b>
- <b>Body</b>
- <b>Legs</b>

### Character classes
Currently, there are three classes in the game: <b>Warrior</b>, <b>Ranger</b> and <b>Mage</b>.
#### Warrior
Thematically, Warriors are mighty brutes well versed in melee combat.
For this reason, they have naturally higher Strength than other classes.
- Warriors begin at level 1 with: 150 HP, 10 Str, 3 Dex, 1 Int.
- On level up, a Warrior gains: 30 HP, 5 Str, 2 Dex, 1 Int.
#### Ranger
Thematically, Rangers are master of combat at a distance, and are proficient with ranged weapons.
They have naturally higher Dexterity than other classes.
- Rangers begin at level 1 with: 120 HP, 5 Str, 10 Dex, 2 Int.
- On level up, a Ranger gains: 20 HP, 2 Str, 5 Dex, 1 Int.
#### Mage
Thematically, Mages are masters of arcane and magic.
They have naturally higher Intelligence than other classes.
- Mages begin at level 1 with: 100 HP, 2 Str, 3 Dex, 10 Int.
- On level up, a Warrior gains: 15 HP, 1 Str, 2 Dex, 5 Int.

### Items
Currently, there are two types of items in the game: <b>Armor</b> and <b>Weapon</b>s.
There are three types of armor: <b>Cloth</b>, <b>Leather</b> and <b>Plate</b>.
There are also three types of weapons: <b>Melee</b>, <b>Ranged</b> and <b>Magic</b>.
All items have a level associated with them, which is the required level to equip as well as scaling weapon's base damage.
All items have a particular slot they fit to. All items have a name.
#### Weapons
Weapons have a <b>base damage</b> which is increased vy Strength for Melee Weapons,
Dexterity for Ranged Weapons or by Intelligence for Magic Weapons. Weapons have no other stats on them.
- All melee weapons have a base damage of 15, scaling by 2 every level.
When a character attacks with a melee weapon, the damage
dealt is the damage of the weapon (with level scaling included) + the
characters effective (base + equipment) Strength value * 1.5.
  - Meaning the damage of a melee weapon is increased by
  1.5*Str, rounded down.
- All ranged weapons have a base damage of 5, scaling by 3 every
  level. When a character attacks with a ranged weapon, the damage
  dealt is the damage of the weapon (with level scaling included) + the
  characters effective (base + equipment) Dexterity value * 2.
  - Meaning the damage of a ranged weapon Is increased by
    2*Dex, rounded down.
- All magic weapons have a base damage of 25, scaling by 2 every
  level. When a character attacks with a magic weapon, the damage
  dealt is the damage of the weapon (with level scaling included) + the
  characters effective (base + equipment) Intelligence value * 3.
 - Meaning the damage of a magic weapon is increased by 3*Int,
   rounded down.

#### Armor
Armor can apply bonuses to Health, Strength, Dexterity, and/or
Intelligence. Changing depending on the type of armor. The slot effects
how the armor stats are scaled after calculations.
- A Cloth armor piece has a base bonus of 10 HP, 3 Int, 1 Dex.
  - Scaled with 5 HP, 2 Int and 1 Dex per level.
- A Leather armor piece has a base bonus of 20 HP, 3 Dex, 1 Str.
  - Scaled with 8 HP, 2 Dex and 1 Str per level.
- A Plate armor piece has a base bonus of 30 HP, 3 Str, 1 Dex.
  - Scaled with 12 HP, 2 Str and 1 Dex per level.

Finally, all armor scales depending on what slot it is in.
- Body is 100%
- Head is 80%,
- Legs are 60%.

This means that after the bonuses have been calculated (base bonus +
bonus from levels), all the stats are scaled according to slot - rounded
down to the nearest whole number (converted to int).

#### Equipping an item
When a character equips an item, their stats should update accordingly, a
way of approaching this is having base stats, and stats added by gear
stored separately - this could avoid issues when changing gear around
and leveling up. When a new piece of equipment is added when there is an
existing piece in that slot (i.e. adding new boots when you already have
boots) it should just replace the existing equipment.

#### Attack damage
When a character attacks, their weapon will deal its base damage + any
bonus from stats. If a character has no weapon equipped, this will
result in no damage dealt.

## Code description
The source code is divided into two main packages, `heroes` and `items`. 

Package `heroes` includes:
- An abstract class `Hero` and its subclasses for different character types (`Mage`, `Ranger`, `Warrior`).
- `Attack` class for calculating default damage of a specific weapon and for attacking.
- Enums `HeroType` where different allowed character classes are defined and `AttackType`(not defined in the task requirements) where different attack types are defined.

Package `items` includes:
- An abstract class `Item`.
- Enums `ItemType` where different item types are defined and `SlotType` where different slot types are defined.
- Subpackages `armor` and `weapon`.

Subpackage `armor` includes:
- An abstract class `Armor` (inherited from `Item`) and its subclasses for different armor types (`Cloth`, `Leather`, `Plate`).
- Enum `HeroType` where different allowed armor types are defined.

Subpackage `weapon` includes:
- Class `Weapon`.
- Enum `WeaponType` where different allowed weapon types are defined.