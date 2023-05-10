package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcular.setOnClickListener{ calculateTip() }
    }
    fun calculateTip() {
        val stringInTextField = binding.preco.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.vinte -> 0.20
            R.id.dezoito -> 0.18
            else -> 0.15

        }
        var tip = tipPercentage * cost
        val roundUp = binding.gorjetaAtivo.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultadoDaGorjeta.text = getString(R.string.resultadoDaGorjeta, formattedTip)
    }

}


//Meu Comando que dua errado

/*package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.calcular.setOnClickListener{ calcularGorjeta() }
    }
    fun calcularGorjeta(){
        val stringTextField = binding.preco.text.toString()
        val prec = stringTextField.toDouble()
        val selectedId = binding.gorjetaOpicao.checkedRadioButtonId
        val gorjetaPorcentagem = when (selectedId) {
            R.id.vinte -> 0.20
            R.id.dezoito -> 0.18
            else ->0.15
        }
        var gorjeta = gorjetaPorcentagem * prec
        val roundUp = binding.switch1.isChecked
        if(roundUp){
            gorjeta = kotlin.math.ceil(gorjeta)
        }
        val formatoGorjeta = NumberFormat.getCurrencyInstance().format(gorjeta)
        //binding.resultadoDaGorjeta.text = getString(R.string.resultadoDaGorjeta, formatoGorjeta)
        //binding.resultadoDaGorjeta.text = gorjeta.toString()
        //binding.resultadoDaGorjeta.text = binding.preco.text.toString()

    }
}*/