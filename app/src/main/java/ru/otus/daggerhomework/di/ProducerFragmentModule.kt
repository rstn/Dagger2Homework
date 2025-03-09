package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module
class ProducerFragmentModule {

    @Provides
    @FragmentScope
    fun colorGenerator(): ColorGenerator = ColorGeneratorImpl()
}