package ru.otus.daggerhomework

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : FragmentActivity(), MainActivityComponentProvider {
    private lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        component = DaggerMainActivityComponent.factory().build(application.component)

    }

    override fun provideMainActivityComponent(): MainActivityComponent = component
}

interface MainActivityComponentProvider {
    fun provideMainActivityComponent(): MainActivityComponent
}