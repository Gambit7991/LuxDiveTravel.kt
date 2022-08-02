package com.example.domain.domain.models

open class Product(
    val name: String,
    val about: String,
    val id: Int,
    val mainPicture: String,
    val pictureList: ArrayList<String>
)