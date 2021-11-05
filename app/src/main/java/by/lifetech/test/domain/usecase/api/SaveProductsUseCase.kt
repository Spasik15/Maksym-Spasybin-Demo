package by.lifetech.test.domain.usecase.api

import by.lifetech.test.domain.model.ProductDomainModel

/**
 * UseCase for saving products
 */
interface SaveProductsUseCase {

    suspend fun execute(productList: List<ProductDomainModel>)
}
