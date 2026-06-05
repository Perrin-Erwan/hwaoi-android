package com.example.hwaoiwiki

object ScoreValidator {
    /**
     * Valide que le score est cohérent avec le total.
     */
    fun isValidScore(score: Int, total: Int): Boolean {
        if (total < 0) return false
        return score in 0..total
    }
}
