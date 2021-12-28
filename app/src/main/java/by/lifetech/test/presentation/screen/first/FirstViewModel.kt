package by.lifetech.test.presentation.screen.first

import androidx.lifecycle.ViewModel
import by.lifetech.test.domain.model.ProductDomainModel
import by.lifetech.test.domain.usecase.api.ProductsDataUseCase
import kotlinx.coroutines.flow.Flow

class FirstViewModel(
    productsDataUseCase: ProductsDataUseCase
) : ViewModel() {

    val productListDataState: Flow<List<ProductDomainModel>> = productsDataUseCase.execute()

}
