package com.example.maksymspasybindemo.data.db.mapper

import com.example.maksymspasybindemo.data.db.model.ProductDataBaseModel
import com.example.maksymspasybindemo.domain.model.ProductDomainModel

fun List<ProductDataBaseModel>.toDomain(): List<ProductDomainModel> = this.map {
    ProductDomainModel(
        id = it.id,
        name = it.name,
        imageUrl = it.imageUrl,
        price = it.price,
    )
}
