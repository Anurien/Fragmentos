package com.example.ejemplof

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ejemplof.ui.main.MultiFragment
import com.example.ejemplof.ui.main.SumaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSuma: Button = findViewById(R.id.button)
        val btnResta: Button = findViewById(R.id.button2)
        btnSuma.setOnClickListener { replaceFragment(SumaFragment()) }
        btnResta.setOnClickListener { replaceFragment(MultiFragment()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}