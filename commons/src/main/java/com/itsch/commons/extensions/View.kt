package com.itsch.commons.extensions

import android.support.design.widget.Snackbar
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget

/**
 * Created by Isma-Developer on 1/26/2018.
 */

fun View.snack(message: String, length: Int = Snackbar.LENGTH_LONG) {
    val snack = Snackbar.make(this, message, length)
    snack.show()
}

fun ImageView.loadImage(url: String, placeHolder: Int = 0) {
    Glide.with(context)
            .load(url)
            .asBitmap()
            .placeholder(placeHolder)
            .error(placeHolder)
            .into(BitmapImageViewTarget(this))
}