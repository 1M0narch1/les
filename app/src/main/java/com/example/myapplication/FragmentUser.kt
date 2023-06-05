package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentUserBinding

class FragmentUser : Fragment() {

    private var param1: String? = null

    lateinit var userBinding :FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")
        }
        //Видимо забыл передать userName и отобразить его
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        userBinding = FragmentUserBinding.inflate(layoutInflater)
        return userBinding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String) =
            FragmentUser().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                }
            }
    }
}