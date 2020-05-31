package com.example.helloworld

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private var growth: EditText? = null
    private var weight: EditText? = null
    private var age: EditText? = null
    private var result: TextView? = null
    private var radioSexGroup: RadioGroup? = null
    private var buttonScore: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        growth = findViewById(R.id.growth)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)
        result = findViewById(R.id.result)
        radioSexGroup = findViewById(R.id.radioSex)
        buttonScore = findViewById(R.id.buttonScore)
    }

    fun calculateBMI(v: View?) {
        val growthStr = growth!!.text.toString()
        val weightStr = weight!!.text.toString()
        val ageStr = age!!.text.toString()
        val checkedRadioButtonId = radioSexGroup!!.checkedRadioButtonId
        val radioButton = radioSexGroup!!.findViewById<View>(checkedRadioButtonId)
        val sex = radioSexGroup!!.indexOfChild(radioButton)
        if (growthStr != null && growthStr != "" && weightStr == "" && ageStr != null && ageStr != "") {
            val growthValue = growthStr.toFloat() / 100
            val weightValue = weightStr.toFloat()
            val ageValue = ageStr.toFloat()
            val bmi = weightValue / (growthValue * growthValue)
            displayBMI(bmi, sex, weightValue, growthValue, ageValue)
        }
    }

    private fun displayBMI(bmi: Float, sex: Int, weight: Float, growth: Float, age: Float) {
        var bmiLabel = ""
        var foodRecomendation = ""
        var kcal = 0.0
        if (java.lang.Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.krytyczna_niedowaga)
            foodRecomendation = "Czym prędzej zgłoś się do lekarza o pomoc!!"
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.niedowaga)
            foodRecomendation = "Zacznij przyjmować więcej kalorii niż dotychczas, jedz więcej białka"
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 20.5f) <= 0) {
            bmiLabel = getString(R.string.norma)
            foodRecomendation = "Możesz jeść to co jesz dotychczas"
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.nadwaga)
            foodRecomendation = "Przyjmuj mniej kalorii niż dotychczas, unikaj fast foodów"
        } else {
            bmiLabel = getString(R.string.otylosc)
            foodRecomendation = "Zdecydowanie skonsultuj się z dietetykiem oraz do minimum ogranicz tłuszcze"
        }
        if (sex == 0) {
            kcal = 655.1 + 9.563 * weight + 1.85 * growth - 4.676 * age
        } else if (sex == 1) {
            kcal = 66.5 + 13.75 * weight + 5.003 * growth - 6.775 * age
        }
        bmiLabel = """$bmi = $bmiLabel

 Powinieneś zjesć ${result}kcal aby nie stracić wagi

 COVID-19 REKOMENDACJA:
 $foodRecomendation"""
        result!!.text = bmiLabel
    }
}