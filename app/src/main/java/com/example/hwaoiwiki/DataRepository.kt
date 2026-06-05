package com.example.hwaoiwiki

object DataRepository {


    fun getCharacters(): List<CharacterData> {
        return listOf(
            CharacterData(
                "Zelda",
                "Princesse d'Hyrule venue d'une lointaine époque. " +
                        "Pour rentrer chez elle, elle perfectionne ses pouvoirs du temps et de la lumière tout en cherchant à aider l'ancien royaume d'Hyrule.",
                android.R.drawable.ic_menu_camera // Remplace par ton image zelda.png
            ),

            CharacterData(
                "Rauru",
                "Fondateur et premier roi d'hyrule. " +
                        "Faisant partie des derniers survivants du peuple soneau descendu des cieux, " +
                        "il possède une pierre occulte et maîtrise le pouvoir de la lumière.",
                android.R.drawable.ic_menu_agenda // Remplace par ton image impa.png
            ),
            CharacterData(
                "Mineru",
                "Grande soeur de Rauru et spécialiste du savoir soneau. " +
                        "On la trouve généralement dans son étude, faisant des recherches sur les Golems soneaux et d'autres phénomènes semblables." +
                        "Elle possède une pierre occulte et peut séparer son âme de son corps.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Agraston",
                "Chef de tous les gorons. Costaud,calme et réfléchi, il se bat de toutes ses forces pour ses compagnons. " +
                        "C'est un allié et un ami de longue date de Rauru.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Qia",
                "Nouvelle reine et habile guerrière zora qui inspire son peuple par sa bravoure  et sa détermination au combat. " +
                        "Elle monte sur le trône après la mort de son père au combat alors qu'elle est encore jeune.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Raphica",
                "Vif guerrier et chef des Piafs. En dépit de son allure décontracté, " +
                        "il est un allié prévenant et loyal qui défend Hyrule aux cotés de Calamo et des autres.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Ardi",
                "Guerrière bienveillante et matriarche du peuple Gerudo. " +
                        "D'abord tenue de suivre Ganondorf quand il était à leur tête, " +
                        "elle a été désignée chef par ses pairs lorsque celui-ci est devenu le roi démon.",
                android.R.drawable.ic_menu_view
            ),
            CharacterData(
                "Golem Chevalier",
                "Golem découvert dans les profondeurs et réveillé par Calamo. " +
                    "Capable de se transformer pour silloner les cieux, il parcourt Hyrule accompagné de son 'partenaire', l'exentrique Korogu.",
            android.R.drawable.ic_menu_compass // Remplace par ton image link.png
        ),
            CharacterData(
                "Calamo",
                "Korogu parcourant Hyrule accompagné de son partenaire Golem. " +
                        "Après avoir laissé ses nombreux homologues dans la forêt, il arpente le royaume à la recherche d'un endroit où prendre racine.",
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Typhan",
                "Soldat vétéran et garde de la famille royale d'Hyrule. " +
                        "Inspiré par Rauru et Sonia qui fondèrent le royaume d'Hyrule sur les espoirs et rêves du peuple, il a dédié sa vie à leur cause." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
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