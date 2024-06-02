package com.example.testsecond.functions

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testsecond.R
import com.example.testsecond.navigation.NavRoutes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

@Composable
fun PracticeChoice(navController: NavController) {
    for (i: Int in 1..4)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable {
                    navController.navigate(NavRoutes.PracticeView.route)
                }
        ) {
            Text(
                text = "Задание $i",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
}

@Composable
fun switchTheme(id: Int?): String {
    return when (id) {
        0 -> stringResource(R.string.lecture1)
        1 -> stringResource(R.string.lecture2)
        2 -> stringResource(R.string.lecture3)
        3 -> stringResource(R.string.lecture4)
        else -> {
            "Error"
        }
    }
}

@Composable
fun getLectureContent(): String {
    return stringResource(R.string.lecture_content1)
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun PracticeAnswerDraw() {
    var isCard1Clicked by remember { mutableStateOf(false) }
    var isCard2Clicked by remember { mutableStateOf(false) }
    var isCard3Clicked by remember { mutableStateOf(false) }
    var isCard4Clicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard1Clicked = !isCard1Clicked },
        backgroundColor = if (isCard1Clicked) Color.Green else Color.Gray
    ) {
        Text(
            text = "git branch",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard2Clicked = !isCard2Clicked },
        backgroundColor = if (isCard2Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git checkout",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard3Clicked = !isCard3Clicked },
        backgroundColor = if (isCard3Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git merge",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard4Clicked = !isCard4Clicked },
        backgroundColor = if (isCard4Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git clone",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}


@Composable
fun PracticeAnswerDraw1() {
    var isCard1Clicked by remember { mutableStateOf(false) }
    var isCard2Clicked by remember { mutableStateOf(false) }
    var isCard3Clicked by remember { mutableStateOf(false) }
    var isCard4Clicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard1Clicked = !isCard1Clicked },
        backgroundColor = if (isCard1Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Копия репозитория",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard2Clicked = !isCard2Clicked },
        backgroundColor = if (isCard2Clicked) Color.Green else Color.Gray
    ) {
        Text(
            text = "Ссылка на определенное состояние репозитория",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard3Clicked = !isCard3Clicked },
        backgroundColor = if (isCard3Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Файл, который отслеживает изменения в репозитории",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard4Clicked = !isCard4Clicked },
        backgroundColor = if (isCard4Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Команда для объединения изменений из двух веток",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun PracticeAnswerDraw2() {
    var isCard1Clicked by remember { mutableStateOf(false) }
    var isCard2Clicked by remember { mutableStateOf(false) }
    var isCard3Clicked by remember { mutableStateOf(false) }
    var isCard4Clicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard1Clicked = !isCard1Clicked },
        backgroundColor = if (isCard1Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git branch",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard2Clicked = !isCard2Clicked },
        backgroundColor = if (isCard2Clicked) Color.Green else Color.Gray
    ) {
        Text(
            text = "git checkout",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard3Clicked = !isCard3Clicked },
        backgroundColor = if (isCard3Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git merge",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard4Clicked = !isCard4Clicked },
        backgroundColor = if (isCard4Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "git pull",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun PracticeAnswerDraw3() {
    var isCard1Clicked by remember { mutableStateOf(false) }
    var isCard2Clicked by remember { mutableStateOf(false) }
    var isCard3Clicked by remember { mutableStateOf(false) }
    var isCard4Clicked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard1Clicked = !isCard1Clicked },
        backgroundColor = if (isCard1Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Копирование изменений из одной ветви в другую",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard2Clicked = !isCard2Clicked },
        backgroundColor = if (isCard2Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Удаление одной из веток",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard3Clicked = !isCard3Clicked },
        backgroundColor = if (isCard3Clicked) Color.Green else Color.Gray
    ) {
        Text(
            text = "Объединение изменений из двух веток в одну",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { isCard4Clicked = !isCard4Clicked },
        backgroundColor = if (isCard4Clicked) Color.Red else Color.Gray
    ) {
        Text(
            text = "Создание новой ветви на основе двух существующих веток",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun DrawLectures(i: Int){
    Card {
        Text(
            text = stringResource(id = R.string.lecture1 + i),
            Modifier.padding(5.dp)
        )
    }
    Text(
        text = stringResource(id = R.string.lecture_mini_content1+i),
        Modifier.padding(5.dp)
    )
}

