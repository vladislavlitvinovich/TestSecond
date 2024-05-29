package com.example.testsecond.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testsecond.functions.DrawLectures
import com.example.testsecond.navigation.NavRoutes
import com.example.testsecond.R

@Composable
fun Lectures(navController: NavController) {
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LecturesIconsDraw(navController)
            LecturesDraw(navController)
        }
    }
}

@Composable
fun LecturesIconsDraw(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .size(60.dp)
                .padding(5.dp)
                .clickable {
                    navController.navigate(NavRoutes.Profile.route)
                },
            painter = painterResource(id = R.drawable.ic_human),
            contentDescription = "profile icon"
        )
        Image(
            modifier = Modifier
                .weight(1f)
                .size(60.dp)
                .padding(5.dp)
                .clickable {
                    navController.navigate(NavRoutes.Search.route)
                },
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search icon"
        )
    }
}

@Composable
fun LecturesDraw(navController: NavController) {
    for (i: Int in 0..3) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    navController.navigate(route = "lectureView/$i")
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            DrawLectures(i)
        }

    }
}