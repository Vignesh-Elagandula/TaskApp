package com.example.taskapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepoDb(
    var name: String? = null,
    var description: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}