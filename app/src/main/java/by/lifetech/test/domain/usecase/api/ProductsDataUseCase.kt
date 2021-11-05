package by.lifetech.test.domain.usecase.api

import by.lifetech.test.domain.model.ProductDomainModel
import kotlinx.coroutines.flow.SharedFlow

/**
 * UseCase for getting products data
 */
interface ProductsDataUseCase {

    fun execute(): SharedFlow<List<ProductDomainModel>>
}
