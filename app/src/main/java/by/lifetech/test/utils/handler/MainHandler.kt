package by.lifetech.test.utils.handler

import android.os.Handler
import android.os.Looper
import kotlin.math.max

object MainHandler {

    private val handler = Handler(Looper.getMainLooper())

    fun runOnUiThread(action: () -> Unit, delay: Long = 0): Runnable =
        Runnable { action() }.apply { runOnUiThread(this, delay) }

    fun post(action: () -> Unit): Runnable =
        Runnable { action() }.apply { post(this) }

    @JvmStatic
    @JvmOverloads
    fun runOnUiThread(action: Runnable, delay: Long = 0) {
        if (delay <= 0 && Thread.currentThread() == handler.looper.thread) {
            action.run()
        } else {
            handler.postDelayed(action, max(0, delay))
        }
    }

    @JvmStatic
    fun post(action: Runnable) = handler.post(action)

    @JvmStatic
    fun cancel(action: Runnable) = handler.removeCallbacks(action)
}
