package com.example.testsecond.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testsecond.navigation.NavRoutes
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.testsecond.authorization.fireReg

@SuppressLint("UnrememberedMutableState")
@Composable
fun Registration(navController: NavController) {
    val context = LocalContext.current
    var login = mutableStateOf("")
    var password = mutableStateOf("")
    var password_repeat = mutableStateOf("")
    lateinit var auth: FirebaseAuth
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
        ) {
            Button(onClick = {
                navController.navigate(NavRoutes.Authorization.route)
            }, Modifier.padding(10.dp)) {
                Text(text = "Назад")
            }
        }
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Почта")
            TextField(value = login.value, onValueChange = { newText ->
                login.value = newText
            }, Modifier.padding(5.dp))
            Text(text = "Пароль")
            TextField(value = password.value,
                onValueChange = { newText ->
                    password.value = newText

                }, Modifier.padding(5.dp)
            )
            Text(text = "Повторите пароль")
            TextField(value = password_repeat.value, onValueChange = { newText ->
                password_repeat.value = newText

            }, Modifier.padding(5.dp))
            Button(
                onClick = {
                    if (password.value != password_repeat.value) {
                        Toast.makeText(
                            context,
                            "Пароли не совпадают",
                            Toast.LENGTH_SHORT,
                        ).show()
                    } else {
                        fireReg(login.value, password.value, context)
                    }
                },
                Modifier.padding(5.dp)
            ) {
                Text(text = "Зарегистрироваться")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RegistrationPreview() {
//    DiplomaTheme {
//        Registration()
//    }
//}