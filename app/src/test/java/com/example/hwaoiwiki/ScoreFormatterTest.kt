package com.example.hwaoiwiki

import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreFormatterTest {

    @Test
    fun formatScore_returnsCorrectFormat() {
        val result = ScoreFormatter.formatScore(5, 10)
        assertEquals("5/10 pts", result)
    }

    @Test
    fun formatScore_withZero_returnsCorrectFormat() {
        val result = ScoreFormatter.formatScore(0, 5)
        assertEquals("0/5 pts", result)
    }

    @Test
    fun formatScore_withAllCorrect_returnsCorrectFormat() {
        val result = ScoreFormatter.formatScore(3, 3)
        assertEquals("3/3 pts", result)
    }
}
