package com.example.hwaoiwiki

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class DataRepositoryTest {

    @Test
    fun getCharacters_returnsExpectedCount() {
        val characters = DataRepository.getCharacters()
        assertEquals(19, characters.size)
    }

    @Test
    fun getWeapons_returnsExpectedCount() {
        val weapons = DataRepository.getWeapons()
        assertEquals(4, weapons.size)
    }

    @Test
    fun getQuizQuestions_returnsValidQuestions() {
        val questions = DataRepository.getQuizQuestions()
        assertTrue(questions.isNotEmpty())
        for (question in questions) {
            // Each question should have a non-empty text
            assertTrue(question.first.isNotEmpty())
            // Each question should have at least 3 options
            assertTrue(question.second.size >= 3)
        }
    }
}
