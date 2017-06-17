package com.kamedon.kodeinsample.ui.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.kamedon.kodeinsample.repository.GithubRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

class GithubViewModel(val repository: GithubRepository) : BaseObservable() {
    @Bindable
    var user: String = ""

    fun onClickSearch() = launch(UI) {
        repository.user(user).await()
    }
}