package com.example.ejemplof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplof.ui.main.MainViewModel
import com.example.ejemplof.ui.main.MultiFragment
import com.example.ejemplof.ui.main.SumaFragment

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    val otraClase by viewModels<MainViewModel>()

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
                    Log.d("fghj", resultado.toString())
                    val tvResultado: TextView = findViewById(R.id.resultado)
                    tvResultado.text = "Result: $resultado"
                    Log.d("fgh", tvResultado.text.toString())

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