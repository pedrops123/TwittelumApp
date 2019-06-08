package com.example.android8338.twittelumappdecodifica

import com.example.android8338.twittelumapp.Tweet
import com.example.android8338.twittelumapp.TweetDAO

class TweetRepository(private val fontDeDados:TweetDAO) {


    fun listar() = fontDeDados.listar()
    fun salvar(tweet: Tweet) = fontDeDados.salva(tweet)
    fun deleta (tweet: Tweet) = fontDeDados.deleta(tweet)

}