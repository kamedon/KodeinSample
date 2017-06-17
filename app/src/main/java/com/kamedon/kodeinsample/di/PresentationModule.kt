package com.kamedon.kodeinsample.di

import com.github.salomonbrys.kodein.*
import com.kamedon.kodeinsample.ui.viewmodel.GithubViewModel

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

object PresentationModule {
    val module = Kodein.Module {
        bind<GithubViewModel>() with provider {
            GithubViewModel(instance())
        }
    }
}
