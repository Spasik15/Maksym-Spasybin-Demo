package com.example.maksymspasybindemo.utils.presentation

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView?.withGlide(url: String) = this?.apply {
    Glide.with(context)
        .load(Uri.parse(url))
        .timeout(60000)
        .into(this)
}
