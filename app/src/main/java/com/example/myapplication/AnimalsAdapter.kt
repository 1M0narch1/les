package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.AnimalRecyclerItemBinding
import com.example.myapplication.model.Animal

class AnimalsAdapter : RecyclerView.Adapter<AnimalsAdapter.AnimalsHolder>() {

    private lateinit var animalList : List<Animal>

    class AnimalsHolder(item: View) :RecyclerView.ViewHolder(item) {
        private val binding = AnimalRecyclerItemBinding.bind(item)
        fun bind(animal: Animal){
            binding.apply {
                animal.apply {
                    if (type == Animal.TYPE_CAT) {
                        IVAnimalRecyclerItem.setImageResource(R.drawable.cat)
                    } else if (animal.type == Animal.TYPE_DOG) {
                        IVAnimalRecyclerItem.setImageResource(R.drawable.dog)
                    } else {
                        IVAnimalRecyclerItem.setImageResource(R.drawable.android)
                    }
                    TVAnimalItemAge.text = age.toString()
                    TVAnimalItemDiscription.text = description
                    TVAnimalItemName.text = name
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_recycler_item, parent, false)
        return AnimalsHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalsHolder, position: Int) {
        holder.bind(animalList[position])
    }

    fun addAnimal(animals: List<Animal>){
        animalList = animals
        notifyDataSetChanged()
    }
}