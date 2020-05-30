package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    Button buttonBMI;
    Button calories;
    Button quiz;
    Button wykres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        buttonBMI = findViewById(R.id.buttonBMI);
        calories = findViewById(R.id.buttonCalories);
        quiz = findViewById(R.id.buttonQuiz);
        wykres = findViewById(R.id.buttonWykres);

        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runBmiCalculator();
            }
        });

        calories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runCaloriesCalculator();
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runKoronaQuiz();
            }
        });

        wykres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runWykres();
            }
        });

    }


    void runKoronaQuiz(){
        Intent quiz = new Intent(this, KoronaQuiz.class);
        startActivity(quiz);
    }
    void runCaloriesCalculator() {
        Intent bmi = new Intent(this, MainActivity.class);
        startActivity(bmi);
    }

    void runBmiCalculator(){
        Intent calories = new Intent(this, CaloriesCalculator.class);
        startActivity(calories);
    }

    void runWykres(){
        Intent wykres = new Intent(this, WykresActivity.class);
        startActivity(wykres);
    }







}
