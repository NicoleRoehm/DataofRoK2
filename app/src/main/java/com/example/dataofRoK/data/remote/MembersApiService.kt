package com.example.dataofRoK.data.remote

import com.example.dataofRoK.data.model.Members
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://public.syntax-institut.de/apps/batch5/NicoleRoehm/"



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MembersApiService{

    @GET("data.json")
   suspend fun getMembers():List<Members>
}

object GotApi {

    val retrofitService: MembersApiService by lazy { retrofit.create(MembersApiService::class.java) }
}



