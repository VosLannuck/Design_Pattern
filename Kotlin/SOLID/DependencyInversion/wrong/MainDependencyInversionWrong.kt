package com.example.revisitingandroid.main.contents.designPattern.SOLID.DependencyInversion.wrong

class Player(
    private var playerHealth : IHealth,
    private var playerWeapon : IWeapon,
) {

    fun attack() {
        playerWeapon.attack()
    }

    fun damage() : Unit {
        playerHealth.decreaseHealth()
    }

    fun heal() : Unit {
        playerHealth.increaseHealth()
    }

    fun setWeapon(weapon : AxeVanilla) : Unit {

        this.playerWeapon = weapon
    }


    fun setWeapon(weapon : SpecialAxe) : Unit {

        this.playerWeapon = weapon
    }

}

interface IHealth {

    fun increaseHealth();
    fun decreaseHealth();
}

class HumanHealth : IHealth {
    override fun increaseHealth() {
        println("Increasing health by 10")
    }

    override fun decreaseHealth() {
        println("Decreasing health by 10")
    }
}

class DragonHealth : IHealth {
    override fun increaseHealth() {
        println("Increasing health by 50")
    }

    override fun decreaseHealth() {
        println("Decreasing health by 5")
    }

}

abstract class IWeapon {
    var weaponDamage : Int = 10
    abstract fun attack()
}

class AxeVanilla : IWeapon() {

    init {
        this.weaponDamage = 20
    }
    override fun attack() {
        println("Axe Attacking")
        println("Dealing damage ... ${this.weaponDamage}")
    }
}

class BowVanilla : IWeapon() {
    init {
        this.weaponDamage = 15
    }
    override fun attack() {
        println("Bow Attacking")
        println("Dealing damage ... ${this.weaponDamage}")
    }
}

interface ISpecialWeapon {
    fun specialAttack()
}

class SpecialAxe : IWeapon(), ISpecialWeapon {
    init {
        this.weaponDamage = 30
    }
    override fun attack() {
        specialAttack()
    }

    override fun specialAttack() {
        println("Additional special attribute ... ")
        this.weaponDamage += 15
    }

}

class SpecialBow : IWeapon(), ISpecialWeapon {
    override fun attack() {
        println("Attack with Bow")
        specialAttack()
        println("Dealing damage ... ${this.weaponDamage}")
    }

    override fun specialAttack() {
        println("Additional special attribute ... ")
        this.weaponDamage += 10
        println("Dealing damage ... ${this.weaponDamage}")
    }

}

//Bareng anak anak
class PlayerConcrete(
    private var playerHealth : IHealth,
    private var playerWeapon : IWeapon,
) {

    fun attack() {
        playerWeapon.attack()
    }

    fun damage() : Unit {
        playerHealth.decreaseHealth()
    }

    fun heal() : Unit {
        playerHealth.increaseHealth()
    }

    fun setWeapon(weapon : IWeapon) : Unit {

        this.playerWeapon = weapon
    }

    fun setWeapon(weapon : SpecialAxe) : Unit {

        this.playerWeapon = weapon
    }

    fun setWeapon(weapon : BowVanilla) : Unit {

    }
}

fun main() {

    val humanHealth : HumanHealth = HumanHealth()
    val dragonHealth : DragonHealth = DragonHealth()

    val axeWeapon : AxeVanilla = AxeVanilla()
    val specialAxe : SpecialAxe = SpecialAxe()

    val bowWeapon : BowVanilla = BowVanilla()
    val specialBow : SpecialBow = SpecialBow()

    val player1 : Player = Player(humanHealth, axeWeapon)
    val player2 : Player = Player(humanHealth, specialAxe)

    player1.attack()
    player1.heal()
    player1.damage()

    player1.setWeapon(specialAxe)
    player1.attack()
}

