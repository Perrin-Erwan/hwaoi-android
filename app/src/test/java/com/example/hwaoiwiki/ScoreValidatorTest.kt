package com.example.hwaoiwiki

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ScoreValidatorTest {

    @Test
    fun isValidScore_withValidValues_returnsTrue() {
        assertTrue(ScoreValidator.isValidScore(5, 10))
        assertTrue(ScoreValidator.isValidScore(0, 10))
        assertTrue(ScoreValidator.isValidScore(10, 10))
    }

    @Test
    fun isValidScore_withNegativeScore_returnsFalse() {
        assertFalse(ScoreValidator.isValidScore(-1, 10))
    }

    @Test
    fun isValidScore_withScoreHigherThanTotal_returnsFalse() {
        assertFalse(ScoreValidator.isValidScore(11, 10))
    }

    @Test
    fun isValidScore_withNegativeTotal_returnsFalse() {
        assertFalse(ScoreValidator.isValidScore(5, -1))
    }
}
