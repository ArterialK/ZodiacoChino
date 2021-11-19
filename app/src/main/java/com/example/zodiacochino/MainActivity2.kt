package com.example.zodiacochino

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val parametros = intent.extras
        val usuario = parametros?.getString("Nombre","Null")
        val anios = parametros?.getInt("Anios",0)
        val nc = parametros?.getInt("NumC", 0)
        val correo = parametros?.getString("Correo","Null")

        Toast.makeText(this, "Usuario recibido: $usuario",Toast.LENGTH_LONG).show()

        val tvFNombre = findViewById<TextView>(R.id.tvFName)
        val tvFEdad = findViewById<TextView>(R.id.tvFEdad)
        val tvFNC = findViewById<TextView>(R.id.tvFNC)
        val tvFCorreo = findViewById<TextView>(R.id.tvFCorreo)

        setImagen(parametros)

        tvFNombre.text = usuario
        tvFEdad.text = "$anios Años."
        tvFNC.text= "$nc"
        tvFCorreo.text= correo

    }

    @SuppressLint("SetTextI18n")
    private fun setImagen(parametros: Bundle?){
        val anioN = parametros?.getInt("AnioNacido",0)
        val ivFoto = findViewById<ImageView>(R.id.ivZodiaco)
        val tvHoroscopo = findViewById<TextView>(R.id.tvHoroscopo)
        when(anioN?.rem(12)) {
            0 -> { ivFoto.setImageResource(R.drawable.mono)
                    tvHoroscopo.text = getString(R.string.mono)}
            1 -> { ivFoto.setImageResource(R.drawable.gallo)
                    tvHoroscopo.text = getString(R.string.gallo)}
            2 -> { ivFoto.setImageResource(R.drawable.perro)
                    tvHoroscopo.text = getString(R.string.perro)}
            3 -> { ivFoto.setImageResource(R.drawable.cerdo)
                    tvHoroscopo.text = getString(R.string.cerdo)}
            4 -> { ivFoto.setImageResource(R.drawable.rata)
                    tvHoroscopo.text = getString(R.string.rata)}
            5 -> { ivFoto.setImageResource(R.drawable.buey)
                    tvHoroscopo.text = getString(R.string.buey)}
            6 -> { ivFoto.setImageResource(R.drawable.tigre)
                    tvHoroscopo.text = getString(R.string.tigre)}
            7 -> { ivFoto.setImageResource(R.drawable.conejo)
                    tvHoroscopo.text = getString(R.string.conejo)}
            8 -> { ivFoto.setImageResource(R.drawable.dragon)
                    tvHoroscopo.text = getString(R.string.dragon)}
            9 -> { ivFoto.setImageResource(R.drawable.serpiente)
                    tvHoroscopo.text = getString(R.string.serpiente)}
            10 -> { ivFoto.setImageResource(R.drawable.caballo)
                    tvHoroscopo.text = getString(R.string.caballo)}
            11 -> { ivFoto.setImageResource(R.drawable.cabra)
                    tvHoroscopo.text = getString(R.string.cabra)}
            else -> { ivFoto.setImageResource(R.drawable.emmm)
                    tvHoroscopo.text = getString(R.string.emmm)}
        }

    }
}