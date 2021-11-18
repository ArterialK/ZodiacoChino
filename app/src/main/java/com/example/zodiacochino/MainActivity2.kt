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
                    tvHoroscopo.text = "Mono"}
            1 -> { ivFoto.setImageResource(R.drawable.gallo)
                    tvHoroscopo.text = "Gallo"}
            2 -> { ivFoto.setImageResource(R.drawable.perro)
                    tvHoroscopo.text = "Perro"}
            3 -> { ivFoto.setImageResource(R.drawable.cerdo)
                    tvHoroscopo.text = "Cerdo"}
            4 -> { ivFoto.setImageResource(R.drawable.rata)
                    tvHoroscopo.text = "Rata"}
            5 -> { ivFoto.setImageResource(R.drawable.buey)
                    tvHoroscopo.text = "Buey"}
            6 -> { ivFoto.setImageResource(R.drawable.tigre)
                    tvHoroscopo.text = "Tigre"}
            7 -> { ivFoto.setImageResource(R.drawable.conejo)
                    tvHoroscopo.text = "Conejo"}
            8 -> { ivFoto.setImageResource(R.drawable.dragon)
                    tvHoroscopo.text = "Dragón"}
            9 -> { ivFoto.setImageResource(R.drawable.serpiente)
                    tvHoroscopo.text = "Serpiente"}
            10 -> { ivFoto.setImageResource(R.drawable.caballo)
                    tvHoroscopo.text = "Caballo"}
            11 -> { ivFoto.setImageResource(R.drawable.cabra)
                    tvHoroscopo.text = "Cabra"}
            else -> { ivFoto.setImageResource(R.drawable.emmm)
                    tvHoroscopo.text = "No se pudo"}
        }

    }
}