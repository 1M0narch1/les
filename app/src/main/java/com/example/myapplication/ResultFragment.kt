package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentResultBinding
import kotlin.random.Random

class ResultFragment : Fragment() {

    private var min: String? = null
    private var max: String? = null

    lateinit var resultFragmentBinding : FragmentResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resultFragmentBinding = FragmentResultBinding.inflate(layoutInflater)

        arguments?.let {
            min = it.getString("minParam")
            max = it.getString("maxParam")
        }

        resultFragmentBinding.apply {

            generatedNumberText.text = (Random.nextInt(max!!.toInt()-min!!.toInt())+min!!.toInt())!!.toString()

            returnToStart.setOnClickListener{
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(id, StartFragment.newInstance(generatedNumberText.text.toString())).commit()
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return resultFragmentBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(min: String, max: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString("minParam", min)
                    putString("maxParam", max)
                }
            }
    }
}