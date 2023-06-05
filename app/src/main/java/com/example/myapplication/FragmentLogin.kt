package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.myapplication.databinding.FragmentLoginBinding


class FragmentLogin : Fragment() {

    //Не используется
    private var param1: String? = null

    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Продолжаешь инициализировать биндинг в onCreate)
//        loginBinding = FragmentLoginBinding.inflate(layoutInflater)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")
        }
        loginBinding.apply {
            loginButton.setOnClickListener {
                if(!textInputEditLogin.text!!.isEmpty() && !textInputEditPassword.text!!.isEmpty()){
                    //requireContext() - для получения контекста во фрагменте
                    //setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)) интересное решение, можно было также вызвать requireActivity().finish()
                    startActivity(Intent(activity!!.applicationContext, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater)
        return loginBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                }
            }
    }
}