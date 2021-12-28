package by.lifetech.test.domain.repository

import by.lifetech.test.domain.model.ProductDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

/**
 * Main repository for calling REST-api
 */
interface ProductRepository {

    val productsDataFlow: Flow<List<ProductDomainModel>>

    suspend fun saveProducts(productList: List<ProductDomainModel>)

//    suspend fun fetchProducts()
}
