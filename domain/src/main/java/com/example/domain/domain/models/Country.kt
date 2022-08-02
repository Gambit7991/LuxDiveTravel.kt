package com.example.domain.domain.models

class Country(
    name: String,
    about: String,
    id: Int,
    picture: String,
    pictureList: ArrayList<String>,
    boatList: ArrayList<Boat>
) :
    Product(name, about, id, picture, pictureList)