package ercanduman.fcmmessagingdemo.util

import android.util.Log
import ercanduman.fcmmessagingdemo.BuildConfig

/**
 * Kotlin file that contains all utility functions.
 *
 * @author ercanduman
 * @since  21.09.2021
 */

/**
 * Prints log messages to console for DEBUG executions.
 *
 * @param message Debug logging message
 */
fun Any.logger(message: String? = "") {
    if (BuildConfig.DEBUG) Log.d(this.javaClass.name, "Debug logger: $message")
}