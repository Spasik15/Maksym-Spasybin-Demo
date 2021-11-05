package by.lifetech.test.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.usecase.api.SaveProductsUseCase
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
