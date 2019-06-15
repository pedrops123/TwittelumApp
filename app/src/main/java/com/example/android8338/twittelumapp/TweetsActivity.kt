package com.example.android8338.twittelumapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_tweets.*

class TweetsActivity : AppCompatActivity() {

    private val ViewModel:TweetViewModel by lazy {

        ViewModelProviders.of(this,ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweets)

        ViewModel.listar().observe(this,observer())

        buttonId.setOnClickListener { abreComentariosTweet() }

        val listener  = AdapterView.OnItemClickListener{
            adapter ,item, posicao, id ->

            val tweet = listaMain.getItemAtPosition(posicao) as Tweet
            validaDeletarTweet(tweet)

        }
        listaMain.onItemClickListener = listener

    }

    private fun validaDeletarTweet(tweet: Tweet){
        val dialog = AlertDialog.Builder(this)
        dialog.setMessage("Deseja realmente apagar o tweet ?")
        dialog.setTitle("Atenção !")
        dialog.setPositiveButton("Sim") {_:DialogInterface,_:Int -> ViewModel.deleta(tweet) }
        dialog.setNegativeButton("Não",null)
        dialog.show()
    }

    private fun observer():Observer<List<Tweet>>{
        return Observer {  //tweets ->
            //listaMain.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tweets )
            var teste = TweetAdapter(it!!)
            listaMain.adapter = TweetAdapter(it!!)
        }
    }

/*

    override fun onResume() {
        super.onResume()
        //val tweets: List<String> = listOf("teste1", "teste2", "teste3", "teste4", "teste5")
        val tweetDAO = TwittelumDatabase.getInstance(this).tweetDao()
        val tweets: List<Tweet> = tweetDAO.listar()

        val ListaAdapter = ArrayAdapter<Tweet>(this, android.R.layout.simple_list_item_1, tweets)

        listaMain.adapter = ListaAdapter
    }
*/
    fun abreComentariosTweet(){

        var intent =  Intent(this , ListaActivity::class.java)
        startActivity(intent)

    }
}