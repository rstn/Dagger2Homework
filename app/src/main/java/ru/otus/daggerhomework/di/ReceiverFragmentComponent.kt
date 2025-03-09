package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ReceiverFragment
import ru.otus.daggerhomework.ReceiverViewModel

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class, ApplicationComponent::class]
)
interface ReceiverFragmentComponent {

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance
            contextActivity: Context,
            @BindsInstance
            fragment: ReceiverFragment,
            appComponent: ApplicationComponent,
            mainActivityComponent: MainActivityComponent,
        ): ReceiverFragmentComponent
    }

    fun producerVM(): ReceiverViewModel
}