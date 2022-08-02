package com.example.data.models

import com.example.domain.domain.models.Boat
import com.example.domain.domain.models.Product

class DataCountry (
    name: String,
    about: String,
    id: Int,
    picture: String,
    pictureList: ArrayList<String>,
    boatList: ArrayList<Boat>
) :
    Product(name, about, id, picture, pictureList)