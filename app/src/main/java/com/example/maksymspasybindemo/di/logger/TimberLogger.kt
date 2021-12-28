package com.example.maksymspasybindemo.di.logger

import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE
import timber.log.Timber

/**
 * Koin Timber Logger
 * Use it as the optional logger parameter of startKoin{} in UcoinApplication
 */
class TimberLogger(
    private val showDebug: Boolean = true,
    private val showInfo: Boolean = true,
    private val showErr: Boolean = true,
    tag: String? = null
) : Logger() {

    /**
     * Tree used to print the messages, initialized by the construction
     */
    private val tree: Timber.Tree = if (tag === null) Timber.asTree() else Timber.tag(tag)

    private fun showDebug(msg: String) {
        if (showDebug) {
            tree.d(msg)
        }
    }

    private fun showErr(msg: String) {
        if (showErr) {
            tree.e(msg)
        }
    }

    private fun showInfo(msg: String) {
        if (showInfo) {
            tree.i(msg)
        }
    }

    override fun log(level: Level, msg: MESSAGE) {
        when (level) {
            Level.INFO -> showInfo(msg)
            Level.DEBUG -> showDebug(msg)
            Level.ERROR -> showErr(msg)
            Level.NONE -> {
                // Show nothing
            }
        }
    }
}
