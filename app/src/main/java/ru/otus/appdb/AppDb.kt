package ru.otus.appdb

import androidx.room.Database
import androidx.room.RoomDatabase

const val TAG = "AppDb"

@Database(entities = [Clicks::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun getCountDao(): CountDAO
}