package com.example.android8338.twittelumapp.Fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.SearchView
import com.example.android8338.twittelumapp.*
import kotlinx.android.synthetic.main.lista_tweets_fragment.*

class BuscadorDeTweetsFragment : Fragment() {

    private val viewModel:TweetViewModel by lazy {

        ViewModelProviders.of(activity!!,ViewModelFactory).get(TweetViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //setHasOptionsMenu(true)
        return inflater.inflate(R.layout.lista_tweets_fragment,container,false)
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {

        inflater?.inflate(R.menu.buscador_menu,menu)

        val botaoBusca = menu?.findItem(R.id.barra_busca)
        val search = botaoBusca?.actionView as SearchView

        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(texto: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(texto: String?): Boolean {

                if(!texto.isNullOrEmpty()){
                    val filtrados = filtraTweetsPelo(texto)
                    lista_tweets.adapter = TweetAdapter(filtrados)
                }

                return false
            }

        })
    }

    private fun filtraTweetsPelo(texto:String?):List<Tweet>{
        val tweets = viewModel.tweets()
        val tweetsFiltrados = tweets.filter{
            tweet -> tweet.mensagem.contains(texto!!,true)
        }
        return tweetsFiltrados
    }



}