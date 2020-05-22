package ru.otus.appdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CountDAO {

    @Query("select count from click_table")
    fun getCountClick(): Int

    @Update
    fun updateCount(clicks: Clicks)

    @Insert
    fun saveClick(clicks: Clicks)

    @Query("select * from click_table")
    fun getAllClicks(): List<Clicks>
}