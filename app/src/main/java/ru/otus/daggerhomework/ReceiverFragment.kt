package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerReceiverFragmentComponent
import ru.otus.daggerhomework.di.ReceiverFragmentComponent

class ReceiverFragment : Fragment() {

    private lateinit var frame: View
    private lateinit var receiverFragmentComponent: ReceiverFragmentComponent
    private lateinit var receiverViewModel: ReceiverViewModel
    private var newBackgroundColor: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        receiverFragmentComponent = DaggerReceiverFragmentComponent.factory()
            .build(
                appComponent = (requireActivity() as MainMainActivity).application.component,
                mainActivityComponent = (requireActivity() as MainActivityComponentProvider).provideMainActivityComponent(),
                contextActivity = (requireActivity() as MainMainActivity).application,
                fragment = this,
            )
        receiverViewModel = receiverFragmentComponent.producerVM()
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        receiverViewModel.observeColors(this)
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
        newBackgroundColor = color
    }

    override fun onSaveInstanceState(outState: Bundle) {
        newBackgroundColor?.let {
            outState.putInt(BUNDLE_KEY_NEW_BACKGROUND_COLOR, it)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.getInt(BUNDLE_KEY_NEW_BACKGROUND_COLOR)?.let {
            populateColor(it)
        }
    }

    companion object {
        private const val BUNDLE_KEY_NEW_BACKGROUND_COLOR = "BUNDLE_KEY_NEW_BACKGROUND_COLOR"
    }
}