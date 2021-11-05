package by.lifetech.test.presentation.screen.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.usecase.api.FetchProductsUseCase
import by.lifetech.test.domain.usecase.api.ProductsDataUseCase
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class FirstViewModel(
    private val fetchProductsUseCase: FetchProductsUseCase,
    productsDataUseCase: ProductsDataUseCase
) : ViewModel() {

    val productListDataState: SharedFlow<List<ProductDomainModel>> = productsDataUseCase.execute()

    init {
        viewModelScope.launch {
            fetchProductsUseCase.execute()
        }
    }

}
