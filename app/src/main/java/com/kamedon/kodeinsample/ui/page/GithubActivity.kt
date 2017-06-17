package com.kamedon.kodeinsample.ui.page

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kamedon.kodeinsample.R
import com.kamedon.kodeinsample.databinding.ActivityGithubBinding

class GithubActivity : AppCompatActivity() {

    val binding by lazy {
        DataBindingUtil.setContentView<ActivityGithubBinding>(this, R.layout.activity_github)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}
