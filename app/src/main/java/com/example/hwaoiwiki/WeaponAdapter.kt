package com.example.hwaoiwiki

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeaponAdapter(private val weaponList: List<Weapon>) :
    RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder>() {

    class WeaponViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.weapon_image)
        val name: TextView = view.findViewById(R.id.weapon_name)
        val power: TextView = view.findViewById(R.id.weapon_power)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weapon, parent, false)
        return WeaponViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        val weapon = weaponList[position]
        holder.name.text = weapon.name
        holder.power.text = "Puissance : ${weapon.power}"
        holder.img.setImageResource(weapon.imageRes)
    }

    override fun getItemCount() = weaponList.size
}