package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorObserver: ColorObserver,
    private val context: Context
) {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorObserver.fireColorEvent(colorGenerator.generateColor())
    }
}