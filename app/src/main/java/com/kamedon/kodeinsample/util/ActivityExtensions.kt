package com.kamedon.kodeinsample.util

import android.app.Activity

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

val Activity.kodein get() = (application as com.kamedon.kodeinsample.App).kodein