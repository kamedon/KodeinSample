package com.kamedon.kodeinsample.ui.page

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.kamedon.kodeinsample.R
import com.kamedon.kodeinsample.databinding.ActivityMvpBinding
import com.kamedon.kodeinsample.presenter.GithubPresenter
import com.kamedon.kodeinsample.presenter.GithubView
import com.kamedon.kodeinsample.util.kodein

class MVPActivity : AppCompatActivity(), GithubView {
    override fun showError(e: Throwable) {
        binding.nameText.text = "error: ${e.message}"
    }

    override fun showUser(user: String) {
        binding.nameText.text = user
    }

    override fun notFoundUser() {
        binding.nameText.text = "not found"
    }

    val injector: KodeinInjector = KodeinInjector()

    val binding by lazy {
        DataBindingUtil.setContentView<ActivityMvpBinding>(this, R.layout.activity_mvp)
    }

    val presenter: GithubPresenter by injector.instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(Kodein {
            extend(kodein)
            bind<GithubView>() with instance(this@MVPActivity)
        })
        binding.searchBtn.setOnClickListener {
            presenter.search(binding.userEdit.text.toString())
        }
    }
}
