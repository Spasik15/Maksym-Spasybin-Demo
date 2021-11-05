package by.lifetech.test.utils.presentation

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import by.lifetech.test.utils.weak

fun View.clickAction(action: (View) -> Unit) {
    clickActionDelayed(delayBefore = 0, action = action)
}

fun View.clickActionDelayed(
    delayBefore: Long = 80,
    enableAfter: Long = 300,
    action: (View) -> Unit
) {
    setOnClickListener(
        object : View.OnClickListener {
            private var enabled = true

            override fun onClick(v: View) {
                val weakAction by weak(action)
                if (enabled) {
                    enabled = false
                    postDelayed(
                        {
                            weakAction?.invoke(v)
                            postDelayed({ enabled = true }, enableAfter)
                        },
                        delayBefore
                    )
                }
            }
        }
    )
}

fun View?.show() {
    this?.visibility = View.VISIBLE
}

fun View?.hide() {
    this?.visibility = View.GONE
}

fun View.hideIf(predicate: () -> Boolean) = if (predicate()) hide() else show()

fun View?.toInvisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.isHidden(): Boolean = this?.isShown?.not() ?: false

fun EditText.addOnTextChangedListener(listener: (String) -> Unit) = object : TextWatcher {
    override fun afterTextChanged(s: Editable?) = Unit
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = listener(s.toString())
}.apply {
    addTextChangedListener(this)
}

/** Int dp size to px size. */
internal fun Context.dp2Px(dp: Int): Int = this.dp2Px(dp.toFloat()).toInt()

/** Float dp size to px size. */
internal fun Context.dp2Px(dp: Float): Float {
    val scale = resources.displayMetrics.density
    return (dp * scale)
}
