package com.nablet.goals.utils

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("dateCreatedFormatted")
fun TextView.setDateCreated(dateCreatedMillis: Long) {
	text = dateCreatedMillis.convertTimeMillisToFormat()
}

@BindingAdapter("onLongClick")
fun View.setLongClick(func: () -> Unit) {
	this.setOnLongClickListener {
		func()
		return@setOnLongClickListener true
	}
}
