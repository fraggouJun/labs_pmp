package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b: ImageButton = findViewById(R.id.imageButton)
        val t: TextView = findViewById(R.id.textView)
        b.setOnClickListener {
            textView.text = "hi"
        }
    }
}