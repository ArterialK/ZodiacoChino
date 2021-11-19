package com.example.zodiacochino

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    //Bundle
    private val parametros = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun esunNombre(nombre: String): Boolean{
        if (nombre.isEmpty()){
            return false
        }else{
            var i = 0
            while(i < nombre.length){
                try {
                    nombre[i].digitToInt()
                    i += 1
                    return false
                }catch(e: IllegalArgumentException){
                    if (!nombre[i].isLetter() && nombre[i] != ' '){
                        return false
                    }
                    i += 1
                }
            }
        }
        return true
    }

    private fun esCorreo(cadena: String): Boolean{
        var i = 0
        var arrobaFlag = false
        var indexArroba = 0
        while (i < cadena.length){
            if(cadena[i] == ' '){
                return false
            }
            if(cadena[i] == '@'){
                if(i != 0) {// El arroba no esta al inicio
                    if (i < (cadena.length - 1)) { //El arroba no esta al final
                        arrobaFlag = true //El arroba es aprobado
                        indexArroba = i
                    }
                }
            }
            if(cadena[i] == '.' && arrobaFlag){
                if(i < (cadena.length - 2)){ // Si el punto no esta al final
                    if (i != (indexArroba+1)){  // Si el punto no esta despues del arroba
                        return true
                    }
                }
            }
            i +=1
        }
        return false
    }

    private fun obtenerEdad(){
        val etFecha = findViewById<EditText>(R.id.etDate)
        val fecha: Date = SimpleDateFormat("dd/MM/yyyy").parse(etFecha.text.toString())
        val fechaActual = Date(System.currentTimeMillis())
        val diferenciaFecha = fechaActual.time - fecha.time
        val segundos = diferenciaFecha/1000
        val minutos = segundos / 60
        val horas = minutos / 60
        val dias = horas / 24
        val anios = dias / 365
        parametros.putInt("Anios", anios.toInt())
    }


    fun putch(view: View) {
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etNumeroC = findViewById<EditText>(R.id.etNumeroC)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val intent = Intent(this, MainActivity2:: class.java)
        var correctoFlag = true
        val nombre: String
        val numeroCuenta: Int
        val correo: String

        //Condicion para aprobar nombre
        if(!esunNombre(etNombre.text.toString())){
            etNombre.error = getString(R.string.eNombre)
            correctoFlag = false}
        else{
            nombre = etNombre.text.toString()
            parametros.putString("Nombre", nombre) }

        //Condicion para aprobar numero de cuenta
        if(etNumeroC.text.toString().length < 9){
            etNumeroC.error = getString(R.string.eNC)
            correctoFlag = false}
        else{
            numeroCuenta = etNumeroC.text.toString().toInt()
            parametros.putInt("NumC", numeroCuenta) }
        //Condicion para aprobar correo
        if(!esCorreo(etCorreo.text.toString())){
            etCorreo.error = getString(R.string.eCorreo)
            correctoFlag = false}
        else{
            correo = etCorreo.text.toString()
            parametros.putString("Correo", correo) }

        if (correctoFlag){
            intent.putExtras(parametros)
            startActivity(intent)
        }
    }

    fun calendario(view: View) {
        val datePicker = LlamarCalendario { day, month, year -> diaSeleccionado(day,month, year)}
        datePicker.show(supportFragmentManager,  "datePiker")
    }

    @SuppressLint("SetTextI18n")
    private fun diaSeleccionado(day: Int, month: Int, year: Int) {
        val anioActual = Calendar.getInstance().get(Calendar.YEAR)
        val diaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val mesActual = Calendar.getInstance().get(Calendar.MONTH)
        val etFecha = findViewById<EditText>(R.id.etDate)
        etFecha.text.clear()
        parametros.putInt("AnioNacido", year)
        if (year > anioActual || year < (anioActual - 110)) {
            Toast.makeText(this, getString(R.string.eFecha), Toast.LENGTH_LONG).show()
            etFecha.text.clear()
        } else if (year == anioActual) {
            if (day > diaActual && month >= mesActual) {
                Toast.makeText(this, getString(R.string.eFecha), Toast.LENGTH_LONG).show()
                etFecha.text.clear() }
            else {
                etFecha.setText("${day}/${month + 1}/${year}")
                obtenerEdad()}
        } else {
            etFecha.setText("${day}/${month + 1}/${year}")
            obtenerEdad()}
    }
}


























