package com.example.hwaoiwiki

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MaterialTest {

    @Test
    fun material_creation_isCorrect() {
        val material = Material(1, "Test")
        assertEquals("Test", material.name)
        assertEquals(1, material.id)
    }

    @Test
    fun getMaterials_returnsData() {
        val materials = DataRepository.getMaterials()
        assertTrue(materials.isNotEmpty())
        assertEquals("Ambre brut", materials[0].name)
    }
}
