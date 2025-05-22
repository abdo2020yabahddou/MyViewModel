package com.example.myviewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxSize().padding(20.dp)) {it->
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = viewModel.itemValue,
                onValueChange = {
                    viewModel.itemValue = it
                },
                label = { Text(text = "Fahrenheit") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                onClick = {
                    val fahrenheit = viewModel.itemValue.toDoubleOrNull()
                    if (fahrenheit != null) {
                        val celsius = viewModel.calculateCelsius()
                        navController.navigate(Screen.Result.createRoute(celsius!!))
                    }
                }) {
                Text(text = "Calculate")
            }

        }
    }
}
