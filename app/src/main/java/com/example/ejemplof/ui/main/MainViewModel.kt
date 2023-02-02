package com.example.ejemplof.ui.main

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlin.math.floor

@OptIn(DelicateCoroutinesApi::class)
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var num1 = floor(Math.random() * 10).toInt()
    private var num2 = floor(Math.random() * 10).toInt()
    private var resultado: Int = 0;


    // para poder utilizar toast en el view
    @SuppressLint("StaticFieldLeak")
    private val context: Context = getApplication<Application>().applicationContext

    // El MutableLiveData almacena la información para que no se pierda, cuando estamos usando los ViewModel
    var livenum1 = MutableLiveData<Int>()
    var livenum2 = MutableLiveData<Int>()
    var liveResultado = MutableLiveData<Int>()

    init {

        livenum1.value = num1
        livenum2.value = num2
        result(resultado)
        liveResultado.value = resultado

    }

    fun result(item: Int) {
        liveResultado.value = item
        Log.d("asd", liveResultado.value.toString())

    }
}