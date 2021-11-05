package by.lifetech.test.di.modules

import by.lifetech.test.data.repository.ProductRepositoryImpl
import by.lifetech.test.domain.repository.ProductRepository
import by.lifetech.test.domain.usecase.api.SaveProductsUseCase
import by.lifetech.test.domain.usecase.impl.SaveProductsUseCaseImpl
import by.lifetech.test.presentation.screen.MainActivity
import by.lifetech.test.presentation.screen.MainViewModel
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
