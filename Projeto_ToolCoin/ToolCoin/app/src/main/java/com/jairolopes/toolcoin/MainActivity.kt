package com.jairolopes.toolcoin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jairolopes.toolcoin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonProjectionMAIN.setOnClickListener{
            startActivity( Intent(this, ProjectionActivity::class.java) )
        }

        binding.buttonAprsMAIN.setOnClickListener{
            startActivity( Intent(this, AprActicity::class.java) )
        }

        binding.buttonPriceMAIN.setOnClickListener{
            startActivity( Intent(this, PriceActivity::class.java) )
        }

    }
}