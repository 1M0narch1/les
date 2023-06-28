package com.example.myapplication

import android.app.Application
import com.example.myapplication.database.AppDatabase

class MyAnimalsApp: Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: MyAnimalsApp
    }

}