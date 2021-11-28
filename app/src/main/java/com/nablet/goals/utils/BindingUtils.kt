package com.nablet.goals.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("dateCreatedFormatted")
fun TextView.setDateCreated(dateCreatedMillis: Long) {
	text = dateCreatedMillis.convertTimeMillisToFormat()
}
