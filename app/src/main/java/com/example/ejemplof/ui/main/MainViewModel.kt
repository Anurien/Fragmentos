package com.example.ejemplof.ui.main

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlin.math.floor


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var num1 = floor(Math.random() * 10).toInt()
    private var num2 = floor(Math.random() * 10).toInt()
    private var resultado = 0;
    /*private val somethingLiveData = MutableLiveData<Int>()
    val something: LiveData<Int>
        get() = somethingLiveData

    fun load() {
        // Ok to call postValue here either inside or outside a coroutine
        viewModelScope.launch {
            somethingLiveData.postValue(floor(Math.random() * 10).toInt())
        }
    }
*/

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
        liveResultado.value = resultado
        Log.d("asdf", liveResultado.value.toString())

    }

    /*
    Actualiza el resultado introducido a traves de la interfaz
    @param: el valor introducido
     */
    fun result(item: Int) {
        liveResultado.value = item
        resultado = item
        Log.d("asd", liveResultado.value.toString())
        Toast.makeText(context, liveResultado.value.toString(), Toast.LENGTH_SHORT)
            .show()

    }

}