package com.example.jsondraft

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                        "ID: ${it.report_id}\nLugar: ${it.locstring}\nMagnitud: ${it.mag}\nFecha: ${it.time}"
                    } ?: "No hay datos"
                    textView.text = texto
                } else {
                    textView.text = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<ReporteSismo>>, t: Throwable) {
                textView.text = "Fallo: ${t.message}"
            }
        })
    }

    private fun obtenerTerremotos() {
        RetrofitClient.api.getEarthquakes(apiKey).enqueue(object : Callback<List<Earthquake>> {
            override fun onResponse(call: Call<List<Earthquake>>, response: Response<List<Earthquake>>) {
                if (response.isSuccessful) {
                    val earthquakes = response.body()
                    val texto = earthquakes?.joinToString("\n") {
                        "ID de terremoto: ${it.earthquake_id}"
                    } ?: "No hay terremotos"
                    textViewEarthquakes.text = texto
                } else {
                    textViewEarthquakes.text = "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Earthquake>>, t: Throwable) {
                textViewEarthquakes.text = "Fallo: ${t.message}"
            }
        })
    }
}