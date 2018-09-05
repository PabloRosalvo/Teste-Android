package com.example.android.projetoteste
import io.reactivex.Observable
import retrofit2.http.GET

interface GetJson {
    @GET("data.json")
    fun getMovies() : Observable<PojoResponse>
}