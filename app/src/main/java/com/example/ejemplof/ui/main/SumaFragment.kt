package com.example.ejemplof.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ejemplof.R

class SumaFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Para que el fragment actualice el valor del textview hay que poner requireActivity
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        // Observadores para recoger las variables del viewmodel
        viewModel.livenum1.observe(
            this,
            Observer(
                @SuppressLint("SetTextI18n")
                fun(num1: Int) {
                    val tvNum1 = view?.findViewById<TextView>(R.id.suma1)

                    tvNum1?.text = "$num1"
                }
            )
        )
        viewModel.livenum2.observe(
            this,
            Observer(
                @SuppressLint("SetTextI18n")
                fun(num2: Int) {
                    val tvNum2 = view?.findViewById<TextView>(R.id.suma2)

                    tvNum2?.text = "$num2"
                }
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View {
        //Hay que poner esto aqui para que detecte el view sino los botones son nulos
        val view: View = inflater.inflate(R.layout.fragment_suma, container, false)
        val btnSalir = view.findViewById<Button>(R.id.salirS)
        val tvResultado = view.findViewById<EditText>(R.id.numerosuma)
        btnSalir?.setOnClickListener {
            Log.d("zxc", tvResultado?.text.toString())
            if(tvResultado.text != null){
                viewModel.result(Integer.parseInt(tvResultado?.text.toString()))
            }

        }
        return view
    }
}