package com.example.basicapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicapp.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener { performOperation(Operation.ADD) }
        binding.btnSubtract.setOnClickListener { performOperation(Operation.SUBTRACT) }
        binding.btnMultiply.setOnClickListener { performOperation(Operation.MULTIPLY) }
        binding.btnDivide.setOnClickListener { performOperation(Operation.DIVIDE) }
    }

    private fun performOperation(operation: Operation) {
        val num1 = binding.etNumber1.text.toString()
        val num2 = binding.etNumber2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val a = num1.toDouble()
        val b = num2.toDouble()
        val result = when (operation) {
            Operation.ADD -> a + b
            Operation.SUBTRACT -> a - b
            Operation.MULTIPLY -> a * b
            Operation.DIVIDE -> if (b != 0.0) a / b else "Error: Div by 0"
        }

        binding.tvResult.text = "Result: $result"
    }

    enum class Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}
