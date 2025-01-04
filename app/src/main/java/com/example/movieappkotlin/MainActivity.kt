package com.example.movieappkotlin

import android.graphics.Movie
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappkotlin.ui.theme.MovieAppKotlinTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppKotlinTheme {
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
                    MainContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
private fun MainContent(modifier: Modifier = Modifier,
                        movieList: List<String> = listOf(
                    "Avatar",
                    "300",
                    "X-Men",
                    "Logan"
                )) {
    Surface {
        Column(
            modifier = modifier.fillMaxSize()) {
            LazyColumn {
                items(items = movieList){
                    Text(text = it)
                }
            }
        }// Add padding to prevent text from being stuck to the edges
    }
}

@Composable
fun MovieRow(movie: String){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppKotlinTheme {
        MainContent()
    }
}