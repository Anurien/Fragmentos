package com.example.ejemplof

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplof.ui.main.MainViewModel
import com.example.ejemplof.ui.main.MultiFragment
import com.example.ejemplof.ui.main.SumaFragment
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    val otraClase by viewModels<MainViewModel>()
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val btnSuma: Button = findViewById(R.id.button2)
        val btnResta: Button = findViewById(R.id.button)
        btnSuma.setOnClickListener { replaceFragment(SumaFragment()) }
        btnResta.setOnClickListener { replaceFragment(MultiFragment()) }

        otraClase.liveResultado.observe(
            this,
            Observer(
                fun(resultado: Int) {
                    GlobalScope.launch(Dispatchers.Main) {
                        if (resultado > 0) {
                            val tvResultado: TextView = findViewById(R.id.resultado)
                            tvResultado.text = "$resultado"
                            Log.d("fgh", tvResultado.text.toString())
                        }

                    }
                }
            )
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}