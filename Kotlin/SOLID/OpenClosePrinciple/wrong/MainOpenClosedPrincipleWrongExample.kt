package com.example.revisitingandroid.main.contents.designPattern.SOLID.OpenClosePrinciple.wrong

abstract class Enemy {
    var enemyDamage : Int = 5
}

abstract class EnemyDragon : Enemy(){

    abstract fun fly();
}

abstract class EnemySkeleton : Enemy() {
    abstract fun throwSkeleton();
}
abstract class EnemyVampire : Enemy() {
    abstract  fun bite()
}

class VampireClassA : EnemyVampire() {
    init {
        this.enemyDamage = 10
    }
    override fun bite() {
        println("I Am biting you")
    }

}
class Dragon : EnemyDragon() {
    init {
        this.enemyDamage = 15
    }

    override fun fly() {
        println("Dragon is flying")
    }
}

class Skeleton : EnemySkeleton() {
    init {
        this.enemyDamage = 8
    }

    override fun throwSkeleton() {
        println("Throw Knife")
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

    fun getDamage(vararg damage :Enemy  ) : Int {
        var totalDamage : Int  = 0
        for (i in damage){
            if(i is EnemyDragon) {
                totalDamage += i.enemyDamage * 2
            }else if( i is EnemySkeleton) {
                totalDamage += i.enemyDamage + 10
            }else if(i is EnemyVampire) {
                totalDamage += i.enemyDamage * 4
            }
        }
        return totalDamage
    }
}

fun main() {
    var dragon: EnemyDragon = Dragon()
    var skeleton : EnemySkeleton = Skeleton()

    var damageMedium : DamageMedium = DamageMedium()

    var player : Player = Player()
    val totalDamage : Int = damageMedium.getDamage(dragon, skeleton)
    player.getAttacked(totalDamage)
}