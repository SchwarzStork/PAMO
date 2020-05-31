package com.example.helloworld

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anychart.anychart.AnyChart
import com.anychart.anychart.AnyChartView
import com.anychart.anychart.DataEntry
import com.anychart.anychart.ValueDataEntry
import java.util.*

class PolandChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_screen)
        val pie = AnyChart.pie()
        val poland: MutableList<DataEntry> = ArrayList()
        poland.add(ValueDataEntry("Zakażeni", 23571))
        poland.add(ValueDataEntry("Zmarli", 11016))
        poland.add(ValueDataEntry("Wyleczeni", 1061))
        pie.setData(poland)
        pie.setTitle("COVID-19")
        val anyChartView = findViewById<View>(R.id.any_chart_view) as AnyChartView
        anyChartView.setChart(pie)
    }
}