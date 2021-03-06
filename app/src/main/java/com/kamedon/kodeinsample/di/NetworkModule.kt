package com.kamedon.kodeinsample.di

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.kamedon.kodeinsample.BuildConfig
import com.kamedon.kodeinsample.api.GithubApi
import com.kamedon.kodeinsample.repository.GithubRepository
import com.kamedon.kodeinsample.repository.GithubRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        bind<GithubRepository>() with singleton {
            GithubRepositoryImpl(instance())
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
            OkHttpClient.Builder().addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build()

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