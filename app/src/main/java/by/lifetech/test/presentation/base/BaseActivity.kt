package by.lifetech.test.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

abstract class BaseActivity : AppCompatActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    protected fun <T> Flow<T>.listenValue(action: suspend (T) -> Unit) {
        onEach { action.invoke(it) }
            .launchIn(lifecycleScope)
    }
}
