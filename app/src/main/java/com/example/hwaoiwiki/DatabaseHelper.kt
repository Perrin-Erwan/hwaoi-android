package com.example.hwaoiwiki

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "HyruleDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        // 1. Table des Personnages (Mise à jour selon ton CharacterData)
        db.execSQL("""
            CREATE TABLE characters (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                description TEXT,
                image_resource INTEGER
            )
        """.trimIndent())

        // 2. Table des Armes (Mise à jour selon ton modèle Weapon)
        db.execSQL("""
            CREATE TABLE weapons (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                type TEXT,
                puissance INTEGER,
                image_resource INTEGER
            )
        """.trimIndent())

        // 3. Table des Questions du Quiz (Mise à jour pour stocker la question, les options et la bonne réponse)
        db.execSQL("""
            CREATE TABLE quiz_questions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                question TEXT NOT NULL,
                option_a TEXT NOT NULL,
                option_b TEXT NOT NULL,
                option_c TEXT NOT NULL,
                correct_option TEXT NOT NULL
            )
        """.trimIndent())

        // 4. Table des Scores
        db.execSQL("""
            CREATE TABLE scores (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                pseudo TEXT DEFAULT 'Guerrier',
                score INTEGER,
                total INTEGER,
                date TEXT
            )
        """.trimIndent())

        // INJECTION AUTOMATIQUE DES DONNÉES DE DATA_REPOSITORY
        insererPersonnages(db)
        insererArmes(db)
        insererQuestionsQuiz(db)
    }

    // 1. Insertion des Personnages
    private fun insererPersonnages(db: SQLiteDatabase) {
        val listePersos = DataRepository.getCharacters()
        for (perso in listePersos) {
            val values = ContentValues().apply {
                put("nom", perso.name)
                put("description", perso.bio)
                put("image_resource", perso.imageRes) // Utilise la propriété de ton CharacterData (ex: imageRes ou imageResourceId)
            }
            db.insert("characters", null, values)
        }
    }

    // 2. Insertion des Armes
    private fun insererArmes(db: SQLiteDatabase) {
        val listeArmes = DataRepository.getWeapons()
        for (arme in listeArmes) {
            val values = ContentValues().apply {
                put("nom", arme.name)
                put("type", arme.type)
                put("puissance", arme.power) // Utilise la propriété de ton modèle Weapon (ex: puissance ou degats)
                put("image_resource", arme.imageRes) // Utilise la propriété image de ton Weapon
            }
            db.insert("weapons", null, values)
        }
    }

    // 3. Insertion des Questions de Quiz
    // Ton Repository fournit : "Question" to listOf("Bonne Réponse (Index 0)", "Mauvaise 1", "Mauvaise 2")
    private fun insererQuestionsQuiz(db: SQLiteDatabase) {
        val listeQuestions = DataRepository.getQuizQuestions()
        for (paire in listeQuestions) {
            val questionText = paire.first
            val options = paire.second

            if (options.size >= 3) {
                // Mélangeons les options pour ne pas que la bonne réponse soit toujours l'option A
                val optionsMelangees = options.shuffled()

                // On retrouve l'index de la bonne réponse originale (qui était la première de ta liste)
                val indexBonneReponse = optionsMelangees.indexOf(options[0])
                val lettreBonneReponse = when (indexBonneReponse) {
                    0 -> "A"
                    1 -> "B"
                    else -> "C"
                }

                val values = ContentValues().apply {
                    put("question", questionText)
                    put("option_a", optionsMelangees[0])
                    put("option_b", optionsMelangees[1])
                    put("option_c", optionsMelangees[2])
                    put("correct_option", lettreBonneReponse)
                }
                db.insert("quiz_questions", null, values)
            }
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS weapons")
        db.execSQL("DROP TABLE IF EXISTS characters")
        db.execSQL("DROP TABLE IF EXISTS quiz_questions")
        db.execSQL("DROP TABLE IF EXISTS scores")
        onCreate(db)
    }
}