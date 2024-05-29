package com.example.testsecond.navigation

sealed class NavRoutes(val route: String) {
    object Authorization : NavRoutes("authorization")
    object Registration : NavRoutes("registration")
    object Lectures : NavRoutes("lectures")
    object LectureView : NavRoutes("lectureView/{id}")
    object PracticeView : NavRoutes("practice")
    object Profile : NavRoutes("profile")
    object Search : NavRoutes("search")
}