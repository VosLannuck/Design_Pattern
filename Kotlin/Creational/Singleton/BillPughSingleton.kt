class BillPughSingleton private constructor( var data : Int) {
    // Private constructor <-- Kelas ini doang yang bisa buat nya
    companion object {

        // Static Obj
        @Volatile // <--
        private var billPughSingleton : BillPughSingleton? = null

        // Lazy initialization
        class BillPughSingletonHelper {
            // Creationalnya dilakuin disini
            companion object {

                private lateinit var instance : BillPughSingleton

                @JvmStatic
                fun instance(data : Int) : BillPughSingleton {
                    if (billPughSingleton == null) {
                        instance = BillPughSingleton(data)
                        billPughSingleton = instance
                    }else {
                        instance = billPughSingleton as BillPughSingleton
                    }
                    return instance
                }
            }
        }

        @JvmStatic
        fun getInstance(data: Int) : BillPughSingleton {
            // Exposed to the client
            return BillPughSingletonHelper.instance(data)
        }
    }
}

fun main() {

    val singletonA: BillPughSingleton = BillPughSingleton.getInstance(50)
    val singletonB: BillPughSingleton = BillPughSingleton.getInstance(50)

    println("SingletonA References: ${singletonA.toString()}")
    println("SingletonB References: ${singletonB.toString()}")

    println("SingletonA Value ${singletonA.data}")
}
