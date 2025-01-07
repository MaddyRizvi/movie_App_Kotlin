package com.example.movieappkotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappkotlin.screens.home.HomeScreen
import com.example.movieappkotlin.screens.details.DetailsScreen


@Composable
fun MovieNavigation(){
    // Creating Nav Controller
    val navController = rememberNavController()

    //Creating Nav Host
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){

    //Here we pass the Graph
        composable(MovieScreens.HomeScreen.name){
            // here we pass where this should lead
            HomeScreen(navController = navController)
        }
        // DetailsScreen/id324
        composable(MovieScreens.DetailsScreen.name+"/{movieData}",
            arguments = listOf(navArgument(name = "movieData"){type= NavType.StringType})){
            backStackEntry ->

            DetailsScreen(navController = navController, movieId = backStackEntry.arguments?.getString("movieData"))
        }
    }
}





