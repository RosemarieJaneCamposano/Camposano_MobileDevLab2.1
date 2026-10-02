package com.example.planetquiz

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentQuestion = 0

    private val questions = arrayOf(
        "What is the largest planet?",
        "Which planet has the most moons?",
        "Which planet spins on its side?"
    )

    private val correctAnswers = arrayOf(
        "Jupiter",
        "Saturn",
        "Uranus"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        showQuestion()
    }

    private fun showQuestion() {

        // Show the question and planet buttons
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.question_fragment_container,
                QuestionsFragment()
            )
            .commit()

        // Hide the Correct/Wrong section
        val answerContainer =
            findViewById<View>(R.id.answer_fragment_container)

        answerContainer.visibility = View.GONE
    }

    fun getCurrentQuestion(): String {
        return questions[currentQuestion]
    }

    fun showAnswer(selectedAnswer: String) {

        // Show the Correct/Wrong section
        val answerContainer =
            findViewById<View>(R.id.answer_fragment_container)

        answerContainer.visibility = View.VISIBLE

        val answerFragment = AnswersFragment()

        val bundle = Bundle()
        bundle.putString("selectedAnswer", selectedAnswer)

        answerFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(
                R.id.answer_fragment_container,
                answerFragment
            )
            .commit()
    }

    fun nextQuestion() {

        currentQuestion++

        if (currentQuestion >= questions.size) {
            currentQuestion = 0
        }

        showQuestion()
    }

    fun getCorrectAnswer(): String {
        return correctAnswers[currentQuestion]
    }

    fun getAnswerDetail(): String {

        return when (currentQuestion) {
            0 -> getString(R.string.jupiter_detail)
            1 -> getString(R.string.saturn_detail)
            2 -> getString(R.string.uranus_detail)
            else -> ""
        }
    }
}