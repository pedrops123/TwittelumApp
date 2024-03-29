package com.example.android8338.twittelumapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android8338.twittelumapp.extensions.Carregador
import kotlinx.android.synthetic.main.item_tweet.view.*

class TweetAdapter(private val tweets : List<Tweet>):BaseAdapter() {

    override fun getItemId(position: Int): Long {
        return 1;
    }

    override fun getCount(): Int {
        return tweets.size
    }

    override fun getItem(position: Int): Any {
        return tweets[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val tweet = tweets[position]
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.item_tweet,parent,false)

        view.item_conteudo.text = tweet.mensagem

        tweet.foto?.let {
            view.item_foto.visibility = View.VISIBLE
            view.item_foto.setImageBitmap(Carregador.decodifica(it))
        }
        return view
    }
}