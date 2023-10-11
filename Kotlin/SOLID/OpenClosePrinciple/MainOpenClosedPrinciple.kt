package com.example.revisitingandroid.main.contents.designPattern.SOLID.OpenClosePrinciple

abstract class Enemy {
    var enemyDamage : Int = 5
    abstract fun attack() : Int;
}

abstract class EnemyDragon : Enemy(){

    abstract fun fly();
}

abstract class EnemySkeleton : Enemy() {
    abstract fun throwSkeleton();
}
abstract class EnemyVampire : Enemy() {
    abstract fun bite()
}

abstract class EnemyGoblin : Enemy() {
    abstract fun goblinSpecial()
}

class Serena : EnemyVampire() {
    override fun bite() {

    }

    override fun attack(): Int {
        return this.enemyDamage * 10
    }

}

class SmallGoblin : EnemyGoblin() {
    override fun goblinSpecial() {

    }

    override fun attack(): Int {
        return 5
    }

}

class Dragon : EnemyDragon() {
    init {
        this.enemyDamage = 15
    }

    override fun fly() {
        println("Dragon is flying")
    }

    override fun attack() : Int {
        return this.enemyDamage * 2
    }
}

class Skeleton : EnemySkeleton() {
    init {
        this.enemyDamage = 8
    }

    override fun throwSkeleton() {
        println("Throw Knife")
    }
    override fun attack(): Int {
        return this.enemyDamage + 8
    }
}

class Player {
    var playerHealth : Int = 100

    fun getAttacked(totalDamage : Int ): Unit {
        this.playerHealth -= totalDamage
        println("Player health : ${this.playerHealth}")
    }
}

class DamageMedium() {

    fun getDamage(vararg damage : Enemy) : Int {
        var totalDamage : Int  = 0
        for (i in damage){
            totalDamage += i.attack()
        }
        return totalDamage
    }
}

fun main() {
    var dragon: Enemy = Dragon()
    var skeleton : Enemy = Skeleton()
    var damageMedium : DamageMedium = DamageMedium()

    var player : Player = Player()
    val totalDamage : Int = damageMedium.getDamage(dragon, skeleton)
    player.getAttacked(totalDamage)
}
