package com.jairolopes.toolcoin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jairolopes.toolcoin.databinding.ActivityProjectionBinding

class ProjectionActivity : AppCompatActivity(){

    private lateinit var binding:ActivityProjectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProjectionBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonProjectionPROJECTION.setOnClickListener{
            if (validate()){
                val price = binding.editPricePROJECTION.text.toString().toFloat()
                val investment = binding.editInvestmentPROJECTION.text.toString().toFloat()
                val projection = binding.editProjectionPROJECTION.text.toString().toFloat()


                val supply = investment/price
                val profit = ((projection - price) * supply)
                val percentValue = ((projection - price) / price) * 100
                val patrimony = (profit + investment)

                binding.textResultPercentPROJECTION.text =  "%.2f".format(percentValue) + "%"
                binding.textResultSupplyPROJECTION.text = "%.2f".format(supply)
                binding.textResultProfitPROJECTION.text = "$ %.2f".format(profit)
                binding.textResultPatrimonyPROJECTION.text = "$ %.2f".format(patrimony)
            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonClearPROJECTION.setOnClickListener{
            binding.editPricePROJECTION.text.clear()
            binding.editInvestmentPROJECTION.text.clear()
            binding.editProjectionPROJECTION.text.clear()
            binding.textResultPercentPROJECTION.text = "00.00%"
            binding.textResultSupplyPROJECTION.text = "00.00"
            binding.textResultProfitPROJECTION.text = "$ 00.00"
            binding.textResultPatrimonyPROJECTION.text = "$ 00.00"
        }
        binding.buttonArrowBackPROJECTION.setOnClickListener{
            startActivity( Intent(this, MainActivity::class.java) )
        }
    }
    private fun validate():Boolean{
        return (binding.editPricePROJECTION.text.toString() != "" &&
                binding.editInvestmentPROJECTION.text.toString() != "" &&
                binding.editProjectionPROJECTION.text.toString() != ""
                )
    }
}