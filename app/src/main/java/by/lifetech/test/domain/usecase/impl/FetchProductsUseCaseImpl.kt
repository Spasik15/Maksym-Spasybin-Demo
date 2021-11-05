package by.lifetech.test.domain.usecase.impl

import by.lifetech.test.domain.repository.ProductRepository
import by.lifetech.test.domain.usecase.api.FetchProductsUseCase

class FetchProductsUseCaseImpl(
    private val repository: ProductRepository
) : FetchProductsUseCase {

    override suspend fun execute() {
        repository.fetchProducts()
    }
}
