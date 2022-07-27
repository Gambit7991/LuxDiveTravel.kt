package com.example.domain.domain.useCases

import com.example.domain.domain.models.Country
import com.example.domain.domain.repository.CountryRepository

class GetDestinationListUseCase(private val countryRepository: CountryRepository) {

    fun execute(): ArrayList<Country> {
       return countryRepository.getCountryList()
    }
}