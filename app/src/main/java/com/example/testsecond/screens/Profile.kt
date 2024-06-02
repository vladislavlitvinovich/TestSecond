package com.example.testsecond.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testsecond.R
import com.example.testsecond.functions.PracticeAnswerDraw
import com.example.testsecond.navigation.NavRoutes

@Composable
fun ProfileView(navController: NavController){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f),
                horizontalArrangement = Arrangement.Start,
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
                        .fillMaxWidth()
                )
                {
                    Text(
                        text = "Профиль пользователя",
                        textAlign = TextAlign.Center
                    )
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxSize(0.8f)
                    .background(color = Color.Gray)
            ) {
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxSize(0.8f)
                ) {
                    Text(text = "Пользователь: user@mail.ru",
                    modifier = Modifier.padding(5.dp))
                    Text(text = "Прогресс прохождения курса")
                    LinearProgressIndicator(
                        progress = 0.0f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    )
                }
            }
        }
    }
}
