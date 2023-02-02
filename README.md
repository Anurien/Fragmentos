# Fragmentos

En este repositorio veremos un ejercicio para fractivar Fragments con ViewModel en Kotlin. 
La aplicación consiste en una Main activity con dos botones que no redirigiran a los respectivos fragments. 
En cada uno de estos fragments podremos realizar una operación y devolver el resultado al MainActivity.

## MainActivity

En la MainActivity se encuentan todos los elementos del layout del main además de los observadores de las variables necesarias. 
Para poder visualizar los datos viewModel es necesario llamarlo dentro del onCreate en el main:

```
val viewModel by viewModels<MainViewModel>()
```
Y crear un observador para el live data en el modelo. En este ejemplo recogemos la variable resultado del viewModel y la mostramos
en una etiqueta en la MainActivity:

```
 viewModel.liveResultado.observe(
            this,
            Observer(
                fun(resultado: Int) {
                    val tvResultado: TextView = findViewById(R.id.resultado)
                    Log.d("qwe", tvResultado.text.toString())
                    tvResultado.text = "$resultado"

                }
            )
        )
```

## ViewModel

Aquí es donde se guardan los datos y se hacen las operaciones de la aplicación. Se instancian unas variables, se les asignan sus respectivos LiveData
para que la información quede almacenada y no se pierda cuando usemos el [ViewModel](https://github.com/GorillaGrip/Fragmentos/commit/f017fea8ed426bed8e681699cf65e40c6b826cc9).

## Fragment

En los fragment es donde queremos visualizar los numeros aleatorios y realizar las operaciones necesarias.
Para ello necesitaremos observadores para visualizar en el fragment las variables aleatorias generadas en el viewModel y para devolver el valor
del resultado de vuelva al viewModel. 

Esta clase tiene dos métodos, el onCreate y onCreateView. En esta primera clase es donde pondremos los observadores de las clases.
Y en el [onCreateView](https://github.com/GorillaGrip/Fragmentos/commit/2f030dbab1e2009546956ff26c736ae29daa8fd7#diff-3262557c6354e8dff503be6250078f5add1ab5a9bbea1a19af1514163e1b6dab) inicializaremos todos los componentes de la vista para que los recoja del layout:
```
 override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View {
        //Hay que poner esto aqui para que detecte el view sino los botones son nulos
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        val btnSalir = view.findViewById<Button>(R.id.salirR)
        val tvResultado = view.findViewById<EditText>(R.id.numeroresta)
        btnSalir?.setOnClickListener {
            Log.d("zxc",tvResultado?.text.toString())
            viewModel.result(Integer.valueOf(tvResultado?.text.toString()))

        }
        return view
    }
```

## Capturas del layout

![image](https://user-images.githubusercontent.com/91197967/216401260-b8e28dc8-bbc8-4b97-b696-25f59c06ae14.png)
![image](https://user-images.githubusercontent.com/91197967/216401605-ccbd8364-4b9c-4cd6-8b03-160daad78699.png)
![image](https://user-images.githubusercontent.com/91197967/216403009-7d1ed665-b626-449d-8295-e678ab1428e4.png)





