package by.lifetech.test.domain.usecase.impl

import by.lifetech.test.domain.repository.ProductRepository
import by.lifetech.test.domain.usecase.api.ProductsDataUseCase

class ProductsDataUseCaseImpl(
    private val repository: ProductRepository
) : ProductsDataUseCase {

    override fun execute() = repository.productsDataFlow
}
