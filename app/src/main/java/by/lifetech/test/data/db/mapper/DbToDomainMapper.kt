package by.lifetech.test.data.db.mapper

import by.lifetech.test.data.db.model.ProductDataBaseModel
import by.lifetech.test.domain.model.ProductDomainModel

fun List<ProductDataBaseModel>.toDomain(): List<ProductDomainModel> = this.map {
    ProductDomainModel(
        id = it.id,
        name = it.name,
        imageUrl = it.imageUrl,
        price = it.price,
    )
}
