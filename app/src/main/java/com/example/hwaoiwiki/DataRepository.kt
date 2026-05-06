package com.example.hwaoiwiki

object DataRepository {


    fun getCharacters(): List<CharacterData> {
        return listOf(
            CharacterData(
                "Golem Chevalier",
                "Le jeune prodige de la garde royale. Manie l'Épée de Légende pour repousser les ténèbres.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Zelda",
                "La princesse d'Hyrule qui tente d'éveiller son pouvoir sacré pour sceller le Fléau.",
                android.R.drawable.ic_menu_camera // Remplace par ton image zelda.png
            ),
            CharacterData(
                "Impa",
                "Générale Sheikah dévouée, elle utilise des techniques de ninjutsu et des symboles magiques.",
                android.R.drawable.ic_menu_agenda // Remplace par ton image impa.png
            ),
            CharacterData(
                "Ardi",
                "Chef des Gerudos, elle maîtrise la foudre avec une élégance mortelle.",
                android.R.drawable.ic_menu_view
            )
        )
    }


    fun getWeapons(): List<Weapon> {
        return listOf(
            Weapon(1, "Épée de Légende", "Épée", 30, android.R.drawable.ic_menu_gallery),
            Weapon(2, "Arc Royal", "Arc", 24, android.R.drawable.ic_menu_gallery),
            Weapon(3, "Lance d'écailles", "Lance", 18, android.R.drawable.ic_menu_gallery),
            Weapon(4, "Brise-Montagne", "Masse", 42, android.R.drawable.ic_menu_gallery)
        )
    }


    fun getQuizQuestions(): List<Pair<String, List<String>>> {
        return listOf(
            "Quelle est l'arme de Link ?" to listOf("Master Sword", "Arc Royal", "Lance de bois"),
            "Qui est le chef des Gerudos ?" to listOf("Urbosa", "Riju", "Impa"),
            "Quel est le pouvoir de Revali ?" to listOf("Le courant d'air", "La foudre", "Le bouclier")
        )
    }
}