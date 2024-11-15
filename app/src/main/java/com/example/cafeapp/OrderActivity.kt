package com.example.cafeapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            val orderDetails = intent.getStringExtra("ORDER_DETAILS")
            findViewById<TextView>(R.id.order_textview).text = orderDetails
            val radioGroup = findViewById<RadioGroup>(R.id.order_options)
            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedOption = when (checkedId) {
                    R.id.option1 -> "Option 1"
                    R.id.option2 -> "Option 2"
                    else -> ""
                }
                // Do something with the selected option
            }
            val submitButton = findViewById<Button>(R.id.submit_button)
            submitButton.setOnClickListener {
                val intent = Intent(this, OrderDetailsActivity::class.java)
                startActivity(intent)
            }

        }
    }
}