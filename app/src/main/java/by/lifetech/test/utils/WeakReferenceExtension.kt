package by.lifetech.test.utils

import java.lang.ref.WeakReference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * val weakSelf by weak(this)
 * listener({
 *  val self = weakThis?.let { it } ?: return@listener
 *  ...
 * })
 *
 * OR
 *
 * val weakSelf by weak(this)
 * listener({
 *  weakThis?.run {
 *   ...
 *  }
 * })
 * */

internal class WeakRef<T>(obj: T? = null) : ReadWriteProperty<Any?, T?> {

    private var wRef: WeakReference<T>?

    init {
        this.wRef = obj?.let { WeakReference(it) }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return wRef?.get()
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        wRef = value?.let { WeakReference(it) }
    }
}

internal fun <T> weak(obj: T? = null) = WeakRef(obj)
