package com.example.hwaoiwiki

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ScoresFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Associe le fragment au fichier layout fragment_scores.xml
        val view = inflater.inflate(R.layout.fragment_scores, container, false)

        // Récupération des vues du layout
        val tvTitle = view.findViewById<TextView>(R.id.tvTitleScores)
        val rvScores = view.findViewById<RecyclerView>(R.id.rvScores)
        val tvEmptyScores = view.findViewById<TextView>(R.id.tvEmptyScores)

        // TODO : Initialiser la RecyclerView avec un Adapter et charger les données de la BDD
        // Pour l'instant, on laisse l'affichage de base. Si tu veux simuler une liste vide :
        // tvEmptyScores.visibility = View.VISIBLE
        // rvScores.visibility = View.GONE

        return view
    }
}