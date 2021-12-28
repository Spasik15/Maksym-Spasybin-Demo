package com.example.maksymspasybindemo.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.core.scope.Scope

abstract class BaseFragment<VIEW_BINDING : ViewBinding, VIEW_MODEL : ViewModel>(
    @LayoutRes layout: Int
) : Fragment(layout), AndroidScopeComponent {

    override val scope: Scope by fragmentScope()

    protected abstract val binding: VIEW_BINDING

    protected abstract val viewModel: VIEW_MODEL

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        observeViewModel()
    }

    protected abstract fun setUpView()

    protected open fun observeViewModel() = Unit

    override fun onDestroyView() {
        clear()
        super.onDestroyView()
    }

    // clear all dependencies or view links in case of interrupted animation with navigation
    protected open fun clear() = Unit

    protected fun <T> Flow<T>.listenValue(action: suspend (T) -> Unit) {
        onEach { action.invoke(it) }
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .launchIn(lifecycleScope)
    }

    protected fun NavDirections.go() = findNavController().navigate(this)

    protected fun pop() = findNavController().popBackStack()
}
