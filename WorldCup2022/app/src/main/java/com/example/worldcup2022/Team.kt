package com.example.worldcup2022

data class Team(
    val name: String,
    val flagUrl: String,
    val group: String,
    val players: List<String>,
    val coach: String
)