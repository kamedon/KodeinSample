package com.kamedon.kodeinsample.ui.page

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.instance
import com.kamedon.kodeinsample.R
import com.kamedon.kodeinsample.databinding.ActivityMvvmBinding
import com.kamedon.kodeinsample.ui.viewmodel.GithubViewModel
import com.kamedon.kodeinsample.util.kodein

class MVVMActivity : AppCompatActivity() {

    val injector: KodeinInjector = KodeinInjector()

    val binding by lazy {
        DataBindingUtil.setContentView<ActivityMvvmBinding>(this, R.layout.activity_mvvm)
    }

    val viewModel: GithubViewModel by injector.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(Kodein {
            extend(kodein)
        })
        binding.model = viewModel
    }
}
