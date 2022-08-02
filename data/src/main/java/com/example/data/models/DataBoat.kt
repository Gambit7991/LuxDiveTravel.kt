package com.example.data.models

import com.example.domain.domain.models.Product

class DataBoat (name: String,
                about: String,
                id: Int,
                picture: String,
                pictureList: ArrayList<String>) :
    Product(name, about, id, picture, pictureList)