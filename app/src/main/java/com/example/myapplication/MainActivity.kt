package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    //TODO(Данное активити должно содержать два фрагмента, AnimalsFragment и AddAnimalFragment.
    // AnimalsFragment устанавливается по умолчанию, и содержит в себе RecyclerView, в котором будут
    // отображаться все добавленные питомцы(пока что будет достаточно просто при создании фрагмента
    // получать их их базы и заполнять recyclerView).
    // Так же AnimalsFragment содержит в себе две кнопки (пример их расположения будет на скриншоте),
    // по нажатию на Fab в нижнем правом углу должен открываться AddAnimalFragment(UI тоже будет на скриншоте),
    // в котором будут заполняться все необходимые данные и по нажатию на кнопку, сохраняться в базу данных)

    //TODO(Цвета и стили в UI необязательно делать как на скринах, проявите творчество))
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.FABOpenAddAnimalFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(binding.container.id,
                AddAnimalsFragment.newInstance()).commit()
        }
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().replace(binding.container.id, AnimalsFragment.newInstance()).commit()
    }


}