package com.example.viewbindingicm

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import java.text.Format
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rsAltura : RangeSlider = findViewById(R.id.rsAltura)
        val tvAltura : TextView = findViewById(R.id.tvAltura)
        val tvPeso : TextView = findViewById(R.id.tvPeso)
        val tvEdad : TextView = findViewById(R.id.tvEdad)
        val btnPMen : ExtendedFloatingActionButton = findViewById(R.id.btnPesoMenos)
        val btnPMas : ExtendedFloatingActionButton = findViewById(R.id.btnPesoMas)
        val btnEMen : ExtendedFloatingActionButton = findViewById(R.id.btnEdadMenos)
        val btnEMas : ExtendedFloatingActionButton = findViewById(R.id.btnEdadMas)
        val cdMasculino : CardView = findViewById(R.id.cdMasculino)
        val cdFemenino : CardView = findViewById(R.id.cdFemenino)
        val btnCalcular : Button = findViewById(R.id.btnCalcular)
        val ventanaResultados = Intent(this, Resultados::class.java)

        //var estatura = tvAltura.text.substring(0,3).trim()
        var peso = tvPeso.text.toString().toInt()
        var edad = tvEdad.text.toString().toInt()
        var genero = ""

        cdMasculino.setOnClickListener(){
            genero = "masculino"
            Toast.makeText(this, genero.uppercase(), Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, estatura, Toast.LENGTH_SHORT).show()
        }

        cdFemenino.setOnClickListener(){
            genero = "femenino"
            Toast.makeText(this, genero.uppercase(), Toast.LENGTH_SHORT).show()
        }

        btnPMen.setOnClickListener(){
            peso --
            tvPeso.text = peso.toString()
        }

        btnPMas.setOnClickListener(){
            peso ++
            tvPeso.text = peso.toString()
        }

        btnEMen.setOnClickListener(){
            edad --
            tvEdad.text = edad.toString()
        }

        btnEMas.setOnClickListener(){
            edad ++
            tvEdad.text = edad.toString()
        }

        rsAltura.addOnChangeListener { _, value, _ ->
            var formato = DecimalFormat("#.##")
            tvAltura.text = "${formato.format(value)} cm"
            //altura = value.toInt()
        }

        btnCalcular.setOnClickListener(){

            if (genero == "") {
                Toast.makeText(this, "Seleccione un genero ", Toast.LENGTH_SHORT).show()
            }else{
                var estatura = tvAltura.text.substring(0,3).trim().toDouble()
                var estaturaMt = estatura/100
                ventanaResultados.putExtra("peso", peso)
                ventanaResultados.putExtra("estatura", estaturaMt)
                ventanaResultados.putExtra("genero", genero)
                startActivity(ventanaResultados)
            }
        }
    }
}