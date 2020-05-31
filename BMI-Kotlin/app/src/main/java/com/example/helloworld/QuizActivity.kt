package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private val mQuestionLibrary = QuestionPool()
    private var ScoreView: TextView? = null
    private var QuestionView: TextView? = null
    private var ButtonChoice1: Button? = null
    private var ButtonChoice2: Button? = null
    private var ButtonChoice3: Button? = null
    private var ButtonQuit: Button? = null
    private var resultQuiz: TextView? = null
    private var Answer: String? = null
    private var Score = 0
    private var QuestionNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_screen)
        ScoreView = findViewById<View>(R.id.viewScore) as TextView
        QuestionView = findViewById<View>(R.id.question) as TextView
        ButtonChoice1 = findViewById<View>(R.id.choice1) as Button
        ButtonChoice2 = findViewById<View>(R.id.choice2) as Button
        ButtonChoice3 = findViewById<View>(R.id.choice3) as Button
        ButtonQuit = findViewById<View>(R.id.quit) as Button
        resultQuiz = findViewById<View>(R.id.resultQuiz) as TextView
        updateQuestion()

        //Start of Button Listener for Button1,2,3 and Quit
        ButtonChoice1!!.setOnClickListener {
            if (ButtonChoice1!!.text === Answer) {
                Score = Score + 1
                updateScore(Score)
                updateQuestion()
                //This line of code is optiona
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        ButtonChoice2!!.setOnClickListener {
            if (ButtonChoice2!!.text === Answer) {
                Score = Score + 1
                updateScore(Score)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        ButtonChoice3!!.setOnClickListener {
            if (ButtonChoice3!!.text === Answer) {
                Score = Score + 1
                updateScore(Score)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        ButtonQuit!!.setOnClickListener { openMain() }
    }

    private fun updateQuestion() {
        if (QuestionNumber <= 5) {
            QuestionView!!.text = mQuestionLibrary.getQuestion(QuestionNumber)
            ButtonChoice1!!.text = mQuestionLibrary.getChoice1(QuestionNumber)
            ButtonChoice2!!.text = mQuestionLibrary.getChoice2(QuestionNumber)
            ButtonChoice3!!.text = mQuestionLibrary.getChoice3(QuestionNumber)
            Answer = mQuestionLibrary.getCorrectAnswer(QuestionNumber)
            QuestionNumber++
        } else {
            resultQuiz!!.text = "Twój wynik to :$Score"
        }
    }

    fun openMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun updateScore(point: Int) {
        ScoreView!!.text = "" + Score
    }
}