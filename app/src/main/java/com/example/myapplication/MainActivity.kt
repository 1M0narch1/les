package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        //Для функций в Kotlin принято использовать camelCase
        //И функциями внутри функций лучше пользоваться в крайних случаях, 
        //когда необходимы либо общие переменные, либо она выполняет подфункцию первоначальной функции
        //context мы передаем в функцию для чего ?) 
        //Пока мы находимся в классе активности, мы можем работать с ним из любых функций, поэтому его явная передача не обязательна
        fun GetBatteryLevel(context : Context):String{
            //Идея очень хорошая, которая позволяет при изменении количества процентов реагировать и отображать 
            // актуальное значение
            //Но она немного не корректно реализована: 
                // 1) При каждом нажатии на кнопку мы будет регистрировать активности новый BroadcastReceiver, 
                //что довольно бьет по производительности, поэтому такие функциии лучше вызывать один раз
                // 2) Вместо передачи null в метод, можно было создать один раз в onCreate объект BroadcastReceiver()
                //и переопределить у него метод onReceive, который бы содержал код с getIntentExtra, вычислением процентов
                // и отображении актуального значения
                //Соответственно у нас бы был один reveiver, который в main потоке слушал изменения батареи и вызывался метод onReceive
            val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            val batteryStatus = registerReceiver(null, ifilter)

            val level = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

            val batteryPct = level / scale.toFloat()

            return (batteryPct * 100).toString()
        }
        //Рекомендация
        //Здесь можно было обернуть в scope функцию with()
        //Удобно, так как не приходится постоянно писать binding.name
        /*
        with(binding) {
            BatteryChargeButton.setOnClickListener{
                binding.BatteryChargeTV.text = GetBatteryLevel(this)
            }

            SuppotPixelPhoneButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en"))
                startActivity(intent)
            }
        }
        */
        //Для id View внутри xml в Android принято использовать такой стиль: battery_charge_button и тд.
        binding.BatteryChargeButton.setOnClickListener{
            binding.BatteryChargeTV.text = GetBatteryLevel(this)
        }

        binding.SuppotPixelPhoneButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en"))
            startActivity(intent)
        }
    }
}
