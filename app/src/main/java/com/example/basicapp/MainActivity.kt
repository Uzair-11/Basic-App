package com.example.basicapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculator.setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }

        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        binding.btnDailyThought.setOnClickListener {
            startActivity(Intent(this, DailyThoughtActivity::class.java))
        }

        binding.btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

        binding.btnShare.setOnClickListener {
            startActivity(Intent(this, ShareActivity::class.java))
        }
    }
}
