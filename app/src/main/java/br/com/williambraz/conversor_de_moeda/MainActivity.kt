package br.com.williambraz.conversor_de_moeda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import br.com.williambraz.conversor_de_moeda.databinding.ActivityMainBinding
import br.com.williambraz.conversor_de_moeda.model.IObserver
import br.com.williambraz.conversor_de_moeda.model.Price
import br.com.williambraz.conversor_de_moeda.repository.RateAPI

class MainActivity : AppCompatActivity(), IObserver {
    private lateinit var binding: ActivityMainBinding
    private val euroPrice = Price()
    private val dollarPrice = Price()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.euroPrice = euroPrice
        binding.dollarPrice = dollarPrice

        binding.btnConvert.setOnClickListener{
            val rateAPI = RateAPI()
            rateAPI.getCurrency(applicationContext, this)
        }
    }

    override fun updateUI(data: MutableMap<String, Any>) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Aguarde...")
        alert.setMessage("Estamos processando a conversão!!!")
        alert.show()

        if(data.isNotEmpty()){
            val dollarValue = data["dollar"]
            val euroValue = data["euro"]

            val realValue = binding.txtReal.text.toString()
        }
    }
}
