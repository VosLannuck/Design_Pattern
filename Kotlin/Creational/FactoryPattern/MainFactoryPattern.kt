// This MainFactoryPattern is Connected with MainAbstractFactoryPattern

// Classes 
// Class IronSword
// Class StellSword
// Class DaedricSword

// Class IronBow
// Class DaedricBow
// Class DwemerBow

// Class SwordFactoryCreator
// Class BowFactoryCreator

// Interfaces
// Interface weapon
// Interface Sword
// Interface Bow

// Interface Core Pattern

// Interface WeaponFactoryCreator
// 

/*
   Interfaces Start
 */

interface Weapon {
  fun Damage();
}

interface Sword {
  fun Swing();
}

interface Bow {
  fun Aim();
}

interface WeaponFactoryCreator {
  fun createWeapon(weaponName : String) : Weapon ;
}
/*
   Interfaces End
 */

/*
   Class Factory Start
 */

/*
   Class Factory End
 */

/* Class Sword Start */

class  DaedricSword() : Weapon, Sword {

  override fun Damage() {
    println("Damage using Daedric Sword");
  }

  override fun Swing() {
    println("Swing the Daedric Sword");
  }

}

class SteelSword() : Weapon, Sword {

  override fun Damage() {
    println("Damage Using Steel Sword");
  }

  override fun Swing() {
    println("Swing the Steel Sword ");
  }

} 

class IronSword() : Weapon, Sword {

  override fun Damage() {
    println("Damage using Iron Sword");
  }

  override fun Swing() {
    println("Swing the Iron Sword");
  }
}

/* Class Sword End */

class SwordFactoryCreator() : WeaponFactoryCreator {

  override fun createWeapon(weaponName : String)  : Weapon {
    if(weaponName == "daedric") {
      return DaedricSword()
    } else if(weaponName == "iron") {
      return IronSword()
    } else {
      return SteelSword()
    }
  }

}

class BowFactoryCreator() : WeaponFactoryCreator {

  override fun createWeapon(weaponName : String) : Weapon {
    if(weaponName == "daedric") {
      return DaedricBow()
    } else if(weaponName == "iron") {
      return IronBow()
    } else  {
      return DwemerBow();
    }
  }
}

/*
   Class Bow Start

 */
class IronBow() : Weapon, Bow {
  override fun Damage() {
    println("Damage with Iron Bow")
  }


  override fun Aim() {
    println("Aim the Iron Bow")
  }
}

class DwemerBow() : Weapon, Bow {

  override fun Damage() {
    println("Damage with Dwemer Bow")
  }


  override fun Aim() {
    println("Aim the Dwemer Bow")
  }
}

class DaedricBow() : Weapon, Bow {

  override fun Damage() {
    println("Damage with Daedric Bow")
  }


  override fun Aim() {
    println("Aim the Daedric Bow")
  }

}

/*
   Class Bow End

 */
fun main() {
  val bowFactory : WeaponFactoryCreator = BowFactoryCreator();
  val swordFactory : WeaponFactoryCreator = SwordFactoryCreator();

  val ironBow : Weapon = bowFactory.createWeapon("iron")
  var daedricSword : Weapon = swordFactory.createWeapon("daedric")

  if (daedricSword is Sword) {
      daedricSword.Swing()
    }

  ironBow.Damage()

}
