    package com.example.movieappkotlin.widgets

    import androidx.compose.animation.AnimatedVisibility
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.shape.CornerSize
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.AccountBox
    import androidx.compose.material.icons.filled.KeyboardArrowDown
    import androidx.compose.material.icons.filled.KeyboardArrowUp
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.Divider
    import androidx.compose.material3.HorizontalDivider
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Surface
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.RectangleShape
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.text.SpanStyle
    import androidx.compose.ui.text.TextRange
    import androidx.compose.ui.text.buildAnnotatedString
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.withStyle
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import coil3.Image
    import coil3.ImageLoader
    import coil3.compose.rememberAsyncImagePainter
    import coil3.request.ImageRequest
    import coil3.request.crossfade
    import coil3.request.transformations
    import coil3.transform.CircleCropTransformation
    import coil3.util.DebugLogger
    import com.example.movieappkotlin.model.Movie
    import com.example.movieappkotlin.model.getMovies

    @Preview
    @Composable
    fun MovieRow(movie: Movie = getMovies()[0], clickable: (String) -> Unit = {}){

        var expanded by remember {
            mutableStateOf(false)
        }

        Card(modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
//            .height(130.dp)
            .clickable {
                clickable(movie.id)
            },
            shape = RoundedCornerShape(CornerSize(size = 16.dp)),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(Color.White)) {
            Row (verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start ){

                Surface(modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                    shape = RectangleShape,
                    shadowElevation = 4.dp,
                    color = Color.Transparent
                )
                {

                    Image(
                        painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(movie.images[0])
                                .crossfade(true) // Enable crossfade
                                .transformations(CircleCropTransformation()) // Apply CircleCrop transformation
                                .build(),

                        ),
                        contentDescription = "Movie Poster",
                        modifier = Modifier.fillMaxSize()
                    )
    //                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie Image" )
                }
                Column (modifier = Modifier.padding(4.dp)){
                    Text(text = movie.title,
                        style = MaterialTheme.typography.headlineLarge)
                    Text(text = "Director: ${movie.director}",
                        style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Released: ${movie.year}",
                        style = MaterialTheme.typography.bodyMedium)


                    AnimatedVisibility(visible = expanded) {
                        Column {
                            Text(buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.DarkGray,
                                    fontSize = 13.sp)){
                                    append("Plot: ")
                                }
                                withStyle(style = SpanStyle(color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light)){
                                    append(movie.plot)
                                }
                            }, modifier = Modifier.padding(6.dp))

                            HorizontalDivider(modifier = Modifier.padding(6.dp))
                            Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodySmall )
                            Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.bodySmall)
                            Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.bodySmall)
                        }
                    }

                    Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Down Arrow",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                expanded = !expanded
                            },
                        tint = Color.DarkGray)
                }
            }

        }
    }
