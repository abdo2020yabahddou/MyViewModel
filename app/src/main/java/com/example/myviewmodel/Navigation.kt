package com.example.myviewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(navController: NavHostController = rememberNavController()) {
    val viewModel: HomeViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeView(viewModel, navController)
        }
        composable(Screen.Result.route, arguments = listOf(navArgument("result") {
            type = NavType.StringType
        })) {
            val resultStr = it.arguments?.getString("result")
            val result = resultStr?.toDoubleOrNull() ?: 0.0
            ResultView(result, navController)
        }

    }
}