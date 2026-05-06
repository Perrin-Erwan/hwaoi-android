package com.example.hwaoiwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val list: List<String>) : RecyclerView.Adapter<HistoryAdapter.VH>() {
    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val txt: TextView = v.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.txt.text = list[position]
        holder.txt.setTextColor(android.graphics.Color.WHITE)
    }

    override fun getItemCount() = list.size
}