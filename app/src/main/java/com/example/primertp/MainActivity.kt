package com.example.primertp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.primertp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.buttonPalChecker.setOnClickListener(View.OnClickListener {
            val textToCheck : String = binding.palTextChecker.text.toString()
            checkPal(textToCheck.replace("\\s".toRegex(), "").toLowerCase());
        })

        binding.changeToTemperatureConverter.setOnClickListener( View.OnClickListener {
            val i: Intent = Intent(this, ActivityTemperatura::class.java)
            startActivity(i)
            stop
        })
    }

    private fun checkPal(textToCheck : String){
        if(textToCheck.isEmpty()){
            Toast.makeText(this,"Ingresa un texto para chequear" , Toast.LENGTH_LONG).show()
        }else{
            val invertedText : String? = textToCheck.reversed();
            if(invertedText.equals(textToCheck)){
                Toast.makeText(this,"El texto ingresado es un palindromo" , Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"El texto ingresado no es un palindromo" , Toast.LENGTH_LONG).show()
            }
        }
    }
}