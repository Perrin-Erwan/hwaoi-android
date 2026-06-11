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
            CharacterData(
                "Quino",
                "Jeune homme doué d'un profond sens de la justice qui l'a poussé à s'engager comme soldat pour servir sa patrie. " +
                        "D'origine noble, il est optimiste et honnête, mais son inexpérience lui joue parfois des tours" ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Cadlan",
                "Jeune soldat Zora qui n'a pas peur de dire ce qu'il pense. " +
                        "Il n'hésite pas à se jeter tête la première dans la bataille afin de devenir " +
                        "suffisamment fort pour pouvoir servir comme garde personnelle de Qia, à qui il voue une profonde admiration." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Lago",
                "Guerrier zora et ancien garde du corps du roi défunt. " +
                        "Dévasté par la perte de son souverain et de nombreux alliés, " +
                        "il décide d'abandonner les armes avant de rassembler à nouveau son courage et retourner au combat." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Pastos",
                "Chef d'un clan goron opposé à une alliance avec Hyrule. " +
                        "Après avoir pris conscience du danger pesant sur tout le royaume, " +
                        "il a décidé de laisser ses griefs de coté et de prendre part à la bataille." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Braton",
                "Jeune Goron de rochers. " +
                        "La vraie raison qui l'a poussé à rejoindre les troupes de défense d'Hyrule " +
                        "est son désir de quitter la montagne de la mort pour goûter aux différents rocher de par tout le royaume." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Vence",
                "Guerrier piaf et proche de Raphica. " +
                        "De nature joviale et malicieuse, il s'inquiète plus que quiconque du poids que le rôle de chef fait peser sur les épaules de son ami." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Masba",
                "Soldat vétéran piaf endurci par le combat qui méprisait le jeune Raphica. " +
                        "Il soutient maintenant son chef  en tant que proche confident et conseiller." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Sholani",
                "Guerrière gerudo dans la même tribu qu'Ardi et qui, sous son apparence impertubable, dissimule une profonde admiration pour elle. " +
                        "Pour protéger ce qui lui est cher, elle a demandé de l'aide à Rauru sans consulter les membres de sa tribu." ,
                android.R.drawable.ic_menu_compass // Remplace par ton image link.png
            ),
            CharacterData(
                "Ronza",
                "Chef d'une autre tribu gerudo. " +
                        "Lorsque Ganondorf devient le roi démon et abandonne les Gerudos, elle combat pour repartir de zéro et laver de son peuple." ,
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

    fun getMaterials(): List<Material> {
        return listOf(
            Material(1, "Ambre brut"),
            Material(2, "Diamant"),
            Material(3, "Topaze brute"),
            Material(4, "Fragment d'étoile")
        )
    }
}