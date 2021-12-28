package com.example.maksymspasybindemo.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductNamePresentationModel(
    val name: String
) : Parcelable
