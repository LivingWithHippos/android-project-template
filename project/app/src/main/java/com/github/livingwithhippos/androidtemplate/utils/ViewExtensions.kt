package com.github.livingwithhippos.androidtemplate.utils

import android.widget.Button
import android.widget.ImageButton


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