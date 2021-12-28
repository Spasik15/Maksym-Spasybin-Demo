package by.lifetech.test.data.repository

import by.lifetech.test.data.db.dao.ProductsDao
import by.lifetech.test.data.db.mapper.toDbModel
import by.lifetech.test.data.db.mapper.toDomain
import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.repository.ProductRepository
import kotlinx.coroutines.flow.map
import timber.log.Timber

class ProductRepositoryImpl(
    private val productsDao: ProductsDao
) : ProductRepository {

    override val productsDataFlow =
        productsDao.getProducts().map { it.toDomain() }

    override suspend fun saveProducts(productList: List<ProductDomainModel>) {
        runCatching {
            productList.toDbModel().let {
                productsDao.addProductList(it)
            }
        }.onFailure {
            Timber.e(it)
        }
    }

}
