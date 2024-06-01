package com.example.testsecond

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testsecond.ui.theme.TestSecondTheme
import com.example.testsecond.navigation.NavRoutes
import com.example.testsecond.screens.LectureView
import com.example.testsecond.screens.Lectures
import com.example.testsecond.screens.PracticeView
import com.example.testsecond.screens.Registration
import androidx.compose.runtime.mutableStateOf
import com.example.testsecond.authorization.fireAuth
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSecondTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FirebaseApp.initializeApp(this)
                    toTheReg(this)
                }
            }
        }
    }
}

@Composable
fun toTheReg(context: ComponentActivity) {
    val navController = rememberNavController()
    MainAuthorization(navController = navController, context)
    NavHost(navController, startDestination = NavRoutes.Authorization.route) {
        composable(NavRoutes.Authorization.route) { /*MainAuthorization(navController = navController)*/ }
        composable(NavRoutes.Registration.route) { Registration(navController = navController) }
        composable(NavRoutes.Lectures.route) { Lectures(navController = navController) }
        composable(
            NavRoutes.LectureView.route,
            arguments = listOf(navArgument("id") {
                type = NavType.IntType
            })
        )
        {
            it.arguments?.getInt("id").toString()
            LectureView(navController = navController)
        }
        composable(NavRoutes.PracticeView.route) { PracticeView(navController = navController) }
        composable(NavRoutes.Profile.route) { } // TODO
        composable(NavRoutes.Search.route) { } // TODO
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MainAuthorization(navController: NavController, context: ComponentActivity) {
    var login = mutableStateOf("")
    var password = mutableStateOf("")
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Логин")
            TextField(value = login.value, singleLine = true, onValueChange = { newText ->
                login.value = newText
            })
            Text(text = "Пароль")
            TextField(value = password.value, singleLine = true, onValueChange = { newText ->
                password.value = newText
            })
            Button(onClick = {
                if(login.value.isEmpty() || password.value.isEmpty()){
                    Toast.makeText(
                        context,
                        "Пожалуйста, заполните поля",
                        Toast.LENGTH_SHORT,
                    ).show()
                } else{
                    fireAuth(login.value, password.value, context, navController)
                }
            }) {
                Text(text = "Войти")
            }
            Button(onClick = {
                navController.navigate(NavRoutes.Registration.route)
            }) {
                Text(text = "Зарегистрироваться")
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun MainAuthorizationPreview() {
//    DiplomaTheme {
//        MainAuthorization()
//    }
//}