package com.example.android8338.twittelumapp
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.android8338.twittelumapp.Fragments.BuscadorDeTweetsFragment
import com.example.android8338.twittelumapp.Fragments.ListaTweetsFragments
import kotlinx.android.synthetic.main.main_activity.*

class main_activity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        exibe(ListaTweetsFragments())
        listenerBottomNavigation()

    }

    private fun listenerBottomNavigation(){
        bottom_navigation.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId){

                R.id.menu_tweets -> {
                    exibe(ListaTweetsFragments())
                    true
                }
                R.id.menu_busca -> {
                    exibe(BuscadorDeTweetsFragment())
                    true
                }
                else -> {

                false
              }
            }
        }
    }

    private fun exibe (fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_principal,fragment)
        transaction.commit()
    }



}