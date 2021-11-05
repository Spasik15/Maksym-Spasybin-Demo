package by.lifetech.test.presentation.screen.first

import by.lifetech.test.R
import by.lifetech.test.databinding.FragmentFirstBinding
import by.lifetech.test.presentation.base.BaseFragment
import by.lifetech.test.presentation.model.ProductNamePresentationModel
import by.lifetech.test.utils.viewbinding.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : BaseFragment<FragmentFirstBinding, FirstViewModel>(
    R.layout.fragment_first
) {

    override val binding by viewBinding({
        FragmentFirstBinding.bind(it)
    })

    override val viewModel by viewModel<FirstViewModel>()

    private val adapter: ProductsAdapter by lazy {
        ProductsAdapter(
            onProductItemClickAction()
        )
    }

    override fun setUpView() {
        binding.recyclerView.adapter = adapter
    }

    override fun observeViewModel() {
        with(viewModel) {
            productListDataState.listenValue {
                adapter.submitList(it)
            }
        }
    }

    private fun onProductItemClickAction(): (ProductNamePresentationModel) -> Unit = {
        navigateToSecondFragment(it)
    }

    // Should be wrapped with router class in big projects
    private fun navigateToSecondFragment(data: ProductNamePresentationModel) {
        FirstFragmentDirections.actionFirstFragmentToSecondFragment(
            data
        ).go()
    }

}
