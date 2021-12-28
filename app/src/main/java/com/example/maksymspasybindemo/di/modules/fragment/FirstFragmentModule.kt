package com.example.maksymspasybindemo.di.modules.fragment

import com.example.maksymspasybindemo.domain.usecase.api.ProductsDataUseCase
import com.example.maksymspasybindemo.domain.usecase.impl.ProductsDataUseCaseImpl
import com.example.maksymspasybindemo.presentation.screen.first.FirstFragment
import com.example.maksymspasybindemo.presentation.screen.first.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.scoped

val firstFragmentModule = module {

    scope<FirstFragment> {

        scoped<ProductsDataUseCaseImpl>() bind ProductsDataUseCase::class

        viewModel { FirstViewModel(get()) }
    }
}
