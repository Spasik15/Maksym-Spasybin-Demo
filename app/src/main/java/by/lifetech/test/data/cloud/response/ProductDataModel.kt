package by.lifetech.test.data.cloud.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDataModel(
    @SerializedName("product_id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val imageUrl: String?,
    @SerializedName("price")
    val price: Int?
) : Parcelable
