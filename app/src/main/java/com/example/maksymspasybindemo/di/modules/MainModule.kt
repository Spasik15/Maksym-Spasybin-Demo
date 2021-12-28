package com.example.maksymspasybindemo.di.modules

import com.example.maksymspasybindemo.data.repository.ProductRepositoryImpl
import com.example.maksymspasybindemo.domain.repository.ProductRepository
import com.example.maksymspasybindemo.domain.usecase.api.SaveProductsUseCase
import com.example.maksymspasybindemo.domain.usecase.impl.SaveProductsUseCaseImpl
import com.example.maksymspasybindemo.presentation.screen.MainActivity
import com.example.maksymspasybindemo.presentation.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.scoped

val mainModule = module {

    single<ProductRepository> { ProductRepositoryImpl(get()) }

    scope<MainActivity> {

        scoped<SaveProductsUseCaseImpl>() bind SaveProductsUseCase::class

        viewModel { MainViewModel(get()) }
    }
}
