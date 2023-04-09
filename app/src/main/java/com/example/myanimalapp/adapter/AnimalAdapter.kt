package com.example.myanimalapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myanimalapp.databinding.ItemAnimalLayoutBinding
import com.example.myanimalapp.adapter.model.AnimalModel
import com.example.myanimalapp.R
import com.example.myanimalapp.screens.FirstFragmentDirections

class AnimalAdapter() :RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private var animalList = emptyList<AnimalModel>()
    lateinit var navController: NavController

    class AnimalViewHolder(var binding: ItemAnimalLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalLayoutBinding.inflate(inflater, parent, false)

        return AnimalViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animalList[position]
        val context = holder.itemView.context
        with(holder.binding){
            tvName.text = animal.name
            tvDescription.text = animal.description
            Glide.with(context)
                .load(animal.photo)
                .into(photo)
            root.setOnClickListener {
                val action = FirstFragmentDirections.actionFirstFragment2ToSecondFragment3(
                    animal.name, animal.description, animal.photo
                )
                navController.navigate(action)
            }
        }
    }

    fun setList(List: List<AnimalModel>){
        animalList = List
    }
}