package com.example.hwaoiwiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MaterialsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materials)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.materials_container, MaterialsFragment())
                .commit()
        }
    }

    // Fonction pour récupérer les données (demandé dans le point 4)
    fun getMaterialsData(): List<Material> {
        return DataRepository.getMaterials()
    }
}
