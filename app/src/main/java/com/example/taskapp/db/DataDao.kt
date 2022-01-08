package com.example.taskapp.db

import androidx.room.*
import com.example.taskapp.model.Items

@Dao
interface DataDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRepo(vararg repoModel: Items)

    @Delete
     fun deleteRepo(repoModel: Items)

    @Query("select * from Items")
    fun queryAllItems(): List<Items>



}