package com.example.primertp
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.primertp.databinding.ActivityTemperaturaBinding

class ActivityTemperatura : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTemperatureConverter.setOnClickListener(View.OnClickListener {
            convertToFahrenheitEvent(binding);
        })

        binding.changeToPal.setOnClickListener( View.OnClickListener {
            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        })
    }

    private fun convertToFahrenheitEvent(binding: ActivityTemperaturaBinding){
        var celsiusText : String = binding.temperatureConverterText.text.toString();
        if(celsiusText.isEmpty()){
            Toast.makeText(this,"Ingresa un grado celius para cambiar a Farhenheit" , Toast.LENGTH_LONG).show();
        }else{
            val celsius : Double? = convertToFahrenheit(celsiusText);
            if(celsius != null){
                binding.farenheitResult.text = "${((celsius * 9.0 / 5.0) + 32.0)} °F"
            }
        }
    }

    private fun convertToFahrenheit(celsiusText : String): Double?{
        var celsius : Double? = celsiusText.toDoubleOrNull();
        if(celsius != null){
            return  ((celsius * 9.0 / 5.0) + 32.0)
        }
        Toast.makeText(this,"Texto ingresado no es valido", Toast.LENGTH_LONG).show();
    }


}