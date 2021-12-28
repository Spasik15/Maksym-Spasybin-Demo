package com.example.maksymspasybindemo.presentation.screen.second

import androidx.navigation.fragment.navArgs
import com.example.maksymspasybindemo.R
import com.example.maksymspasybindemo.databinding.FragmentSecondBinding
import com.example.maksymspasybindemo.presentation.base.BaseFragment
import com.example.maksymspasybindemo.presentation.model.ProductNamePresentationModel
import com.example.maksymspasybindemo.utils.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SecondFragment : BaseFragment<FragmentSecondBinding, SecondViewModel>(
    R.layout.fragment_second
) {

    override val binding by viewBinding({
        FragmentSecondBinding.bind(it)
    })

    override val viewModel by viewModel<SecondViewModel>()

    private val args: SecondFragmentArgs by navArgs()
    private val argsData: ProductNamePresentationModel
        get() = args.productNamePresentationModel

    override fun setUpView() {
        binding.productNameTextView.text = argsData.name
    }

}