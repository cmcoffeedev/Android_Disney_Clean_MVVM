package com.interview.disney.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.interview.disney.R
import com.squareup.picasso.Picasso

object CharacterItemBindingAdapters {

    @JvmStatic
    @BindingAdapter("app:loadImageWithPicasso")
    fun ImageView.loadImageUrl(imageUrl: String){
        Picasso.
        get()
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(this)
    }

}