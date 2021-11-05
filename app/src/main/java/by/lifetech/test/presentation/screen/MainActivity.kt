package by.lifetech.test.presentation.screen

import android.os.Bundle
import by.lifetech.test.data.cloud.mapper.toDomain
import by.lifetech.test.data.cloud.response.ProductResponseDataModel
import by.lifetech.test.databinding.ActivityMainBinding
import by.lifetech.test.presentation.base.BaseActivity
import by.lifetech.test.presentation.screen.MainViewModel.Companion.FILE_PATH
import by.lifetech.test.utils.presentation.readAssetsFile
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {

        // We kinda mock api request here, thus it's the only place with connection to the data layer
        // + we wrap this logic with additional usecases for "presentation -> db" call
        // I prefer map and save api response immediately after loading data and then listen db changes from presentation layer
        val productList = Gson()
            .fromJson(assets.readAssetsFile(FILE_PATH), ProductResponseDataModel::class.java)
            .toDomain()
        viewModel.saveData(productList)
    }

}
