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

        fun GetBatteryLevel(context : Context):String{
            val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            val batteryStatus = registerReceiver(null, ifilter)

            val level = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

            val batteryPct = level / scale.toFloat()

            return (batteryPct * 100).toString()
        }

        binding.BatteryChargeButton.setOnClickListener{
            binding.BatteryChargeTV.text = GetBatteryLevel(this)
        }

        binding.SuppotPixelPhoneButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en"))
            startActivity(intent)
        }
    }
}