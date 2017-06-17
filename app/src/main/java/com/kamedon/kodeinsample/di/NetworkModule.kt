package com.kamedon.kodeinsample.di

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.kamedon.kodeinsample.BuildConfig
import com.kamedon.kodeinsample.api.GithubApi
import com.kamedon.kodeinsample.repository.GitubRepository
import com.kamedon.kodeinsample.repository.GitubRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kamei.hidetoshi on 2017/06/17.
 */

object NetworkModule {
    val module = Kodein.Module {

        /*
         * Repository
         */
        bind<GitubRepository>() with singleton {
            GitubRepositoryImpl(instance())
        }

        /*
         * Api
         */
        bind<GithubApi>() with singleton {
            instance<Retrofit>().create(GithubApi::class.java)
        }

        /*
         * OkHttp Retrofit
         */
        bind<OkHttpClient>() with singleton {
            OkHttpClient.Builder().build()
        }

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .baseUrl(BuildConfig.GITHUB_ENDOPOINT)
                    .addConverterFactory(instance())
                    .client(instance()).build()
        }

        bind<Converter.Factory>() with singleton {
            GsonConverterFactory.create()
        }
    }

}