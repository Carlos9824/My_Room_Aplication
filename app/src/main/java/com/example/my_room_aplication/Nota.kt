package com.example.my_room_aplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val titulo:String,
    val contenido:String
)