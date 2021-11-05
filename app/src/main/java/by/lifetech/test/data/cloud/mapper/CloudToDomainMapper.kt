package by.lifetech.test.data.cloud.mapper

import by.lifetech.test.data.cloud.response.ProductResponseDataModel
import by.lifetech.test.domain.model.ProductDomainModel

fun ProductResponseDataModel?.toDomain(): List<ProductDomainModel> = ArrayList<ProductDomainModel>().apply {
    this@toDomain?.productList?.forEach { product ->
        product?.let {
            if (it.id != null && it.name != null && it.imageUrl != null && it.price != null) add(
                ProductDomainModel(
                    id = it.id.toInt(),
                    name = it.name.orEmpty(),
                    imageUrl = it.imageUrl.orEmpty(),
                    price = it.price,
                )
            )
        }
    }
}
