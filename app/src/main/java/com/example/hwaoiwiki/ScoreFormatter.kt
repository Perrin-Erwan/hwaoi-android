package com.example.hwaoiwiki

object ScoreFormatter {
    fun formatScore(score: Int, total: Int): String {
        return "$score/$total pts"
    }
}
