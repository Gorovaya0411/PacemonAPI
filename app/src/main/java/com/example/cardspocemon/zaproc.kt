package com.example.cardspocemon

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface zapros {
    @GET("cards")
    fun search(): Observable<card>

    companion object Factory {
        fun create(): zapros {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.pokemontcg.io/v1/")
                .build()

            return retrofit.create(zapros::class.java);
        }
    }

}