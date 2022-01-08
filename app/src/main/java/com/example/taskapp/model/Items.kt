package com.example.taskapp.model

import androidx.room.Entity

@Entity
data class Items(
    val item: List<Item>
)