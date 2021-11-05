package by.lifetech.test.di.modules.fragment

import by.lifetech.test.presentation.screen.second.SecondFragment
import by.lifetech.test.presentation.screen.second.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val secondFragmentModule = module {

    scope<SecondFragment> {

        viewModel {
            SecondViewModel()
        }
    }
}
