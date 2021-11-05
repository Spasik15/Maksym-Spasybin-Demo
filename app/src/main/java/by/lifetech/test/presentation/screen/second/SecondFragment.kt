package by.lifetech.test.presentation.screen.second

import androidx.navigation.fragment.navArgs
import by.lifetech.test.R
import by.lifetech.test.databinding.FragmentSecondBinding
import by.lifetech.test.presentation.base.BaseFragment
import by.lifetech.test.presentation.model.ProductNamePresentationModel
import by.lifetech.test.utils.viewbinding.viewBinding
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