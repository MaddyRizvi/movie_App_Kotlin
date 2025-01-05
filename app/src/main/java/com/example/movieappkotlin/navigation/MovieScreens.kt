package com.example.movieappkotlin.navigation

import android.graphics.Movie
import android.telecom.Call.Details
import androidx.compose.runtime.internal.illegalDecoyCallException


enum class MovieScreens{
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route" +
                    "$route is not recognized ")
        }
    }
}





