package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    private val colorObserver: ColorObserver,
    private val context: Context,
    private val receiverFragment: ReceiverFragment,
) {

    fun observeColors(lifecycleOwner: LifecycleOwner) {
        if (context !is Application) throw RuntimeException("Application context is required")
        lifecycleOwner.lifecycleScope.launch {
            colorObserver.colorFlow.collect {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                receiverFragment.populateColor(it)
            }
        }
    }
}