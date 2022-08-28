@file:OptIn(ExperimentalCoilApi::class)

package com.example.husqvarnatest.presentation.ui.screens.main

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi

@Composable
fun MainScreen(navController: NavController) {
    val mViewModel = hiltViewModel<MainViewModel>()

    val listMoviesPopular = mViewModel.listMoviesPopular.collectAsState().value

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getListMoviesPopular()
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = { padding ->
            Column(){
                TopAppBar(
                    title = { Text(text = "Husqvarna Test") }
                )
                LazyColumn(
                    modifier = Modifier
                        .padding(padding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(listMoviesPopular) { movie ->
                        MovieItem(navController = navController, item = movie)
                    }
                }
            }
        })
}