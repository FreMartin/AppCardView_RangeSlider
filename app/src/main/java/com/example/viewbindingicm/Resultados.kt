package com.example.viewbindingicm

import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class Resultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)
        val btnRecalcular: Button = findViewById(R.id.btnRecalcular)
        val tvICM : TextView = findViewById(R.id.tvIMC)
        val tvCondicion : TextView = findViewById(R.id.tvCondicion)
        val tvDetalle : TextView = findViewById(R.id.tvDetalles)

        val estatura = intent.getDoubleExtra("estatura", 1.0)
        val peso = intent.getIntExtra("peso",0)
        val genero = intent.getStringExtra("genero")


        val icm = peso / (estatura*estatura)
        var formato = DecimalFormat("#.#")

        tvICM.text = "${formato.format(icm)} kg/m²"

        if (genero == "femenino"){
            when (icm) {
                in 20.0..24.9 -> {
                    tvCondicion.text = "Normal"
                    tvDetalle.text = "Estás en los parámetros de saludable"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.normal))
                }
                in 25.0..29.9 -> {
                    tvCondicion.text = "Riesgo moderado"
                    tvDetalle.text = "Estás en los parámetros de sobrepeso"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.sobrepeso))
                }
                in 30.0..34.9 -> {
                    tvCondicion.text = "Riesgo alto"
                    tvDetalle.text = "Estás en los parámetros de obesidad 1"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidad1))
                }
                in 35.0..39.9 -> {
                    tvCondicion.text = "Riesgo muy alto"
                    tvDetalle.text = "Estás en los parámetros de obesidad 2"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidad2))
                }
                in 40.0..49.9 -> {
                    tvCondicion.text = "Riesgo extremo"
                    tvDetalle.text = "Estás en los parámetros de obesidad mórbida"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidadMorbida))
                }
                else -> {
                    tvCondicion.text = "Fuera de parámetros"
                    tvDetalle.text = "Estás fuera de los parámetros admisibles"
                }
            }
        }else{
            when (icm) {
                in 20.0..25.9 -> {
                    tvCondicion.text = "Normal"
                    tvDetalle.text = "Estás en los parámetros de saludable"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.normal))
                }
                in 26.0..30.9 -> {
                    tvCondicion.text = "Riesgo moderado"
                    tvDetalle.text = "Estás en los parámetros de sobrepeso"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.sobrepeso))
                }
                in 31.0..35.9 -> {
                    tvCondicion.text = "Riesgo alto"
                    tvDetalle.text = "Estás en los parámetros de obesidad 1"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidad1))
                }
                in 36.0..40.9 -> {
                    tvCondicion.text = "Riesgo muy alto"
                    tvDetalle.text = "Estás en los parámetros de obesidad 2"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidad2))
                }
                in 41.0..49.9 -> {
                    tvCondicion.text = "Riesgo extremo"
                    tvDetalle.text = "Estás en los parámetros de obesidad mórbida"
                    tvCondicion.setTextColor(ContextCompat.getColor(this,R.color.obesidadMorbida))
                }
                else -> {
                    tvCondicion.text = "Fuera de parámetros"
                    tvDetalle.text = "Estás fuera de los parámetros admisibles"
                }
            }

        }

        btnRecalcular.setOnClickListener(){
            finish()
        }
    }
}