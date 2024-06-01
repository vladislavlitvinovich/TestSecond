package com.example.testsecond.authorization

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.testsecond.navigation.NavRoutes
import com.google.firebase.auth.FirebaseAuth


fun fireReg(email: String, password: String, context: Context){
    FirebaseAuth.getInstance()
        .createUserWithEmailAndPassword(email, password)
        .addOnSuccessListener {
            // Регистрация прошла успешно
            Toast.makeText(
                context,
                "Регистрация прошла успешно",
                Toast.LENGTH_SHORT,
            ).show()
        }
        .addOnFailureListener { exception ->
            // Обработка ошибок
            Toast.makeText(
                context,
                "Произошла ошибка",
                Toast.LENGTH_SHORT,
            ).show()
        }
}

fun fireAuth(email: String, password: String, context: Context, navController: NavController){
    FirebaseAuth.getInstance()
        .signInWithEmailAndPassword(email, password)
        .addOnSuccessListener {
            // Регистрация прошла успешно
            Toast.makeText(
                context,
                "Добро пожаловать",
                Toast.LENGTH_SHORT,
            ).show()
            navController.navigate(NavRoutes.Lectures.route)
        }
        .addOnFailureListener { exception ->
            // Обработка ошибок
            Toast.makeText(
                context,
                "Произошла ошибка",
                Toast.LENGTH_SHORT,
            ).show()
        }
}