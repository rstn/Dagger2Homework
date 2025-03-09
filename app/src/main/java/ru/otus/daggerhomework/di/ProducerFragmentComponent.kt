package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ProducerViewModel

@FragmentScope
@Component(
    modules = [ProducerFragmentModule::class],
    dependencies = [MainActivityComponent::class, ApplicationComponent::class]
)
interface ProducerFragmentComponent {

    @Component.Factory
    interface Factory {
        fun build(
            @BindsInstance
            contextActivity: Context,
            appComponent: ApplicationComponent,
            mainActivityComponent: MainActivityComponent,
        ): ProducerFragmentComponent
    }

    fun colorGenerator(): ColorGenerator

    fun producerVM(): ProducerViewModel
}