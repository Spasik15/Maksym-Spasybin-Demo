package com.example.maksymspasybindemo.di

import com.example.maksymspasybindemo.core.TestApplication
import com.example.maksymspasybindemo.di.modules.dataBaseModule
import com.example.maksymspasybindemo.di.modules.fragment.firstFragmentModule
import com.example.maksymspasybindemo.di.modules.fragment.secondFragmentModule
import com.example.maksymspasybindemo.di.modules.mainModule

fun TestApplication.getModuleList() = listOf(
    dataBaseModule,
    mainModule
) + getFragmentModuleList()

private fun getFragmentModuleList() = listOf(
    firstFragmentModule,
    secondFragmentModule
)
