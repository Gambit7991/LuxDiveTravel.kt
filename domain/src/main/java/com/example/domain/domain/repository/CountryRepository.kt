package com.example.domain.domain.repository

import com.example.domain.domain.models.Country

interface CountryRepository {

    fun getCountryList() : ArrayList<Country>

}