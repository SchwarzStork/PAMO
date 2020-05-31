package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var buttonInit: Button? = null
    private var buttonInitQuiz: Button? = null
    private var buttonInitChart: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonInit = findViewById<View>(R.id.startButton) as Button
        buttonInitQuiz = findViewById<View>(R.id.quizButton) as Button
        buttonInitChart = findViewById<View>(R.id.chartButton) as Button
        buttonInitChart!!.setOnClickListener { openChartActivity() }
        buttonInit!!.setOnClickListener { openCalcActivity() }
        buttonInitQuiz!!.setOnClickListener { openQuizActivity() }
    }

    fun openCalcActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    fun openQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun openChartActivity() {
        val intent = Intent(this, CountryActivity::class.java)
        startActivity(intent)
    }
}