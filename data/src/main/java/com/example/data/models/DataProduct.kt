package com.example.data.models

open class DataProduct (
    val name: String,
    val about: String,
    val id: Int,
    val mainPicture: String,
    val pictureList: ArrayList<String>
)