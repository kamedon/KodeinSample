package com.kamedon.kodeinsample.repository

import com.kamedon.kodeinsample.api.GithubApi
import com.kamedon.kodeinsample.entity.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import ru.gildor.coroutines.retrofit.await

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

interface GithubRepository {
    fun user(user: String): Deferred<User>
}

class GithubRepositoryImpl(val api: GithubApi) : GithubRepository {
    override fun user(user: String) = async(CommonPool) {
        api.user(user).await()
    }
}
