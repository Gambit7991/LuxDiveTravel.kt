package com.example.luxdivetravel.di.koin

import com.example.domain.domain.useCases.GetDestinationListUseCase
import com.example.domain.domain.useCases.SendContactFormUseCase
import org.koin.dsl.module


val domainModule = module{
    factory{
        GetDestinationListUseCase(countryRepository = get())
    }
    factory {
        SendContactFormUseCase()
    }
}