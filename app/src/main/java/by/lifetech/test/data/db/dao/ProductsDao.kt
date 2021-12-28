package by.lifetech.test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import by.lifetech.test.data.db.model.ProductDataBaseModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    /**
     * Method for adding all products in the list
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductList(list: List<ProductDataBaseModel>)

    /**
     * Method for getting products
     */
    @Query("SELECT * FROM productDataBaseModel")
    fun getProducts(): Flow<List<ProductDataBaseModel>>

}
