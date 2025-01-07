package com.example.movieappkotlin.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.transformations
import coil3.transform.CircleCropTransformation
import com.example.movieappkotlin.model.Movie
import com.example.movieappkotlin.model.getMovies
import com.example.movieappkotlin.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?){

    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE), // Custom background color
                    titleContentColor = Color.White
                ),
                title = {
                    Row(horizontalArrangement = Arrangement.Start) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow back",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.width(16.dp)) // Adjusted spacing for better alignment
                        Text(text = "Movie Details")
                    }
                }
            )
        }
    ) { innerPadding ->
//        // Apply the padding provided by Scaffold
           Surface(modifier = Modifier
               .fillMaxHeight()
               .fillMaxWidth()
               .padding(innerPadding)) {

        Column (horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){

            MovieRow(movie = newMovieList.first())

            HorizontalDivider()
            Text(text = "Movie Images")
            HorizontalScrollableImages(newMovieList)

        }
    }
    }



}

@Composable
private fun HorizontalScrollableImages(newMovieList: List<Movie>) {
    LazyRow (){
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
//                Image(
//                    painter = rememberAsyncImagePainter(model = image),
//                    contentDescription = "Images"
//                )
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .crossfade(true) // Enable crossfade
                            .transformations(CircleCropTransformation()) // Apply CircleCrop transformation
                            .build(),

                        ),
                    contentDescription = "Movie Poster",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}