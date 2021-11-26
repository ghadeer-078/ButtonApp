package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var numtxt: TextView
    private lateinit var add: Button
    private lateinit var sub: Button

    private lateinit var clMain:ConstraintLayout

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numtxt = findViewById(R.id.num)
        add = findViewById(R.id.button_plus)
        sub = findViewById(R.id.button_minus)
        clMain = findViewById(R.id.clMain)

        add.setOnClickListener{ countHandler("+") }
        sub.setOnClickListener{ countHandler("-") }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.hi_message -> {
                Snackbar.make(clMain, "Hello there!", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.bye_message -> {
                Snackbar.make(clMain, "Goodbye", Snackbar.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
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