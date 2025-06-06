package com.example.jsondraft

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

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

    // Sismos por id
    @GET("earthquakes/{eq_id}")
    fun getEarthquakeDetail(
        @Header("x-api-key") apiKey: String,
        @Path("eq_id") eqId: String
    ): Call<EarthquakeDetail>

    @GET("parameter_reports/{report_id}")
    fun getReporteDetalle(
        @Header("x-api-key") apiKey: String,
        @Path("report_id") reportId: Int
    ): Call<ReporteDetalle>

    @GET("parameter_reports/earthquake/{eq_id}")
    fun getReportesPorTerremoto(
        @Header("x-api-key") apiKey: String,
        @Path("eq_id") eqId: String
    ): Call<List<ReporteDetalle>>
}
