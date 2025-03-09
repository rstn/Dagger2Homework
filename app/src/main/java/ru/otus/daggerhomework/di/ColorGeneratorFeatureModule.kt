package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl

@Module
class ColorGeneratorFeatureModule {

    @Provides
    @ActivityScope
    fun colorObserver(): ColorObserver = ColorObserverImpl()
}