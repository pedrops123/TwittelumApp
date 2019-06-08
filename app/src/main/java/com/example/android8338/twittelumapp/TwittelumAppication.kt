package com.example.android8338.twittelumapp

import android.app.Application

class TwittelumAppication:Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
    companion object {
        private lateinit var instance:TwittelumAppication

        fun getInstance() = instance
    }


}