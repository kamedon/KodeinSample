package com.kamedon.kodeinsample.ui.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.kamedon.kodeinsample.BR
import com.kamedon.kodeinsample.repository.GithubRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

class GithubViewModel(val repository: GithubRepository) : BaseObservable() {
    @Bindable
    var user: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.user)
        }

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    fun onClickSearch() = launch(UI) {
        try {
            val response = repository.user(user).await()
            if (response.body() == null) {
                name = ""
                return@launch
            }
            response.body()?.run {
                this@GithubViewModel.name = "$id:$name"
            }
        } catch (e: Throwable) {
            name = e.message ?: "error"
            e.printStackTrace()
        }
    }
}