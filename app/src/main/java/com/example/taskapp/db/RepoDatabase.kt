package com.example.taskapp.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskapp.AppApplication
import com.example.taskapp.model.RepoDb

@Database(entities = [RepoDb::class], version = 1)
abstract class RepoDatabase: RoomDatabase() {

    companion object {
        val instance = Room.databaseBuilder(AppApplication.context!!, RepoDatabase::class.java, "repo_database_table")
            .allowMainThreadQueries()
            .build()
    }

    abstract fun getRepoDao(): RepoDao

}