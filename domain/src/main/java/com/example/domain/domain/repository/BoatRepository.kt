package com.example.domain.domain.repository

import com.example.domain.domain.models.Boat

interface BoatRepository {
    fun getBoatList () : ArrayList<Boat>
}