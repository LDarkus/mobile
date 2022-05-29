package com.example.filmsapp

import android.content.Context
import android.preference.PreferenceManager
import java.util.prefs.PreferenceChangeEvent

@Suppress("DEPRECATION")
class SaveShared {
    companion object{
        fun setFavorite(context: Context,key:String,value:Boolean) {
            val setFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            setFavoriteShared.edit().putBoolean(key,value).apply()
        }

        fun getFavorite(context: Context,key:String) :Boolean {
            val getFavoriteShared = PreferenceManager.getDefaultSharedPreferences(context)
            return getFavoriteShared.getBoolean(key,false)
        }
    }
}