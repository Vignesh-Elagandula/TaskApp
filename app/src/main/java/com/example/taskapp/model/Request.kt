package com.example.taskapp.model

data class Request(
    val header: List<Header>,
    val method: String,
    val url: Url
)