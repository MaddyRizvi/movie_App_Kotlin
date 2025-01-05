package com.example.movieappkotlin.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import com.example.movieappkotlin.MainContent
import com.example.movieappkotlin.MovieRow
import com.example.movieappkotlin.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Custom App Bar") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE), // Custom background color
                    titleContentColor = Color.White // Custom text color
                )
            )
        }) { innerPadding ->
        MainContent(navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun MainContent(navController: NavController,
                        modifier: Modifier = Modifier,
                        movieList: List<String> = listOf(
                            "Gladiator",
                            "300",
                            "X-Men",
                            "Logan",
                            "Life is Beautiful",
                            "Taken",
                            "Dil Dil",
                            "300"
                        )) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)) {
        LazyColumn {
            items(items = movieList){
                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
//                    Log.d("Movies", "$movie")
                }
            }
        }
    }// Add padding to prevent text from being stuck to the edges

}
