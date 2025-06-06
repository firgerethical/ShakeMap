package com.example.jsondraft

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("parameter_reports/")
    fun getReportes(
        @Header("x-api-key") apiKey: String
    ): Call<List<ReporteSismo>>

    //Teayendo Los sismos<id>

    @GET("earthquakes/")
    fun getEarthquakes(
        @Header("x-api-key") apiKey: String
    ): Call<List<Earthquake>>

}
