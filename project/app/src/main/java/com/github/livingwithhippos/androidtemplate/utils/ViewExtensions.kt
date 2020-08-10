package com.github.livingwithhippos.androidtemplate.utils

import android.graphics.drawable.Animatable
import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


/** Milliseconds used for UI animations */
const val ANIMATION_FAST_MILLIS = 50L
const val ANIMATION_SLOW_MILLIS = 100L

/**
 * Simulate a button click, including a small delay while it is being pressed to trigger the
 * appropriate animations.
 */
fun ImageButton.simulateClick(delay: Long = ANIMATION_FAST_MILLIS) {
    performClick()
    isPressed = true
    invalidate()
    postDelayed({
        invalidate()
        isPressed = false
    }, delay)
}

/**
 * Simulate a button animation effect.
 */
fun Button.simulateAnimation(delay: Long = ANIMATION_SLOW_MILLIS) {
    isPressed = true
    invalidate()
    postDelayed({
        invalidate()
        isPressed = false
    }, delay)
}

@BindingAdapter("startAnimation")
fun ImageView.startAnimation(start: Boolean) {
    if (drawable is Animatable) {
        if (start)
            (drawable as Animatable).start()
        else
            (drawable as Animatable).stop()
    }
}

@BindingAdapter("hrefSupport")
fun TextView.hrefSupport(support: Boolean) {
    if (support) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            text = Html.fromHtml(this.text as String?, Html.FROM_HTML_MODE_COMPACT)
        } else {
            text = Html.fromHtml(this.text as String?)
        }
        movementMethod = LinkMovementMethod.getInstance()
    }
}

@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}