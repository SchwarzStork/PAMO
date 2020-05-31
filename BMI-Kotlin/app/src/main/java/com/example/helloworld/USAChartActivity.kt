package com.example.helloworld

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anychart.anychart.AnyChart
import com.anychart.anychart.AnyChartView
import com.anychart.anychart.DataEntry
import com.anychart.anychart.ValueDataEntry
import java.util.*

class USAChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_screen)
        val pie = AnyChart.pie()
        val usa: MutableList<DataEntry> = ArrayList()
        usa.add(ValueDataEntry("Zakażeni", 1800000))
        usa.add(ValueDataEntry("Zmarli", 105000))
        usa.add(ValueDataEntry("Wyleczeni", 389000))
        pie.setData(usa)
        pie.setTitle("COVID-19")
        val anyChartView = findViewById<View>(R.id.any_chart_view) as AnyChartView
        anyChartView.setChart(pie)
    }
}