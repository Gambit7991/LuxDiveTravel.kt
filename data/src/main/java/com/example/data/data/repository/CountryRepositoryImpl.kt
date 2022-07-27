package com.example.data.data.repository

import android.content.Context
import com.example.domain.domain.models.Country
import com.example.domain.domain.repository.CountryRepository

class CountryRepositoryImpl(private val context: Context) : CountryRepository {
    override fun getCountryList(): ArrayList<Country> {
        TODO("Not yet implemented")

    }
}