package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentAddAnimalsBinding
import com.example.myapplication.model.Animal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.myapplication.repository.AnimalsRepository

class AddAnimalsFragment : Fragment() {

    lateinit var addAnimalsBinding: FragmentAddAnimalsBinding

    private lateinit var animalsRepository: AnimalsRepository

    val animalTypes = arrayOf<String>(Animal.TYPE_CAT, Animal.TYPE_DOG, Animal.TYPE_ANDROID)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addAnimalsBinding = FragmentAddAnimalsBinding.inflate(layoutInflater)
        animalsRepository = AnimalsRepository(MyAnimalsApp.INSTANCE.database.animalsDao())
        arguments?.let {
        }

        with(addAnimalsBinding) {
        var type = animalTypes[0]
        val spinerAdapter = ArrayAdapter<String>(this@AddAnimalsFragment.
        requireContext(),android.R.layout.simple_spinner_item, animalTypes)
        spinerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        typeOfAnimalSpiner.adapter = spinerAdapter
        typeOfAnimalSpiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                type = animalTypes[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

            add.setOnClickListener {
                val name = nameEditText.run {
                    val textVar = text.toString()
                    text?.clear()
                    textVar
                }
                val age = ageEditText.run {
                    val textVar = text.toString()
                    text?.clear()
                    textVar.toInt()
                }
                val weight = weightEditText.run {
                    val textVar = text.toString()
                    text?.clear()
                    textVar.toDouble()
                }
                val description = discriptionEditText.run {
                    val textVar = text.toString()
                    text?.clear()
                    textVar
                }

                val createdTime = System.currentTimeMillis()

//              TODO("Поменяйте на lifecycleScope")
                lifecycleScope.launch(Dispatchers.IO) {
                    animalsRepository.insertAnimal(
                        Animal(
                            type,
                            name,
                            age,
                            weight,
                            description,
                            createdTime
                        )
                    )

                }
                //Если я не ошибаюсь, каждый раз будет создаваться новая activity поверх предыдущей
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return addAnimalsBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddAnimalsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}