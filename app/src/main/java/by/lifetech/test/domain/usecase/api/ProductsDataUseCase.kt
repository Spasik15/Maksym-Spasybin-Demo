package by.lifetech.test.domain.usecase.api

import by.lifetech.test.domain.model.ProductDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

/**
 * UseCase for getting products data
 */
interface ProductsDataUseCase {

    fun execute(): Flow<List<ProductDomainModel>>
}
