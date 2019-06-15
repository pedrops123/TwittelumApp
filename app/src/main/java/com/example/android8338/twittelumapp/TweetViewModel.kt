package com.example.android8338.twittelumapp

import android.arch.lifecycle.ViewModel
import com.example.android8338.twittelumappdecodifica.TweetRepository

class TweetViewModel(private val repository: TweetRepository):ViewModel() {

    fun listar() = repository.listar()

    fun salvar(tweet:Tweet) = repository.salvar(tweet)

    fun deleta (tweet:Tweet) = repository.deleta(tweet)

    fun tweets():List<Tweet> = listOf(
        Tweet("bla",null),
        Tweet("ble",null),
        Tweet("bli",null),
        Tweet("blo",null),
        Tweet("blu",null)

    )

}