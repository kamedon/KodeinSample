package com.kamedon.kodeinsample

import android.app.Application
import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.kamedon.kodeinsample.di.NetworkModule
import com.kamedon.kodeinsample.di.PresentationModule

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        import(NetworkModule.module)
        import(PresentationModule.module)
    }

}
