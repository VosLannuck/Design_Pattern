class SingletonSynchronized {

    var data : Int = 0
    companion object {

        @Volatile
        private var INSTANCE : SingletonSynchronized? = null

        @JvmStatic
        fun getInstance() : SingletonSynchronized {
            // Synchronized -> Memastikan bahwasanya hanya SATU THREAD yang mengeksekusi BLOCK dari Synchronized
            // COSTLY <-- Bahasan permasalahan OS -->
            // Satu pendekatan
            return INSTANCE ?: synchronized(this, block = {
                val instance = SingletonSynchronized()
                INSTANCE = instance
                instance
            })
        }

    }

}

class NotSingleton() {

}

fun main() {

    val singletonA: SingletonSynchronized = SingletonSynchronized.getInstance()
    val singletonB: SingletonSynchronized = SingletonSynchronized.getInstance()

    val notSingletonA : NotSingleton = NotSingleton()
    val notSingletonB : NotSingleton = NotSingleton()

    println("SingletonA References: ${singletonA.toString()}")
    println("SingletonB References: ${singletonB.toString()}")

    println()

    println("NotSingletonA References: ${notSingletonA.toString()}")
    println("NotSingletonB References: ${notSingletonB.toString()}")
}

