package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    lateinit var authBinding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authBinding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(authBinding.root)
        supportFragmentManager.beginTransaction().replace(authBinding.container.id, FragmentLogin.newInstance("")).commit()
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

}