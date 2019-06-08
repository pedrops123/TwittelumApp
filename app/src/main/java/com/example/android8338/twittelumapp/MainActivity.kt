package com.example.android8338.twittelumapp

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.android8338.twittelumapp.extensions.decodificaParaBase64
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File



class MainActivity : AppCompatActivity() {


    private var LocalFoto:String? = null;

    private val viewModel:TweetViewModel by lazy {
        ViewModelProviders.of(this,ViewModelFactory).get(TweetViewModel::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.tweet_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {

            R.id.tweet_menu_cadastrar -> {
                PublicaTweet()
            }

            R.id.tweet_menu_foto->{
                tiraFoto()
            }

            android.R.id.home -> finish()

        }
        return true
    }

    fun defineCaminhoFoto():Uri?{
        LocalFoto = "${getExternalFilesDir("fotos")}/${System.currentTimeMillis()}.jpg"
        val arquivo = File(LocalFoto)
        return FileProvider.getUriForFile(this,"MeuProvider",arquivo)
    }

    private fun tiraFoto(){
            val vaiPraCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             val caminhoFoto = defineCaminhoFoto();
            vaiPraCamera.putExtra(MediaStore.EXTRA_OUTPUT,caminhoFoto)
            startActivityForResult(vaiPraCamera,123);
        }

    private fun PublicaTweet(){
                val MensagemTWeet = msgBox.text.toString()
                //val valorTweetTexto = Tweet(MensagemTWeet)
                val tweet = CriaTweet()
                viewModel.salvar(tweet)
                Toast.makeText(this,"O Tweet foi salvo com sucesso ! ",Toast.LENGTH_LONG).show()
                finish()
        }

    /*
    override fun onResume() {
        super.onResume()
        if(LocalFoto != null){
            carregaFoto()
        }
    }
*/

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123){
            if(resultCode == Activity.RESULT_OK){
                carregaFoto()
            }
        }
    }

    private fun carregaFoto(){
        val  bitmap = BitmapFactory.decodeFile(LocalFoto)
        val bm = Bitmap.createScaledBitmap(bitmap,bitmap.width,bitmap.width,true)
        tweet_foto.setImageBitmap(bm)
        val fotoNaBase64 = bm.decodificaParaBase64()
        tweet_foto.tag = fotoNaBase64
        tweet_foto.scaleType = ImageView.ScaleType.FIT_XY
    }

    fun CriaTweet():Tweet{
        val campoDeMensagemDoTweet = findViewById<EditText>(R.id.msgBox)
        val mensagemDoTweet : String = campoDeMensagemDoTweet.text.toString()
        val foto :String? = tweet_foto.tag as String?
        return Tweet(mensagemDoTweet,foto)
    }

}









