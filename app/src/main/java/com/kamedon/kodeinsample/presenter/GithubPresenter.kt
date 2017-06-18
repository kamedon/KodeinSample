package com.kamedon.kodeinsample.presenter

import com.kamedon.kodeinsample.repository.GithubRepository
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


/**
 * Created by kamei.hidetoshi on 2017/06/18.
 */
interface GithubView {
    fun showError(e: Throwable)
    fun showUser(user: String)
    fun notFoundUser()
}

class GithubPresenter(val view: GithubView, val repository: GithubRepository) {
    fun search(user: String) = launch(UI) {
        try {
            val response = repository.user(user).await()
            if (response.body() == null) {
                view.notFoundUser()
                return@launch
            }
            response.body()?.run {
                view.showUser("$id:$name")
            }
        } catch (e: Throwable) {
            view.showError(e)
            e.printStackTrace()
        }
    }

}
