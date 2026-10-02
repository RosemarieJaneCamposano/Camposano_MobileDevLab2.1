package com.example.planetquiz

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnswersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_answers,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val resultPanel =
            view.findViewById<LinearLayout>(R.id.resultPanel)

        val resultText =
            view.findViewById<TextView>(R.id.resultText)

        val detailText =
            view.findViewById<TextView>(R.id.detailText)

        val nextButton =
            view.findViewById<Button>(R.id.nextButton)

        val activity = requireActivity() as MainActivity

        val selectedAnswer =
            arguments?.getString("selectedAnswer") ?: ""

        val correctAnswer =
            activity.getCorrectAnswer()

        val isCorrect =
            selectedAnswer.equals(
                correctAnswer,
                ignoreCase = true
            )

        if (isCorrect) {

            // Green result panel
            resultPanel.setBackgroundColor(
                Color.rgb(76, 175, 80)
            )

            resultText.text =
                getString(R.string.correct)

            resultText.setTextColor(Color.WHITE)

            detailText.text =
                activity.getAnswerDetail()

        } else {

            // Red result panel
            resultPanel.setBackgroundColor(
                Color.rgb(244, 67, 54)
            )

            resultText.text =
                getString(R.string.wrong)

            resultText.setTextColor(Color.WHITE)

            detailText.text = getString(
                R.string.correct_answer_message,
                correctAnswer,
                activity.getAnswerDetail()
            )
        }

        // Go to the next question
        nextButton.setOnClickListener {
            activity.nextQuestion()
        }
    }
}