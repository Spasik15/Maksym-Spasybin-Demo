package by.lifetech.test.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDomainModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val price: Int
) : Parcelable
