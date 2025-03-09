package ru.otus.daggerhomework

import android.app.Application
import ru.otus.daggerhomework.di.ApplicationComponent
import ru.otus.daggerhomework.di.DaggerApplicationComponent

class App : Application() {

    val component: ApplicationComponent = DaggerApplicationComponent.factory().build(this)
}

val Application.component: ApplicationComponent get() = (this as App).component