package com.kamedon.kodeinsample.repository

import com.kamedon.kodeinsample.api.GithubApi
import com.kamedon.kodeinsample.entity.User
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import retrofit2.Call
import retrofit2.Response
import ru.gildor.coroutines.retrofit.await
import ru.gildor.coroutines.retrofit.awaitResponse

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

interface GitubRepository {
    fun user(user: String): Deferred<User>
}

class GitubRepositoryImpl(val api: GithubApi) : GitubRepository {
    override fun user(user: String) = async(CommonPool) {
        api.user(user).await()
    }
}
