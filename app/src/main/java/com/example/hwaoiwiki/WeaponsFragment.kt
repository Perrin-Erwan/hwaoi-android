package com.example.hwaoiwiki


import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeaponsFragment : Fragment(R.layout.fragment_weapons) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_weapons)


        val weapons = DataRepository.getWeapons()


        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = WeaponAdapter(weapons)
    }
}