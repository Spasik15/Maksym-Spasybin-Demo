package by.lifetech.test.di.modules.fragment

import by.lifetech.test.domain.usecase.api.FetchProductsUseCase
import by.lifetech.test.domain.usecase.api.ProductsDataUseCase
import by.lifetech.test.domain.usecase.impl.FetchProductsUseCaseImpl
import by.lifetech.test.domain.usecase.impl.ProductsDataUseCaseImpl
import by.lifetech.test.presentation.screen.first.FirstFragment
import by.lifetech.test.presentation.screen.first.FirstViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.scoped

val firstFragmentModule = module {

    scope<FirstFragment> {

        scoped<FetchProductsUseCaseImpl>() bind FetchProductsUseCase::class
        scoped<ProductsDataUseCaseImpl>() bind ProductsDataUseCase::class

        viewModel { FirstViewModel(get(), get()) }
    }
}
