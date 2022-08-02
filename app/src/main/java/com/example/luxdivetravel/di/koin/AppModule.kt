package com.example.luxdivetravel.di.koin

import com.example.luxdivetravel.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel{
        MainViewModel(
            getDestinationListUseCase = get(),
            sendContactFormUseCase = get()
        )
    }
}