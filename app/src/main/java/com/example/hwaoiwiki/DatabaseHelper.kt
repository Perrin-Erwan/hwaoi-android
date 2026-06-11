package com.example.hwaoiwiki

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "HyruleDB", null, 1) {

    override fun onConfigure(db: SQLiteDatabase) {
        super.onConfigure(db)
        // Active le support des clés étrangères globalement dans SQLite
        db.setForeignKeyConstraintsEnabled(true)
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Désactivation temporaire pour éviter le blocage de création circulaire
        db.execSQL("PRAGMA foreign_keys = OFF;")

        // 1. Table des Personnages
        db.execSQL("""
            CREATE TABLE characters (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                description TEXT,
                image_resource INTEGER,
                arme_id INTEGER, 
                quiz_question_id INTEGER, 
                FOREIGN KEY (arme_id) REFERENCES weapons(id) ON DELETE SET NULL,
                FOREIGN KEY (quiz_question_id) REFERENCES quiz_questions(id) ON DELETE SET NULL
            )
        """.trimIndent())

        // 2. Table des Armes
        db.execSQL("""
            CREATE TABLE weapons (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL,
                type TEXT,
                puissance INTEGER,
                image_resource INTEGER,
                personnage_id INTEGER, 
                quiz_question_id INTEGER, 
                FOREIGN KEY (personnage_id) REFERENCES characters(id) ON DELETE SET NULL,
                FOREIGN KEY (quiz_question_id) REFERENCES quiz_questions(id) ON DELETE SET NULL
            )
        """.trimIndent())

        // 3. Table des Questions du Quiz
        db.execSQL("""
            CREATE TABLE quiz_questions (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                question TEXT NOT NULL,
                option_a TEXT NOT NULL,
                option_b TEXT NOT NULL,
                option_c TEXT NOT NULL,
                correct_option TEXT NOT NULL,
                personnage_id INTEGER, -- Clé étrangère vers characters
                arme_id INTEGER, -- Clé étrangère vers weapons
                score_id INTEGER, -- Clé étrangère vers scores
                FOREIGN KEY (personnage_id) REFERENCES characters(id) ON DELETE SET NULL,
                FOREIGN KEY (arme_id) REFERENCES weapons(id) ON DELETE SET NULL,
                FOREIGN KEY (score_id) REFERENCES scores(id) ON DELETE SET NULL
            )
        """.trimIndent())

        // 4. Table des Scores
        db.execSQL("""
            CREATE TABLE scores (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                pseudo TEXT DEFAULT 'Guerrier',
                score INTEGER,
                total INTEGER,
                date TEXT,
                quiz_question_id INTEGER, -- Clé étrangère vers quiz_questions
                FOREIGN KEY (quiz_question_id) REFERENCES quiz_questions(id) ON DELETE SET NULL
            )
        """.trimIndent())

        // 5. Table des Matériaux
        db.execSQL("""
            CREATE TABLE materiaux (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nom TEXT NOT NULL
            )
        """.trimIndent())

        // 6. Table pivot WeaponMateriaux
        db.execSQL("""
            CREATE TABLE WeaponMateriaux (
                weapon_id INTEGER,
                material_id INTEGER,
                PRIMARY KEY (weapon_id, material_id),
                FOREIGN KEY (weapon_id) REFERENCES weapons(id) ON DELETE CASCADE,
                FOREIGN KEY (material_id) REFERENCES materiaux(id) ON DELETE CASCADE
            )
        """.trimIndent())

        // Réactivation des clés étrangères après la création de la structure
        db.execSQL("PRAGMA foreign_keys = ON;")

        // INJECTION AUTOMATIQUE DES DONNÉES DE DATA_REPOSITORY
        insererPersonnages(db)
        insererArmes(db)
        insererQuestionsQuiz(db)
        insererMateriaux(db)
    }

    // 1. Insertion des Personnages
    private fun insererPersonnages(db: SQLiteDatabase) {
        val listePersos = DataRepository.getCharacters()
        for (perso in listePersos) {
            val values = ContentValues().apply {
                put("nom", perso.name)
                put("description", perso.bio)
                put("image_resource", perso.imageRes)
                // Note : arme_id et quiz_question_id restent NULL au départ
                // et seront mis à jour via des requêtes UPDATE si nécessaire.
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
                put("puissance", arme.power)
                put("image_resource", arme.imageRes)
                // Note : personnage_id et quiz_question_id restent NULL au départ.
            }
            db.insert("weapons", null, values)
        }
    }

    // 3. Insertion des Questions de Quiz
    private fun insererQuestionsQuiz(db: SQLiteDatabase) {
        val listeQuestions = DataRepository.getQuizQuestions()
        for (paire in listeQuestions) {
            val questionText = paire.first
            val options = paire.second

            if (options.size >= 3) {
                val optionsMelangees = options.shuffled()
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
                    // Note : personnage_id, arme_id et score_id restent NULL au départ.
                }
                db.insert("quiz_questions", null, values)
            }
        }
    }

    private fun insererMateriaux(db: SQLiteDatabase) {
        val listeMateriaux = DataRepository.getMaterials()
        for (materiau in listeMateriaux) {
            val values = ContentValues().apply {
                put("nom", materiau.name)
            }
            db.insert("materiaux", null, values)
        }
    }

    fun insertScore(heroName: String, score: Int): Long {
        val db = this.writableDatabase
        val values = ContentValues()

        // On insère le nom du héros choisi ou du joueur
        values.put("hero_name", heroName)
        values.put("score_value", score)

        // On génère la date du jour automatiquement au bon format
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = sdf.format(Date())
        values.put("game_date", currentDate)

        val success = db.insert("table_scores", null, values) // Remplace "table_scores" par le vrai nom de ta table
        db.close()
        return success
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Désactivation des contraintes pour tout vider proprement sans crash
        db.execSQL("PRAGMA foreign_keys = OFF;")
        db.execSQL("DROP TABLE IF EXISTS weapons")
        db.execSQL("DROP TABLE IF EXISTS characters")
        db.execSQL("DROP TABLE IF EXISTS quiz_questions")
        db.execSQL("DROP TABLE IF EXISTS scores")
        db.execSQL("DROP TABLE IF EXISTS materiaux")
        db.execSQL("DROP TABLE IF EXISTS WeaponMateriaux")
        onCreate(db)
    }
}
