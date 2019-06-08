package com.example.android8338.twittelumapp

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context

@Database(entities = [Tweet::class],version = 2)
abstract class TwittelumDatabase:RoomDatabase() {
    abstract fun tweetDao():TweetDAO
    companion object {
        private var DataBase:TwittelumDatabase? = null
        private val  DATABASE = "twittelumDB"

        fun getInstance(context:Context):TwittelumDatabase{
            return DataBase ?: CriaBanco(context).also{ DataBase = it }
        }

        private fun CriaBanco(context:Context):TwittelumDatabase{
            return Room.databaseBuilder(context,TwittelumDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .addMigrations(Migration1Para2)
                .build()
        }

        object Migration1Para2 : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                val sql = "ALTER TABLE Tweet ADD COLUMN foto text"
                database.execSQL(sql)
            }
        }

    }


}