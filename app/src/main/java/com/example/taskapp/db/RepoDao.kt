package com.example.taskapp.db

import androidx.room.*
import com.example.taskapp.model.RepoDb

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRepo(vararg repoDb: RepoDb)

    @Delete
    fun deleteRepo(repoDb: RepoDb)

    @Query("select * from RepoDb")
    fun queryAllAddedRepo(): List<RepoDb>

}