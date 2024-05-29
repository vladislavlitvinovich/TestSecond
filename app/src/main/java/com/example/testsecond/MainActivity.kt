package com.example.testsecond

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.testsecond.authorization.EmailPasswordActivity
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSecondTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    toTheReg()
                }
            }
        }
    }
}

@Composable
fun toTheReg() {
    val navController = rememberNavController()
    MainAuthorization(navController = navController)
    NavHost(navController, startDestination = NavRoutes.Authorization.route) {
        composable(NavRoutes.Authorization.route) { MainAuthorization(navController = navController) }
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
fun MainAuthorization(navController: NavController) {
    var login = mutableStateOf("")
    var password = mutableStateOf("")
    lateinit var auth: FirebaseAuth
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Логин")
            TextField(value = login.value, onValueChange = { newText ->
                login.value = newText
            })
            Text(text = "Пароль")
            TextField(value = password.value, onValueChange = { newText ->
                password.value = newText
            })
            Button(onClick = {
                auth.signInWithEmailAndPassword(login.value, password.value)
                //signIn(login, password)
//                navController.navigate(NavRoutes.Lectures.route)
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