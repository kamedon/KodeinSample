package com.kamedon.kodeinsample.ui.page

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kamedon.kodeinsample.R
import com.kamedon.kodeinsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.githubBtn.setOnClickListener {
            startActivity(Intent(applicationContext, MVVMActivity::class.java))
        }
    }
}
