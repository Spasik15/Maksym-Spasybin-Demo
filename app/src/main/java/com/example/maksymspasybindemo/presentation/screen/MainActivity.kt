package com.example.maksymspasybindemo.presentation.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.maksymspasybindemo.data.cloud.mapper.toDomain
import com.example.maksymspasybindemo.data.cloud.response.ProductResponseDataModel
import com.example.maksymspasybindemo.databinding.ActivityMainBinding
import com.example.maksymspasybindemo.presentation.screen.MainViewModel.Companion.FILE_PATH
import com.example.maksymspasybindemo.utils.presentation.readAssetsFile
import com.google.gson.Gson
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class MainActivity : AppCompatActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

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
