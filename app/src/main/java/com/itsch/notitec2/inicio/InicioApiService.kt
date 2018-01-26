package com.itsch.notitec2.inicio

import com.itsch.notitec2.Routes.BASE_URL
import com.itsch.notitec2.Routes.GET_POSTS
import io.reactivex.Observable
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Isma-Developer on 1/26/2018.
 */
interface InicioApiService {
    @GET(GET_POSTS)
    fun getPosts(): Observable<PostResponse>

    companion object {
        fun create(): InicioApiService {
                val retrofit = Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build()
                return retrofit.create(InicioApiService::class.java)

            }
    }
}