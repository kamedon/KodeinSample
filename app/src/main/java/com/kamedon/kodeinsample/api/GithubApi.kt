package com.kamedon.kodeinsample.api

import com.kamedon.kodeinsample.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */
interface GithubApi {
    @GET("users/{user}")
    fun user(@Path("user") user: String): Call<User>

}
