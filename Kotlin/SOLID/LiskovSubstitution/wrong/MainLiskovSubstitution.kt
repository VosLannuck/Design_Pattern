package com.example.revisitingandroid.main.contents.designPattern.SOLID.LiskovSubstitution.wrong
// This violates the Liskov Substitution Principle because the derived classes do not
// behave as expected when used interchangeably with the base class, leading to unexpected results in the battle simulation.
// -> 24 Design Pattern by gof
/*
* Subclasses should override methods from the base class only if they are
* providing a more specific or specialized version of that method.

The method's signature (parameters and return type) should remain the same or
*  follow the principles of contravariance for parameters (parameters can be more generic in the subclass)
*  and covariance for return types (return types can be more specific in the subclass).

Subclasses should not introduce unrelated or unexpected behavior in their method overrides that would break
* the expected behavior established by the base class.
* */
abstract class Human {
    //
}
abstract class Character {
    var health : Int = 100
    open fun attack(target : Character) {
        target.health -= 10
    }

    fun printStatus() {
        println(health)
    }
}
abstract class Follower : Character() {
    var followerName : String = "Serana"
}

abstract  class FemaleFollower : Follower() {
}

abstract  class MaleFollower  : Follower() {
}
class Enemy: Character(){
    override fun attack(target: Character) {
        super.attack(target)
    }
}

class Player : Character() {
    var experience : Float = 0.0f
    var listCompanions : List<Follower> = listOf()
    fun usePotion() {
        this.health += 20
    }
    override fun attack(target: Character) {
        super.attack(target)
        usePotion()
    }

    open fun getFirstCompanion() : Follower {
        return listCompanions[0]
    }

}


fun main() {

    var player : Character = Player()
    var enemy1 : Character = Enemy()

    player.attack(enemy1)

    enemy1.attack(player)

    player.printStatus()
    enemy1.printStatus()

}
