package com.example.luxdivetravel.di.koin

import com.example.data.repository.CountryRepositoryImpl
import com.example.domain.domain.repository.CountryRepository
import org.koin.dsl.module


val dataModule = module{
    single<CountryRepository> {
        CountryRepositoryImpl()
    }
}