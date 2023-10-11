package com.example.revisitingandroid.main.contents.designPattern.Creational.Builder

// Class Marksman
// Class Assassin
// Class Tank

// Class MarksmanBuilder
// Class AssassinBuilder
// Class TankBuilder

// Interface CharacterBuilder
// Class CharacterDirector

class CharacterDirector() {
    private lateinit var characterBuilder: CharacterBuilder
    fun setupBuilder(characterBuilder: CharacterBuilder) {
        this.characterBuilder = characterBuilder
    }
    companion object  {
        const val ASSASSIN_DEFAULT_HEALTH : Float = 85f
        const val TANK_DEFAULT_HEALTH : Float = 95f
        const val MARKSMAN_DEFAULT_HEALTH : Float = 65f

        const val ASSASSIN_DEFAULT_WEAPON : String = "Dagger"
        const val TANK_DEFAULT_WEAPON : String = "Shield"
        const val MARKSMAN_DEFAULT_WEAPON : String = "Bow"

    }
    fun buildAssassin(assassinName : String) : CharacterBuilder {
        if(characterBuilder == null) throw Error("Bro Provide the characterBuilder first")
        characterBuilder.setHealth(ASSASSIN_DEFAULT_HEALTH)
        characterBuilder.setWeapon(ASSASSIN_DEFAULT_WEAPON)
        characterBuilder.setName(assassinName)
        return characterBuilder
    }

    fun buildTank(tankName : String) : CharacterBuilder {
        if(characterBuilder == null) throw Error("Bro Provide the characterBuilder first")
        characterBuilder.setHealth(TANK_DEFAULT_HEALTH)
        characterBuilder.setWeapon(TANK_DEFAULT_WEAPON)
        characterBuilder.setName(tankName)
        return characterBuilder
    }

    fun buildMarksman(marksmanName : String) : CharacterBuilder {
        if(characterBuilder == null) throw Error("Bro Provide the characterBuilder first")
        characterBuilder.setHealth(MARKSMAN_DEFAULT_HEALTH)
        characterBuilder.setWeapon(MARKSMAN_DEFAULT_WEAPON)
        characterBuilder.setName(marksmanName)
        return characterBuilder
    }

}
abstract class Character {
    private var level : Int = 1
    private lateinit var name : String;
    private lateinit var weapon : String;
    private var health : Float = 0.0f;
    protected open lateinit var roles : String

    public fun setName(name : String) {
        this.name = name;
    }

    public fun setWeapon(weapon : String) {
        this.weapon = weapon
    }

    public fun setHealth(health : Float){
        this.health = health
    }

    public fun setLevel(level : Int) {
        this.level = level
    }

    override fun toString(): String {
        return "Name : ${this.name}; Health : ${this.health}; Weapon : ${this.weapon}"
    }
}

class Marksman : Character() {
    override var roles = "Marksman"
        get() = roles
}
class Assassin : Character() {
    override var roles = "Assassin"
        get() = roles
}
class Tank : Character() {

    override var roles = "Tank"
        get() = roles
}

interface CharacterBuilder {

    fun buildCharacter() : Character
    fun reset()

    fun setHealth(health : Float) : Unit
    fun setName(name : String) : Unit
    fun setWeapon(weaponName : String): Unit
    fun setLevel(level : Int) : Unit

}

class MarksmanBuilder : CharacterBuilder {
    private var marksman : Marksman = Marksman()

    override fun buildCharacter(): Character {
        var marksmanProduct : Marksman = marksman
        this.reset()
        return marksmanProduct
    }

    override fun reset() {
        marksman = Marksman()
    }

    override fun setHealth(health: Float) {
        this.marksman.setHealth(health);
    }

    override fun setName(name: String) {
        this.marksman.setName(name)
    }

    override fun setWeapon(weaponName: String) {
        this.marksman.setWeapon(weaponName)
    }

    override fun setLevel(level: Int) {
        this.marksman.setLevel(level)
    }

}
class AssassinBuilder : CharacterBuilder {
    private var assassin : Assassin = Assassin()
    override fun buildCharacter(): Character {
        var assassinProduct : Assassin = this.assassin
        this.reset()
        return assassinProduct
    }

    override fun reset() {
        this.assassin = Assassin()
    }

    override fun setHealth(health: Float) {
        this.assassin.setHealth(health)
    }

    override fun setName(name: String) {
        this.assassin.setName(name)
    }

    override fun setWeapon(weaponName: String) {
        this.assassin.setWeapon(weaponName)
    }

    override fun setLevel(level: Int) {
        this.assassin.setLevel(level);
    }

}
class TankBuilder : CharacterBuilder {
    private var tank : Tank = Tank()

    override fun buildCharacter(): Character {
       var tankProduct : Tank = this.tank
        this.reset()
        return tankProduct
    }

    override fun reset() {
        tank = Tank()
    }

    override fun setHealth(health: Float) {
        this.tank.setHealth(health);
    }

    override fun setName(name: String) {
        this.tank.setName(name)
    }

    override fun setWeapon(weaponName: String) {
        this.tank.setWeapon(weaponName)
    }

    override fun setLevel(level: Int) {
        this.tank.setLevel(level)
    }
}

fun main () {

    // Build using Director ( Basically dia adalah suatu kelas untuk
    var assassinBuilder : CharacterBuilder = AssassinBuilder()
    var characterDirector : CharacterDirector = CharacterDirector()
    characterDirector.setupBuilder(assassinBuilder)

    assassinBuilder = characterDirector.buildAssassin("Gusion")
    var assassin : Character = assassinBuilder.buildCharacter()
    println("${assassin.toString()}")

    // BuildManual
    var tankBuilder: CharacterBuilder = TankBuilder()
    var tank = tankBuilder.apply {
        setWeapon("Shield")
        setHealth(1500f)
        setName("Tigreal")
        setLevel(15)
    }.buildCharacter()
    println("Hello this is : ${tank.toString()}")
}
