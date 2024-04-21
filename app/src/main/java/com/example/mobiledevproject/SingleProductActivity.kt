package com.example.mobiledevproject

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SingleProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_single_product)

        val title: TextView = findViewById(R.id.single_product_title)
        val text: TextView = findViewById(R.id.single_product_text)

        title.text = intent.getStringExtra("productTitle")
        text.text = intent.getStringExtra("productText")
    }

}