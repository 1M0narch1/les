package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import kotlinx.coroutines.*
import com.example.myapplication.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
//import androidx.lifecycle.lifecycleScope
import kotlin.random.Random

class RxJavaWorkShop : AppCompatActivity() {

    private var TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO 1 По нажатию на кнопку button, необходимо вызывать метод startRSStream
        binding.buttonnn.setOnClickListener { startRStream() }

    }

    private fun startRStream() {

        //TODO 2 Реализуйте метод getObservable, который должен возвращать Observable<String>.
        // Observable должен испускать 5 чисел от 5 до 1.
        val myObservable = getObservable()

        //TODO 3 Реализуйте метод getObserver, который должен возвращать Observer<String>.
        // В методе создайте и верните анонимный объект Observer(object : Observer<String>) и переопределите
        // необходимые методы. В каждом переопределенном методе выводите Toast с названием переопределенного метода.
        // В методе onNext, Toast должен выводить число, которое пришло из Observable.
        val myObserver = getObserver()

        //TODO 4 Имея myObservable и myObserver, произведите подписку(subscribe). Observable должен выполняться
        // в фоновом потоке, а обработка значений Observer в Main потоке.

        myObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(myObserver)

    }




    private fun getObserver() : Observer<String> {
        return object : Observer<String>{

            override fun onSubscribe(d: Disposable) {
                Toast.makeText(this@RxJavaWorkShop, "onSubscribe", Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
                Toast.makeText(this@RxJavaWorkShop, "onError", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                Toast.makeText(this@RxJavaWorkShop, "onComplete", Toast.LENGTH_SHORT).show()
            }

            override fun onNext(t: String) {
                Toast.makeText(this@RxJavaWorkShop, t, Toast.LENGTH_SHORT).show()
            }

        }
    }


   private fun getObservable() =
       Observable.just("1","2","3","4","5")


}
