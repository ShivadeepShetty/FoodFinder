package com.app.foodfinder.dto

data class RestaurentResponse(
    val restaurants: List<Restaurant>
)

data class Restaurant(
    val address: String,
    val cuisine_type: String,
    val id: Int,
    val latlng: Latlng,
    val name: String,
    val neighborhood: String,
    val operating_hours: OperatingHours,
    val photograph: String,
    val reviews: List<Review>
)

data class Latlng(
    val lat: Double,
    val lng: Double
)

data class OperatingHours(
    val Friday: String,
    val Monday: String,
    val Saturday: String,
    val Sunday: String,
    val Thursday: String,
    val Tuesday: String,
    val Wednesday: String
)

data class Review(
    val comments: String,
    val date: String,
    val name: String,
    val rating: Int
)