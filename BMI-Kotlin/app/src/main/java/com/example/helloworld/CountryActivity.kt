package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CountryActivity : AppCompatActivity() {
    private var buttonPoland: Button? = null
    private var buttonUSA: Button? = null
    private var buttonSpain: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_screen)
        buttonPoland = findViewById<View>(R.id.poland) as Button
        buttonUSA = findViewById<View>(R.id.usa) as Button
        buttonSpain = findViewById<View>(R.id.spain) as Button
        buttonPoland!!.setOnClickListener { openPolandActivity() }
        buttonUSA!!.setOnClickListener { openUSAActivity() }
        buttonSpain!!.setOnClickListener { openSpainActivity() }
    }

    fun openPolandActivity() {
        val intent = Intent(this, PolandChartActivity::class.java)
        startActivity(intent)
    }

    fun openUSAActivity() {
        val intent = Intent(this, USAChartActivity::class.java)
        startActivity(intent)
    }

    fun openSpainActivity() {
        val intent = Intent(this, SpainChartActivity::class.java)
        startActivity(intent)
    }
}