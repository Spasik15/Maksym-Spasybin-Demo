package com.example.maksymspasybindemo.utils.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

private class FragmentViewBindingPropertyDelegate<F : Fragment, T : ViewBinding>(
    viewBinder: (F) -> T
) : ViewBindingPropertyDelegate<F, T>(viewBinder) {

    override fun getLifecycleOwner(thisRef: F) = thisRef.viewLifecycleOwner
}

/**
 * It creates a new property with viewBinding [T] for the fragment [F]
 *
 * @param viewBinder creates viewBinding from [F]
 */
fun <F : Fragment, T : ViewBinding> viewBinding(viewBinder: (F) -> T): ViewBindingPropertyDelegate<F, T> {
    return FragmentViewBindingPropertyDelegate(viewBinder)
}

/**
 * It creates a new property with viewBinding [T] for the fragment [F]
 *
 * @param viewBindingFactory creates viewBinding from [F]
 * @param viewProvider gets [View] from the fragment. It uses [Fragment.requireView] by default
 */
@JvmName("viewBindingFragment")
inline fun <F : Fragment, T : ViewBinding> Fragment.viewBinding(
    crossinline viewBindingFactory: (View) -> T,
    crossinline viewProvider: (F) -> View = Fragment::requireView
): ViewBindingPropertyDelegate<F, T> {
    return viewBinding { fragment: F -> viewBindingFactory(viewProvider(fragment)) }
}
