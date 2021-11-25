package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numtxt: TextView
    private lateinit var add: Button
    private lateinit var sub: Button

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numtxt = findViewById(R.id.num)
        add = findViewById(R.id.button_plus)
        sub = findViewById(R.id.button_minus)

        add.setOnClickListener{ countHandler("+") }
        sub.setOnClickListener{ countHandler("-") }
    }

    private fun countHandler(op:String) {
        when(op){
            "+" -> count++
            "-" -> count--
        }
        changeTxtColor(count)
    }

    private fun changeTxtColor(count:Int){
        when {
            count < 0 -> {
                numtxt.setTextColor(Color.RED)
            }
            count > 0 -> {
                numtxt.setTextColor(Color.GREEN)
            }
            else -> {
                numtxt.setTextColor(Color.BLACK)
            }
        }
        numtxt.text = count.toString()
    }
}