package com.example.revisitingandroid.main.contents.designPattern.Creational.Singleton

class SingletonHighLevel {
    private var data : Int = 0

    companion object  {

        // - Can be || written by multiple threads and volatile does not prevent it|| <-- THis is the problem, RACE condition
        // - Visible to all threads
        // - Read is not saved by thread cache
        @Volatile
        private var INSTANCE : SingletonHighLevel? = null

        @JvmStatic
        fun getInstance() : SingletonHighLevel {
            lateinit var instance : SingletonHighLevel

            if(INSTANCE != null) {
                instance = INSTANCE as SingletonHighLevel
            }
            else {
                instance = SingletonHighLevel()
                INSTANCE = instance
            }

            return instance
        }

    }
}

fun main() {
    val singletonA: SingletonHighLevel = SingletonHighLevel.getInstance()
    val singletonB: SingletonHighLevel = SingletonHighLevel.getInstance()
    val singletonC: SingletonHighLevel = SingletonHighLevel.getInstance()

    println("SingletonA References: ${singletonA.toString()}")
    println("SingletonB References: ${singletonB.toString()}")
    println("SingletonC References: ${singletonC.toString()}")
}