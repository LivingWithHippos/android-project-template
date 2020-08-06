package com.github.livingwithhippos.androidtemplate.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageURL")
fun ImageView.loadImage(imageURL: String?) {
    if (imageURL != null)
        Glide.with(this.context)
            .load(imageURL)
            .into(this)
}