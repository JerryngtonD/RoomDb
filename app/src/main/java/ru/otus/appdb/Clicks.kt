package ru.otus.appdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "click_table")
data class Clicks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val count: Int = 0
)