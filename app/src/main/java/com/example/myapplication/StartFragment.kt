package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var lastGenerateNumber: String? = null

    lateinit var StartFragmentBinding : FragmentStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        StartFragmentBinding = FragmentStartBinding.inflate(layoutInflater)

        arguments?.let {
            lastGenerateNumber = it.getString("lastGenerateNumber")
        }

        StartFragmentBinding.apply {

            lastGenerateNumberText.text = lastGenerateNumber

            buttonGenerateNumber.setOnClickListener {
                if(editMinGenerateNumber.text.toString().isEmpty()
                    && editMaxGenerateNumber.text.toString().isEmpty())
                    validationTextView.text = "Введены неверные значения"
                else if(editMaxGenerateNumber.text.toString().toInt()<editMinGenerateNumber.text
                        .toString().toInt())
                    validationTextView.text = "Введены неверные значения"
                else{
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(id, ResultFragment.newInstance(editMinGenerateNumber.text.toString(),
                            editMaxGenerateNumber.text.toString())).commit()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return StartFragmentBinding.root
    }


    companion object {

        @JvmStatic
        fun newInstance(lastGenerateNumber: String) =
            StartFragment().apply {
                arguments = Bundle().apply {
                    putString("lastGenerateNumber", lastGenerateNumber)
                }
            }
    }
}