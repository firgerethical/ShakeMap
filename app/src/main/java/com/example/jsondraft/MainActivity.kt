package com.example.jsondraft

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var textViewEarthquakes: TextView
    private val apiKey = "Dim3nT1OMASDi23dJDA2324JESA8DddasD83"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textViewEarthquakes = findViewById(R.id.textViewEarthquakes)

        obtenerReportes()
        obtenerTerremotos()
    }

    private fun obtenerReportes() {
        RetrofitClient.api.getReportes(apiKey).enqueue(object : Callback<List<ReporteSismo>> {
            override fun onResponse(call: Call<List<ReporteSismo>>, response: Response<List<ReporteSismo>>) {
                if (response.isSuccessful) {
                    val reportes = response.body()
                    val texto = reportes?.joinToString("\n\n") {
                        "📍 ID: ${it.report_id}\n📌 Lugar: ${it.locstring}\n🌐 Magnitud: ${it.mag}\n📅 Fecha: ${it.time}"
                    } ?: "⚠️ No hay datos disponibles"
                    textView.text = texto
                } else {
                    textView.text = "❌ Error al obtener reportes: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<ReporteSismo>>, t: Throwable) {
                textView.text = "🚫 Fallo de red al obtener reportes: ${t.message}"
            }
        })
    }

    private fun obtenerTerremotos() {
        RetrofitClient.api.getEarthquakes(apiKey).enqueue(object : Callback<List<Earthquake>> {
            override fun onResponse(call: Call<List<Earthquake>>, response: Response<List<Earthquake>>) {
                if (response.isSuccessful) {
                    val earthquakes = response.body()
                    val texto = earthquakes?.joinToString("\n") {
                        "🌍 ID de terremoto: ${it.earthquake_id}"
                    } ?: "⚠️ No hay terremotos registrados"
                    textViewEarthquakes.text = texto
                } else {
                    textViewEarthquakes.text = "❌ Error al obtener terremotos: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Earthquake>>, t: Throwable) {
                textViewEarthquakes.text = "🚫 Fallo de red al obtener terremotos: ${t.message}"
            }
        })
    }
    private fun obtenerDetalleTerremoto(eqId: String) {
        RetrofitClient.api.getEarthquakeDetail(apiKey, eqId)
            .enqueue(object : Callback<EarthquakeDetail> {
                override fun onResponse(call: Call<EarthquakeDetail>, response: Response<EarthquakeDetail>) {
                    if (response.isSuccessful) {
                        Log.d("DetalleTerremoto ✅", response.body().toString())
                    } else {
                        Log.e("DetalleTerremoto ❌", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<EarthquakeDetail>, t: Throwable) {
                    Log.e("DetalleTerremoto 🚫", "Fallo: ${t.message}")
                }
            })
    }

    private fun obtenerDetalleReporte(reportId: Int) {
        RetrofitClient.api.getReporteDetalle(apiKey, reportId)
            .enqueue(object : Callback<ReporteDetalle> {
                override fun onResponse(call: Call<ReporteDetalle>, response: Response<ReporteDetalle>) {
                    if (response.isSuccessful) {
                        Log.d("DetalleReporte ✅", response.body().toString())
                    } else {
                        Log.e("DetalleReporte ❌", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ReporteDetalle>, t: Throwable) {
                    Log.e("DetalleReporte 🚫", "Fallo: ${t.message}")
                }
            })
    }

    private fun obtenerReportesPorTerremoto(eqId: String) {
        RetrofitClient.api.getReportesPorTerremoto(apiKey, eqId)
            .enqueue(object : Callback<List<ReporteDetalle>> {
                override fun onResponse(call: Call<List<ReporteDetalle>>, response: Response<List<ReporteDetalle>>) {
                    if (response.isSuccessful) {
                        Log.d("ReportesPorTerremoto ✅", response.body().toString())
                    } else {
                        Log.e("ReportesPorTerremoto ❌", "Error: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<List<ReporteDetalle>>, t: Throwable) {
                    Log.e("ReportesPorTerremoto 🚫", "Fallo: ${t.message}")
                }
            })
    }


}