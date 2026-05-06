package com.example.hwaoiwiki

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Petit modèle de données local pour le fragment
data class CharacterData(val name: String, val bio: String, val imageRes: Int)

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_characters)


        val charList = DataRepository.getCharacters()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CharacterAdapter(charList) { character ->
            // Logique du bouton : Ouvrir l'activité de détails
            val intent = Intent(requireContext(), CharacterDetailActivity::class.java).apply {
                putExtra("CHAR_NAME", character.name)
                putExtra("CHAR_BIO", character.bio)
                putExtra("CHAR_IMAGE", character.imageRes)
            }
            startActivity(intent)
        }
    }


    class CharacterAdapter(
        private val list: List<CharacterData>,
        private val onClick: (CharacterData) -> Unit
    ) : RecyclerView.Adapter<CharacterAdapter.VH>() {

        class VH(v: View) : RecyclerView.ViewHolder(v) {
            val name: TextView = v.findViewById(R.id.char_name_list)
            val btn: Button = v.findViewById(R.id.btn_details)
            val img: ImageView = v.findViewById(R.id.char_image_thumb)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
            return VH(v)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val item = list[position]
            holder.name.text = item.name
            holder.img.setImageResource(item.imageRes)
            holder.btn.setOnClickListener { onClick(item) }
        }

        override fun getItemCount() = list.size
    }
}