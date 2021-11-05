package by.lifetech.test.data.repository

import by.lifetech.test.data.db.dao.ProductsDao
import by.lifetech.test.data.db.mapper.toDbModel
import by.lifetech.test.data.db.mapper.toDomain
import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import timber.log.Timber

class ProductRepositoryImpl(
    private val productsDao: ProductsDao
) : ProductRepository {

    override val productsDataFlow = MutableSharedFlow<List<ProductDomainModel>>()

    override suspend fun saveProducts(productList: List<ProductDomainModel>) {
        runCatching {
            productList.toDbModel().let {
                productsDao.addProductList(it)
            }
        }.onFailure {
            Timber.e(it)
        }
    }

    override suspend fun fetchProducts() {
        runCatching {
            productsDao.getProducts().toDomain()
        }.onSuccess {
            productsDataFlow.emit(it)
        }.onFailure {
            Timber.e(it)
        }
    }
}
