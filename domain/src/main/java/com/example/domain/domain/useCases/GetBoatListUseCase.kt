package com.example.domain.domain.useCases

import com.example.domain.domain.models.Boat
import com.example.domain.domain.repository.BoatRepository

class GetBoatListUseCase(private val boatRepository: BoatRepository) {

    fun execute(): ArrayList<Boat> {
        return boatRepository.getBoatList()

    }
}