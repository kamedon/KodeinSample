package com.kamedon.kodeinsample

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.*
import com.kamedon.kodeinsample.di.NetworkModule
import com.kamedon.kodeinsample.di.PresentationModule

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        bind<Context>() with instance(this@App)
        import(NetworkModule.module)
        import(PresentationModule.module)
    }
}
