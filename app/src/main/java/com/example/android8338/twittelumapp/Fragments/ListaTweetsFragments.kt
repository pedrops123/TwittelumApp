package com.example.android8338.twittelumapp.Fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android8338.twittelumapp.R
import com.example.android8338.twittelumapp.TweetAdapter
import com.example.android8338.twittelumapp.TweetViewModel
import com.example.android8338.twittelumapp.ViewModelFactory
import kotlinx.android.synthetic.main.lista_tweets_fragment.view.*

class ListaTweetsFragments :Fragment() {

    private val viewModel:TweetViewModel by lazy {

        ViewModelProviders.of(activity!!,ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.lista_tweets_fragment,container,false)
        val lista = viewModel.tweets()
        view.lista_tweets.adapter = TweetAdapter(lista)
        return view

    }





}