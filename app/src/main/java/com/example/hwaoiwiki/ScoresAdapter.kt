package com.example.hwaoiwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScoresAdapter(private val scoresList: List<Score>) :
    RecyclerView.Adapter<ScoresAdapter.ScoreViewHolder>() {

    class ScoreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvHeroName: TextView = view.findViewById(R.id.tvHeroName)
        val tvScoreValue: TextView = view.findViewById(R.id.tvScoreValue)
        val tvGameDate: TextView = view.findViewById(R.id.tvGameDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = scoresList[position]
        holder.tvHeroName.text = score.heroName
        holder.tvScoreValue.text = score.scoreValue
        holder.tvGameDate.text = score.gameDate
    }

    override fun getItemCount(): Int = scoresList.size
}