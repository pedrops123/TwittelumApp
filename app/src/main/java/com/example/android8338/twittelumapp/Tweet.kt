package com.example.android8338.twittelumapp

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Tweet(

    val mensagem:String,
    val foto:String?,
    @PrimaryKey(autoGenerate = true) val id:Int =  0

) {
    override fun toString(): String {
        return mensagem
    }

}