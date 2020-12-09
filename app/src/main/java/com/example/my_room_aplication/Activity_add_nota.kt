package com.example.my_room_aplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class Activity_add_nota : AppCompatActivity() {
    var editTitulo: EditText?=null
    var editContenido: EditText?=null
    var btnAdd: Button?=null

    val app = applicationContext as NotaApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)

        editTitulo = findViewById(R.id.editText)
        editContenido = findViewById(R.id.editContenido)
        btnAdd = findViewById(R.id.btnAdd)


        btnAdd!!.setOnClickListener{
            val title = editTitulo!!.text.toString()
            val content = editContenido!!.text.toString()

            val nota = Nota( 0,title, content)
            val notas = listOf<Nota>()

            lifecycleScope.launch {
                app.room.notaDao().insert(notas)
            }

            editTitulo!!.setText("")
            editContenido!!.setText("")
        }
    }
}