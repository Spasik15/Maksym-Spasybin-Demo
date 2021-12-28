package com.example.maksymspasybindemo.data.cloud.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductResponseDataModel(
    @SerializedName("products")
    val productList: List<ProductDataModel?>?
) : Parcelable
