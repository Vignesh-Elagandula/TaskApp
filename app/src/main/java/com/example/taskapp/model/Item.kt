package com.example.taskapp.model

data class Item(
    val name: String,
    val request: Request,
    val response: List<Any>
)