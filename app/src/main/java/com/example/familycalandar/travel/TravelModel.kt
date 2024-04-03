package com.example.familycalandar.travel

data class TravelModel(
    val nom: String,
    val budget: String,
    val details: List<TravelDetailsModel>
)
