package com.example.primertp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.primertp.databinding.ActivityMainBinding
import com.example.primertp.databinding.ActivityTemperaturaBinding

class Activity_temperatura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTemperatureConverter.setOnClickListener(View.OnClickListener {
            var celsiusText : String = binding.temperatureConverterText.text.toString();
            if(celsiusText.isEmpty()){
                Toast.makeText(this,"Ingresa un texto para chequear" , Toast.LENGTH_LONG).show();
            }else {
                convertToFahrenheit(celsiusText , binding)
            }
        })


        binding.changeToPal.setOnClickListener( View.OnClickListener {
            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        })
    }

    private fun convertToFahrenheit(celsiusText : String , binding : ActivityTemperaturaBinding){
        val celsius : Double? = celsiusText.toDoubleOrNull();
        if(celsius != null){
            val celsius : Double? = celsiusText.toDoubleOrNull();
            if (celsius != null) {
                binding.farenheitResult.text = "${((celsius * 9.0 / 5.0) + 32.0)} °F"
            }
        }else {
            Toast.makeText(this,"Texto ingresado no es valido", Toast.LENGTH_LONG).show();
        }
    }


}