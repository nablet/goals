package com.nablet.goals.utils

import java.text.SimpleDateFormat
import java.util.*


fun Long.convertTimeMillisToFormat(format: String = "dd/MM/yy"): String {
	val formatter = SimpleDateFormat(format, Locale.getDefault())
	return formatter.format(Date(this))
}
