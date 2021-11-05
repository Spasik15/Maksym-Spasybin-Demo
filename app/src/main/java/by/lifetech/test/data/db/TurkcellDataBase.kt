package by.lifetech.test.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import by.lifetech.test.data.db.dao.ProductsDao
import by.lifetech.test.data.db.model.ProductDataBaseModel

@Database(
    entities = [ProductDataBaseModel::class],
    version = 1,
    exportSchema = false
)
abstract class TurkcellDataBase : RoomDatabase() {

    abstract val productDao: ProductsDao
}
