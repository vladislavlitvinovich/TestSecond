package com.example.testsecond.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testsecond.functions.PracticeChoice
import com.example.testsecond.functions.getLectureContent
import com.example.testsecond.functions.switchTheme
import com.example.testsecond.navigation.NavRoutes
import com.example.testsecond.R


@Composable
fun LectureView(navController: NavController) {
    val id = navController.previousBackStackEntry?.arguments?.getInt("id")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate(NavRoutes.Lectures.route)
                        },
                    painter = painterResource(id = R.drawable.ic_backward),
                    contentDescription = "backward icon"
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                {
                    Text(
                        text = stringResource(id = R.string.lecture3),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.lecture_content3),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable {
                        navController.navigate(NavRoutes.PracticeView.route)
                    }
            ) {
                Text(
                    text = "Перейти к заданиям",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LecturesPreview() {
//    DiplomaTheme {
//        LectureView()
//    }
//}