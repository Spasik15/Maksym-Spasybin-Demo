package by.lifetech.test.di

import by.lifetech.test.core.TestApplication
import by.lifetech.test.di.modules.dataBaseModule
import by.lifetech.test.di.modules.fragment.firstFragmentModule
import by.lifetech.test.di.modules.fragment.secondFragmentModule
import by.lifetech.test.di.modules.mainModule

fun TestApplication.getModuleList() = listOf(
    dataBaseModule,
    mainModule
) + getFragmentModuleList()

private fun getFragmentModuleList() = listOf(
    firstFragmentModule,
    secondFragmentModule
)
