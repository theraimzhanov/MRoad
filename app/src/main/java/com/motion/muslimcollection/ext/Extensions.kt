package com.motion.muslimcollection.ext

import android.content.Context
import android.text.SpannableString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadImage(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}
fun Context.getFormattedTime(
    passedSeconds: Int,
): SpannableString {
    val hours = (passedSeconds / 3600) % 24
    val minutes = (passedSeconds / 60) % 60
    val seconds = passedSeconds % 60

    val formattedTime = formatTime(hours, minutes, seconds)
    return SpannableString(formattedTime)
}

fun formatTime(hours: Int, minutes: Int, seconds: Int): String {
    val hoursFormat = "%02d"
    var format = "$hoursFormat:%02d"

    format += ":%02d"
    return String.format(format, hours, minutes, seconds)
}
fun String.removeLastSeconds(): String = this.substring(IntRange(0, this.length - 4))

fun getCurrentDate(): String? {
    val date = SimpleDateFormat("EEE, d MMM ''yy", Locale.getDefault())
    return date.format(Date())
}



fun Context.showMessage(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.INVISIBLE
    }

var View.invisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value) View.GONE else View.VISIBLE
    }
interface ItemClickListener {
    fun onItemClick(position: Int)
}