package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        startActivity(Intent(this, AuthActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().replace(mainBinding.container.id, FragmentLogin.newInstance("No generate")).commit()
    }
}