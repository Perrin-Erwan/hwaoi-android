package com.example.hwaoiwiki

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)


        val name = intent.getStringExtra("CHAR_NAME")
        val description = intent.getStringExtra("CHAR_BIO")
        val imageRes = intent.getIntExtra("CHAR_IMAGE", 0)


        val tvName = findViewById<TextView>(R.id.detail_name)
        val tvDesc = findViewById<TextView>(R.id.detail_description)
        val ivImage = findViewById<ImageView>(R.id.detail_image)
        val btnBack = findViewById<Button>(R.id.btn_back)


        tvName.text = name
        tvDesc.text = description
        if (imageRes != 0) ivImage.setImageResource(imageRes)

        btnBack.setOnClickListener { finish() }
    }
}