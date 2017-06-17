package com.kamedon.kodeinsample

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.kamedon.kodeinsample.di.NetworkModule

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

class App : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        import(NetworkModule.module)
    }

}
