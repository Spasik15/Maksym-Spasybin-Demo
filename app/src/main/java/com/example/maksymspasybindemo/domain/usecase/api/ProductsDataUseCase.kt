package com.example.maksymspasybindemo.domain.usecase.api

import com.example.maksymspasybindemo.domain.model.ProductDomainModel
import kotlinx.coroutines.flow.Flow

/**
 * UseCase for getting products data
 */
interface ProductsDataUseCase {

    fun execute(): Flow<List<ProductDomainModel>>
}
