package com.example.maksymspasybindemo.domain.usecase.impl

import com.example.maksymspasybindemo.domain.model.ProductDomainModel
import com.example.maksymspasybindemo.domain.usecase.api.SaveProductsUseCase
import com.example.maksymspasybindemo.domain.repository.ProductRepository

class SaveProductsUseCaseImpl(
    private val repository: ProductRepository
) : SaveProductsUseCase {

    override suspend fun execute(productList: List<ProductDomainModel>) {
        repository.saveProducts(productList)
    }
}
