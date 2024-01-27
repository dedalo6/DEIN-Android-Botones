package com.example.botonesdearitzperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val numBotones = 10
    private lateinit var llBotonera: LinearLayout // Se usa lateinit para las variables que no es necesarion iniciar al cargar la clase
                                                  // Por ejemplo si las vas a iniciar en onCreate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llBotonera = findViewById(R.id.llBotonera)

        //Creamos las propiedades de layout que tendrán los botones.
        val lp = LinearLayout.LayoutParams( //Aqui definimos el height y el width
            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.MATCH_PARENT, (Height)
            resources.getDimensionPixelSize(R.dimen.button_height)
        )

        //Creamos los botones en bucle

        for (i in 0 until numBotones) {

            val button = Button(this)
            //Asignamos propiedades de layout al botón
            button.layoutParams = lp
            //Asignamos Texto al botón
            button.text =
                "Botón " + String.format("%02d", i) //se espera un número (d para decimal),
            // y se mostrará con al menos 2 dígitos, rellenando con ceros a la izquierda si es necesario (%02d).

            //Asignamos el Listener
            button.setOnClickListener(buttonClickListener(i))

            llBotonera.addView(button) //.addView añade una vista (el button) a un layout (que es otra vista)
        }
    }
    //Definimos la variable random fuera del metodo para que no la cambie cada vez que crea un boton
    var i_boton_especial = (Math.random() * numBotones).toInt()

    private fun buttonClickListener(index: Int): View.OnClickListener { //View.OnClickListener es la clase para definir los OnClickListener
        return View.OnClickListener {
            if (index == i_boton_especial) {
                Toast.makeText(
                    this@MainActivity,
                    "ME HAS ENCONTRADO!! " + i_boton_especial.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    this@MainActivity,
                    "Sigue buscando "  + i_boton_especial.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }
}