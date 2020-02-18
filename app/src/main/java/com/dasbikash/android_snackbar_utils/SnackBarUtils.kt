package com.dasbikash.android_snackbar_utils

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.dasbikash.android_snackbar_utils.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_CASE_IS_UPPER
import com.dasbikash.android_snackbar_utils.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_COLOR
import com.google.android.material.snackbar.Snackbar

/**
 * Helper class to display Snackbar.
 *
 * Snackbar can be launched using AppCompatActivity/Activity/Fragment/Any view.
 *
 * Extension function provided for calling from inside of AppCompatActivity/Activity/Fragment .
 *
 * When launched from/using AppCompatActivity/Activity/Fragment
 * Scackbar will be shown only if subject component is Resumed.
 *
 * Action text and corresponding action task can be added to Snackbar.
 * Action task will run on main thread.
 * Action text color and case can be customized.
 *
 * @author Bikash das(das.bikash.dev@gmail.com)
 *
 * */
class SnackBarUtils {

    companion object {

        internal val DEFAULT_ACTION_TEXT_COLOR = Color.MAGENTA
        internal val DEFAULT_ACTION_TEXT_CASE_IS_UPPER = false

        /**
         * Method to launch Short Snackbar using any view
         *
         * @param view | Subject View
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = showSnack(
            view, message, Snackbar.LENGTH_SHORT,
            actionText, action, actionTextColor, actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using any view
         *
         * @param view | Subject View
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) {
            view.context.applicationContext.apply {
                showSnack(
                    view, getString(messageId), Snackbar.LENGTH_SHORT,
                    actionText, action, actionTextColor, actionTextUpperCase
                )
            }
        }

        /**
         * Method to launch Long Snackbar using any view
         *
         * @param view | Subject View
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = showSnack(
            view, message, Snackbar.LENGTH_LONG,
            actionText, action, actionTextColor, actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using any view
         *
         * @param view | Subject View
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) {
            view.context.applicationContext.apply {
                showSnack(
                    view, getString(messageId), Snackbar.LENGTH_LONG,
                    actionText, action, actionTextColor, actionTextUpperCase
                )
            }
        }

        /**
         * Method to launch Short Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: Activity, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: Activity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: Activity, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: Activity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using AppCompatActivity
         *
         * @param activity | Subject AppCompatActivity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using AppCompatActivity
         *
         * @param activity | Subject AppCompatActivity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using AppCompatActivity
         *
         * @param activity | Subject AppCompatActivity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using AppCompatActivity
         *
         * @param activity | Subject AppCompatActivity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: () -> Any? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        private fun showSnack(
            view: View, message: String,
            duration: Int, actionText: CharSequence?, action: () -> Any?,
            @ColorInt actionTextColor: Int, actionTextUpperCase: Boolean
        ) {
            try {
                val snackbar = Snackbar.make(view, message, duration)
                actionText?.let {
                    setSnackbarAction(snackbar, it, action, actionTextColor, actionTextUpperCase)
                }
                runOnMainThread(task = {
                    snackbar.show()
                })
            } catch (ex: IllegalArgumentException) {
                runOnMainThread(task = {
                    Toast.makeText(
                        view.context, message, when {
                            duration == Snackbar.LENGTH_LONG -> Toast.LENGTH_LONG
                            else -> Toast.LENGTH_SHORT
                        }
                    ).show()
                })
            }
        }

        private fun setSnackbarAction(
            snackbar: Snackbar,
            actionText: CharSequence,
            action: () -> Any?,
            @ColorInt actionTextColor: Int,
            actionTextUpperCase: Boolean
        ) {
            snackbar
                .setAction(actionText) { runOnMainThread({ action() }) }
                .setActionTextColor(actionTextColor)
                .getView()
                .findViewById<TextView>(R.id.snackbar_action)
                .setAllCaps(actionTextUpperCase)
        }
    }
}

internal fun runOnMainThread(task: () -> Any?, delayMs: Long = 0L) {
    Handler(Looper.getMainLooper()).postDelayed({ task() }, delayMs)
}


internal fun Activity.runWithView(task:(View)->Any?){
    if (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            !isDestroyed
        } else {
            true
        }
    ) {
        findViewById<View>(android.R.id.content).let {
            runOnMainThread({task(it)})
        }
    }
}

internal fun AppCompatActivity.runWithView(task:(View)->Any?){
    if (lifecycle.currentState==Lifecycle.State.RESUMED) {
        findViewById<View>(android.R.id.content).let {
            runOnMainThread({task(it)})
        }
    }
}

internal fun Fragment.runWithView(task:(View)->Any?){
    if (lifecycle.currentState==Lifecycle.State.RESUMED) {
        view?.let {
            runOnMainThread({task(it)})
        }
    }
}

/**
 * Method to launch Short Snackbar using any view
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showShortSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)


/**
 * Method to launch Short Snackbar using any view
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showShortSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)


/**
 * Method to launch Long Snackbar using any view
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showLongSnack(
    message: String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase)


/**
 * Method to launch Long Snackbar using any view
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = SnackBarUtils.showLongSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase)


/**
 * Method to launch Short Snackbar from inside of Activity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Activity.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)


/**
 * Method to launch Short Snackbar from inside of Activity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Activity.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            SnackBarUtils.showShortSnack(
                it,
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

/**
 * Method to launch Long Snackbar from inside of Activity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Activity.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)


/**
 * Method to launch Long Snackbar from inside of Activity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Activity.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

/**
 * Method to launch Short Snackbar from inside of AppCompatActivity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)


/**
 * Method to launch Short Snackbar from inside of AppCompatActivity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

/**
 * Method to launch Long Snackbar from inside of AppCompatActivity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

/**
 * Method to launch Long Snackbar from inside of AppCompatActivity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

/**
 * Method to launch Short Snackbar from inside of Fragment
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

/**
 * Method to launch Short Snackbar from inside of Fragment
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}

/**
 * Method to launch Long Snackbar from inside of Fragment
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

/**
 * Method to launch Long Snackbar from inside of Fragment
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: () -> Any? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase
            )
        }
}