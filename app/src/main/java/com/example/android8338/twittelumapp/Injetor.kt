package com.example.android8338.twittelumapp

object Injetor {

    private  val contexto = TwittelumAppication.getInstance()
    private val database = TwittelumDatabase.getInstance(contexto)

    fun tweetDao() = database.tweetDao()


}