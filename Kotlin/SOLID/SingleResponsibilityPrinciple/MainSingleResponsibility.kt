package com.example.revisitingandroid.main.contents.designPattern.SOLID.SingleResponsibilityPrincipl


class CacheStorage(private val dbStorage : DbStorage)  {
    var data : List<Int> = listOf()
    fun getSavedData(): List<Int> {
        if(data.isNotEmpty()) {
            return data
        }

        data = dbStorage.getSavedData()
        return data
    }

    fun saveData(data: List<Int>) {
        this.data = data
    }
}

class DbStorage {
    var data : List<Int> = listOf(1, 2, 3, 4, 5 )
    fun getSavedData(): List<Int> {
        return data
    }

    fun saveData(data: List<Int>) {
        this.data = data
    }
}


fun main() {
    var dbStorage : DbStorage = DbStorage()
    var cache : CacheStorage = CacheStorage(dbStorage)

    println(cache.getSavedData())

    var customList : List<Int> = listOf(2,4,6,8,10)
    dbStorage.saveData(customList)

    println(cache.getSavedData())
}