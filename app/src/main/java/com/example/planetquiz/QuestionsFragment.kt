package com.example.planetquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_questions,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val activity = requireActivity() as MainActivity

        val questionText =
            view.findViewById<TextView>(R.id.questionText)

        questionText.text = activity.getCurrentQuestion()

        val mercuryButton =
            view.findViewById<Button>(R.id.mercuryButton)

        val venusButton =
            view.findViewById<Button>(R.id.venusButton)

        val earthButton =
            view.findViewById<Button>(R.id.earthButton)

        val marsButton =
            view.findViewById<Button>(R.id.marsButton)

        val jupiterButton =
            view.findViewById<Button>(R.id.jupiterButton)

        val saturnButton =
            view.findViewById<Button>(R.id.saturnButton)

        val uranusButton =
            view.findViewById<Button>(R.id.uranusButton)

        val neptuneButton =
            view.findViewById<Button>(R.id.neptuneButton)

        val buttons = listOf(
            mercuryButton,
            venusButton,
            earthButton,
            marsButton,
            jupiterButton,
            saturnButton,
            uranusButton,
            neptuneButton
        )

        fun submitAnswer(answer: String) {

            // Disable all planet buttons after one selection
            buttons.forEach { button ->
                button.isEnabled = false
            }

            // Show the answer
            activity.showAnswer(answer)
        }

        mercuryButton.setOnClickListener {
            submitAnswer("Mercury")
        }

        venusButton.setOnClickListener {
            submitAnswer("Venus")
        }

        earthButton.setOnClickListener {
            submitAnswer("Earth")
        }

        marsButton.setOnClickListener {
            submitAnswer("Mars")
        }

        jupiterButton.setOnClickListener {
            submitAnswer("Jupiter")
        }

        saturnButton.setOnClickListener {
            submitAnswer("Saturn")
        }

        uranusButton.setOnClickListener {
            submitAnswer("Uranus")
        }

        neptuneButton.setOnClickListener {
            submitAnswer("Neptune")
        }
    }
}