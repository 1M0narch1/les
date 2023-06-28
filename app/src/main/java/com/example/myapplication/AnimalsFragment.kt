package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentAnimalsBinding
import com.example.myapplication.repository.AnimalsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AnimalsFragment : Fragment() {

    lateinit var animalsBinding: FragmentAnimalsBinding
    var adapter = AnimalsAdapter()

    private lateinit var animalsRepository: AnimalsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        animalsBinding = FragmentAnimalsBinding.inflate(layoutInflater)

        animalsRepository = AnimalsRepository(MyAnimalsApp.INSTANCE.database.animalsDao())

        //TODO("Поменяйте на lifecycleScope")
        lifecycleScope.launch(Dispatchers.IO) {

            val animals = animalsRepository.getAllAnimas()
            adapter.addAnimal(animals)
            withContext(Dispatchers.Main) {
                //TODO(Список откравляется в adapter RecyclerView(как в примере, который мы рассматривали,
                // когда изучали его))
                animalsBinding.RCAnimals.layoutManager = LinearLayoutManager(this@AnimalsFragment.requireContext())
                animalsBinding.RCAnimals.adapter = adapter
            }
        }

        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return animalsBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            AnimalsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}