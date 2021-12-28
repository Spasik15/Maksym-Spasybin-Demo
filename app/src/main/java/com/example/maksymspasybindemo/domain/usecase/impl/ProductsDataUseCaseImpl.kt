package com.example.maksymspasybindemo.domain.usecase.impl

import com.example.maksymspasybindemo.domain.repository.ProductRepository
import com.example.maksymspasybindemo.domain.usecase.api.ProductsDataUseCase

class ProductsDataUseCaseImpl(
    private val repository: ProductRepository
) : ProductsDataUseCase {

    override fun execute() = repository.productsDataFlow
}
