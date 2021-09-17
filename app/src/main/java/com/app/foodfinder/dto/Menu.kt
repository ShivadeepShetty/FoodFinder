package com.app.foodfinder.dto

data class Menu(
    val menus: List<MenuX>
)

data class MenuX(
    val categories: List<Category>,
    val restaurantId: Int
)

data class Category(
    val id: String,
    val menuitems: List<Menuitem>,
    val name: String
)

data class Menuitem(
    val description: String,
    val id: String,
    val images: List<Any>,
    val name: String,
    val price: String
)