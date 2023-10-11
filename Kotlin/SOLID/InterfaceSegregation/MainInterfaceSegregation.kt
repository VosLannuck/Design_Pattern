package com.example.revisitingandroid.main.contents.designPattern.SOLID.InterfaceSegregation

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

    fun setWeapon(weapon : IWeapon) : Unit {
        this.playerWeapon = weapon
    }
}

interface IHealth {

    fun increaseHealth();
    fun decreaseHealth();
}

abstract class IWeapon {
    var weaponDamage : Int = 10
    abstract fun attack()
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


fun main() {

    val humanHealth : IHealth = HumanHealth()
    val dragonHealth : IHealth = DragonHealth()

    val axeWeapon : IWeapon = AxeVanilla()
    val specialAxe : IWeapon = SpecialAxe()

    val bowWeapon : IWeapon = BowVanilla()
    val specialBow : IWeapon = SpecialBow()

    val player1 : Player = Player(humanHealth, axeWeapon)
    val player2 : Player = Player(humanHealth, specialAxe)

    player1.attack()
    player1.heal()
    player1.damage()

    player1.setWeapon(specialAxe)
    player1.attack()
}
