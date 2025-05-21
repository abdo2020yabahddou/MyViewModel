package com.example.myviewmodel

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Result : Screen("result_screen/{result}") {
        fun createRoute(result: Double) = "result_screen/$result"
    }

}