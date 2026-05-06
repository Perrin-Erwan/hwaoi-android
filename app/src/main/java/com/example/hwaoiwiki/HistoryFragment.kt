package com.example.hwaoiwiki

import android.database.Cursor
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class HistoryFragment : Fragment(R.layout.fragment_history) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_history)
        val scoresList = mutableListOf<String>()

        // 1. Ouvrir la base de données
        val dbHelper = DatabaseHelper(requireContext())
        val db = dbHelper.readableDatabase

        // 2. Faire la requête
        val cursor: Cursor = db.rawQuery("SELECT * FROM scores ORDER BY id DESC", null)

        if (cursor.moveToFirst()) {
            do {
                val score = cursor.getInt(cursor.getColumnIndexOrThrow("score"))
                val total = cursor.getInt(cursor.getColumnIndexOrThrow("total"))
                val date = cursor.getString(cursor.getColumnIndexOrThrow("date"))

                scoresList.add("Score: $score/$total — Le ${formatDate(date)}")
            } while (cursor.moveToNext())
        }
        cursor.close()

        // 3. Afficher dans une liste simple
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HistoryAdapter(scoresList)
    }

    private fun formatDate(timestamp: String): String {
        // Petite fonction pour rendre la date lisible
        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp.toLong()))
    }
}