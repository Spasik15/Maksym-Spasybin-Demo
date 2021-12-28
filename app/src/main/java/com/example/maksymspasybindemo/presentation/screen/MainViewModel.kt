package com.example.maksymspasybindemo.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maksymspasybindemo.domain.model.ProductDomainModel
import com.example.maksymspasybindemo.domain.usecase.api.SaveProductsUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val saveProductsUseCase: SaveProductsUseCase
) : ViewModel() {

    fun saveData(productProduct: List<ProductDomainModel>) {
        viewModelScope.launch {
            saveProductsUseCase.execute(productProduct)
        }
    }

    companion object {

        internal const val FILE_PATH = "products_list.json"
    }

}
