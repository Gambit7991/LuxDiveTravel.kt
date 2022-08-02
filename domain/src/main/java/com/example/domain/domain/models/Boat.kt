package com.example.domain.domain.models

class Boat(name: String,
           about: String,
           id: Int,
           picture: String,
           pictureList: ArrayList<String>) :
    Product(name, about, id, picture, pictureList)