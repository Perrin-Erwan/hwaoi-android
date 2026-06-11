package com.example.hwaoiwiki

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MaterialsFragment : Fragment(R.layout.fragment_materials) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMaterials = view.findViewById<RecyclerView>(R.id.rv_materials)
        rvMaterials.layoutManager = LinearLayoutManager(requireContext())
        
        val materials = DataRepository.getMaterials()
        rvMaterials.adapter = MaterialsAdapter(materials)
    }

    private class MaterialsAdapter(private val materials: List<Material>) :
        RecyclerView.Adapter<MaterialsAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val name: TextView = view.findViewById(android.R.id.text1)
            val info: TextView = view.findViewById(android.R.id.text2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = android.view.LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_2, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val material = materials[position]
            holder.name.text = material.id.toString()
            holder.name.setTextColor(android.graphics.Color.WHITE)
            holder.info.text = material.name
            holder.info.setTextColor(android.graphics.Color.YELLOW)
        }

        override fun getItemCount() = materials.size
    }
}
