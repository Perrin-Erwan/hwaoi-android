package com.example.hwaoiwiki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScoresFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_scores, container, false)

        val rvScores = view.findViewById<RecyclerView>(R.id.rvScores)
        val tvEmptyScores = view.findViewById<TextView>(R.id.tvEmptyScores)

        // Configurer la RecyclerView (LayoutManager vertical classique)
        rvScores.layoutManager = LinearLayoutManager(requireContext())

        // Charger les données depuis la base de données
        val scoresList = loadScoresFromDatabase()

        // Gérer l'affichage si la liste est vide ou pleine
        if (scoresList.isEmpty()) {
            tvEmptyScores.visibility = View.VISIBLE
            rvScores.visibility = View.GONE
        } else {
            tvEmptyScores.visibility = View.GONE
            rvScores.visibility = View.VISIBLE

            // On donne la liste à notre adaptateur
            val adapter = ScoresAdapter(scoresList)
            rvScores.adapter = adapter
        }

        return view
    }

    // Fonction qui lit les données dans ton DatabaseHelper
    private fun loadScoresFromDatabase(): List<Score> {
        val list = mutableListOf<Score>()
        try {
            val dbHelper = DatabaseHelper(requireContext())
            val db = dbHelper.readableDatabase

            // Requête SQL pour récupérer les scores (remplace "scores" par le vrai nom de ta table si besoin)
            val cursor = db.rawQuery("SELECT * FROM scores ORDER BY id DESC", null)

            if (cursor.moveToFirst()) {
                do {
                    // Dans ta boucle cursor, récupère les vrais noms de colonnes :
                    val hero = "Link" // Optionnel, ou si tu n'as pas de colonne nom, laisse une valeur par défaut
                    val scoreRecup = cursor.getInt(cursor.getColumnIndexOrThrow("score"))
                    val totalRecup = cursor.getInt(cursor.getColumnIndexOrThrow("total"))
                    val dateRaw = cursor.getString(cursor.getColumnIndexOrThrow("date"))
                    val dateFormatted = try {
                        DateUtils.formatTimestamp(dateRaw.toLong())
                    } catch (e: Exception) {
                        dateRaw
                    }

                    val value = ScoreFormatter.formatScore(scoreRecup, totalRecup)
                    list.add(Score(hero, value, dateFormatted))
                } while (cursor.moveToNext())
            }
            cursor.close()
            db.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }
}