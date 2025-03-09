package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ColorObserver


@ActivityScope
@Component(
    modules = [ColorGeneratorFeatureModule::class],
    dependencies = [ApplicationComponent::class]
)
interface MainActivityComponent {

    @Component.Factory
    interface Factory {
        fun build(appComponent: ApplicationComponent): MainActivityComponent
    }

    fun colorObserver(): ColorObserver
}