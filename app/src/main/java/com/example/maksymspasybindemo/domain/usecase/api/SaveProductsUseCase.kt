package com.example.maksymspasybindemo.domain.usecase.api

import com.example.maksymspasybindemo.domain.model.ProductDomainModel

/**
 * UseCase for saving products
 */
interface SaveProductsUseCase {

    suspend fun execute(productList: List<ProductDomainModel>)
}
