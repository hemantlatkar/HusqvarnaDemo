package com.example.husqvarnatest.presentation.ui.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.husqvarnatest.R
import com.example.husqvarnatest.domain.models.moviespopular.MoviePopularDetailsD
import com.example.husqvarnatest.presentation.navigation.NavRoute
import com.example.husqvarnatest.presentation.ui.theme.TestTheme
import com.example.husqvarnatest.presentation.utils.URLConstants.MOVIEDB_BASE_IMAGE_URL
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import java.util.*

@Composable
fun MovieItem(navController: NavController, item: MoviePopularDetailsD) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(2.dp)
            .clickable {
                navController.navigate(NavRoute.DetailsMovie.route + "/${item.id}")
            },
        border = BorderStroke(2.dp, Color.Blue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(0.dp, 500.dp)
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(300.dp),
                painter = rememberAsyncImagePainter(
                    MOVIEDB_BASE_IMAGE_URL + item.poster_path
                ),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = item.title.uppercase(Locale.getDefault()),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(id = R.string.date_released),
                    fontWeight = FontWeight.Bold,
                )

                Text(text = item.release_date)
            }

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = stringResource(id = R.string.vote_average),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )

                Text(text = item.vote_average.toString())
            }
        }
    }
}