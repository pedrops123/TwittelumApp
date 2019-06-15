package com.example.android8338.twittelumapp.extensions

data class Usuario( val nome:String ,
                    val username:String,
                    val senha:String,
                    val foto:String? = null,
                    val id:Long
                   ) {
}