package com.jairolopes.toolcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jairolopes.toolcoin.databinding.ActivityPriceBinding

class PriceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPriceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        binding = ActivityPriceBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalculatePRICE.setOnClickListener{
            calculate()
        }
    }

    private fun validate():Boolean{
        return (binding.editInvestValuePRICE.text.toString() != "" &&
                binding.editSupplyPRICE.text.toString() != ""
                )
    }
    private fun calculate(){
        if (validate()){
            val investmentValue = binding.editInvestValuePRICE.text.toString().toFloat()
            val coinSupply = binding.editSupplyPRICE.text.toString().toFloat()
            val price = investmentValue/coinSupply

            binding.textResultPRICE.text = "%.4f".format(price)
        }else
            Toast.makeText(this, getString(R.string.popupAlert), Toast.LENGTH_SHORT).show()
    }
}