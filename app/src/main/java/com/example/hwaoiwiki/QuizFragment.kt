package com.example.hwaoiwiki

import android.content.ContentValues
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class QuizFragment : Fragment(R.layout.fragment_quiz) {

    private var currentScore = 0
    private var questionIndex = 0

    private val questions = DataRepository.getQuizQuestions()


    private val answers = listOf(0, 0, 0)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvQuestion = view.findViewById<TextView>(R.id.tv_question)
        val tvFeedback = view.findViewById<TextView>(R.id.tv_feedback)
        val buttons = listOf(
            view.findViewById<Button>(R.id.btn_ans1),
            view.findViewById<Button>(R.id.btn_ans2),
            view.findViewById<Button>(R.id.btn_ans3)
        )

        fun loadQuestion() {
            if (questionIndex < questions.size) {
                val currentQ = questions[questionIndex]
                tvQuestion.text = currentQ.first

                buttons.forEachIndexed { i, btn ->
                    btn.text = currentQ.second[i]
                    btn.isEnabled = true
                    btn.setBackgroundColor(Color.parseColor("#0A5D4C"))
                    btn.visibility = View.VISIBLE
                }
                tvFeedback.visibility = View.INVISIBLE
            } else {
                // Le quiz est fini, on appelle la sauvegarde !
                saveFinalScore()
                tvQuestion.text = "Quiz terminé !\nScore final : ${ScoreFormatter.formatScore(currentScore, questions.size)}"
                buttons.forEach { it.visibility = View.GONE }
                tvFeedback.visibility = View.GONE
            }
        }

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val correctIndex = answers[questionIndex]
                buttons.forEach { it.isEnabled = false }

                if (index == correctIndex) {
                    currentScore++
                    tvFeedback.text = "Bien joué !"
                    tvFeedback.setTextColor(Color.GREEN)
                    button.setBackgroundColor(Color.GREEN)
                } else {
                    tvFeedback.text = "Faux ! C'était : ${questions[questionIndex].second[correctIndex]}"
                    tvFeedback.setTextColor(Color.RED)
                    button.setBackgroundColor(Color.RED)
                }

                tvFeedback.visibility = View.VISIBLE

                view.postDelayed({
                    questionIndex++
                    loadQuestion()
                }, 2000)
            }
        }

        loadQuestion()
    }

    // Ta fonction de sauvegarde nettoyée et adaptée à notre affichage de scores
    private fun saveFinalScore() {
        try {
            val dbHelper = DatabaseHelper(requireContext())
            val db = dbHelper.writableDatabase

            val values = ContentValues().apply {
                put("score", currentScore) // au lieu de score_value
                put("total", questions.size) // si tu veux garder le total
                put("date", System.currentTimeMillis().toString()) // Enregistre le timestamp
            }

            // IMPORTANT : Vérifie que "scores" est bien le nom de la table défini dans ton DatabaseHelper
            val result = db.insert("scores", null, values)

            if (result != -1L) {
                Toast.makeText(requireContext(), "Chronique enregistrée dans les scores !", Toast.LENGTH_SHORT).show()
            }
            db.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}