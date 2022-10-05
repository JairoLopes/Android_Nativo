package com.jairolopes.toolcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jairolopes.toolcoin.databinding.ActivityAprActicityBinding

class AprActicity : AppCompatActivity() {

    private lateinit var binding:ActivityAprActicityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAprActicityBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalculateAPR.setOnClickListener{
            if (validate()){
                val apr = binding.editAprAPR.text.toString().toFloat() / 100
                val investment = binding.editInvestmentAPR.text.toString().toFloat()

                val yearly = investment * apr
                val monthly = yearly/12
                val weekly = monthly/4
                val daily = yearly/365

                binding.textResultDayAPR.text = "%.2f".format(daily)
                binding.textResultWeekAPR.text = "%.2f".format(weekly)
                binding.textResultMonthAPR.text = "%.2f".format(monthly)
                binding.textResultYearAPR.text = "%.2f".format(yearly)

            }else
                Toast.makeText(this,"Preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }
        binding.buttonClearAPR.setOnClickListener{
            binding.editInvestmentAPR.text.clear()
            binding.editAprAPR.text.clear()
            binding.textResultDayAPR.text = "00.00"
            binding.textResultMonthAPR.text = "00.00"
            binding.textResultWeekAPR.text = "00.00"
            binding.textResultYearAPR.text = "00.00"
        }
    }

    private fun validate():Boolean{
        return (binding.editAprAPR.text.toString() != "" && binding.editInvestmentAPR.text.toString() != "")
    }


}