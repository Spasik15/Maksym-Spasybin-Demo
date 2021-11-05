package by.lifetech.test.di.modules

import android.app.Application
import androidx.room.Room
import by.lifetech.test.data.db.TurkcellDataBase
import by.lifetech.test.data.db.dao.ProductsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBaseModule = module {

    single { provideDataBase(androidApplication()) }

    single { provideCatalogDao(get()) }
}

private const val DATA_BASE_NAME = "ucoinDataBase"

private fun provideDataBase(application: Application): TurkcellDataBase =
    Room.databaseBuilder(
        application,
        TurkcellDataBase::class.java,
        DATA_BASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()

fun provideCatalogDao(database: TurkcellDataBase): ProductsDao = database.productDao
