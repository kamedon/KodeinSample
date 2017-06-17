package com.kamedon.kodeinsample.repository

import com.kamedon.kodeinsample.api.GithubApi
import com.kamedon.kodeinsample.entity.User

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

interface GitubRepository {
    fun user(user: String)
}

class GitubRepositoryImpl(val api: GithubApi) : GitubRepository {
    override fun user(user: String) {
    }
}
