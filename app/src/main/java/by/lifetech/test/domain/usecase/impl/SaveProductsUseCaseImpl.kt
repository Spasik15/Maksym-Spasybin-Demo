package by.lifetech.test.domain.usecase.impl

import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.usecase.api.SaveProductsUseCase
import by.lifetech.test.domain.repository.ProductRepository

class SaveProductsUseCaseImpl(
    private val repository: ProductRepository
) : SaveProductsUseCase {

    override suspend fun execute(productList: List<ProductDomainModel>) {
        repository.saveProducts(productList)
    }
}
