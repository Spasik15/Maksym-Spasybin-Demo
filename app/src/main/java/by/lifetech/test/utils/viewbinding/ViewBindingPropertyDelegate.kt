package by.lifetech.test.utils.viewbinding

import androidx.annotation.MainThread
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import by.lifetech.test.utils.handler.MainHandler
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class ViewBindingPropertyDelegate<in R : Any, T : ViewBinding>(
    private val viewBinder: (R) -> T
) : ReadOnlyProperty<R, T> {

    private var viewBinding: T? = null
    private val lifecycleObserver = ClearOnDestroyViewLifecycleObserver()
    private var thisRef: R? = null

    protected abstract fun getLifecycleOwner(thisRef: R): LifecycleOwner

    @MainThread
    override fun getValue(thisRef: R, property: KProperty<*>): T {
        viewBinding?.let { return it }

        this.thisRef = thisRef

        val lifecycle = getLifecycleOwner(thisRef).lifecycle
        val viewBinding = viewBinder(thisRef)

        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            MainHandler.runOnUiThread({ this.viewBinding = null })
        } else {
            lifecycle.addObserver(lifecycleObserver)
            this.viewBinding = viewBinding
        }
        return viewBinding
    }

    @MainThread
    fun clear() {
        val thisRef = thisRef ?: return
        this.thisRef = null

        getLifecycleOwner(thisRef).lifecycle.removeObserver(lifecycleObserver)

        MainHandler.runOnUiThread({ this.viewBinding = null })
    }

    @Suppress("unused", "UNUSED_PARAMETER")
    private inner class ClearOnDestroyViewLifecycleObserver : LifecycleObserver {

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy(owner: LifecycleOwner) {
            clear()
        }
    }
}
