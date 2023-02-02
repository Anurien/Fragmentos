package com.example.ejemplof.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.ejemplof.R

class MultiFragment : Fragment() {

    companion object {
        fun newInstance() = MultiFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
        viewModel.livenum1.observe(
            this,
            Observer(
                fun(num1: Int) {
                    val tvNum1 = view?.findViewById<TextView>(R.id.resta1)

                    tvNum1?.text = "Num1:  $num1"
                }
            )
        )
        viewModel.livenum2.observe(
            this,
            Observer(
                @SuppressLint("SetTextI18n")
                fun(num2: Int) {
                    val tvNum2 = view?.findViewById<TextView>(R.id.resta2)

                    tvNum2?.text = "Num2:  $num2"
                }
            )
        )
        /*val tvResultado = view?.findViewById<EditText>(R.id.numerosuma)
        val btnSalir = view?.findViewById<Button>(R.id.button)
        btnSalir?.setOnClickListener {
            viewModel.result(Integer.valueOf(tvResultado?.text.toString()))
        }*/

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}