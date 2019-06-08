package com.example.android8338.twittelumapp

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TweetDAO {

    @Insert
    fun salva(tweet: Tweet)

    @Query("SELECT * FROM Tweet")
    fun listar():LiveData<List<Tweet>>

    @Delete
    fun deleta(tweet: Tweet)

}