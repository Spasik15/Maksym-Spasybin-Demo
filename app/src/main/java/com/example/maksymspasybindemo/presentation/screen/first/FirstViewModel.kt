package com.example.maksymspasybindemo.presentation.screen.first

import androidx.lifecycle.ViewModel
import com.example.maksymspasybindemo.domain.model.ProductDomainModel
import com.example.maksymspasybindemo.domain.usecase.api.ProductsDataUseCase
import kotlinx.coroutines.flow.Flow

class FirstViewModel(
    productsDataUseCase: ProductsDataUseCase
) : ViewModel() {

    val productListDataState: Flow<List<ProductDomainModel>> = productsDataUseCase.execute()

}
