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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeView(
    viewModel: HomeViewModel = HomeViewModel(),
    navController: NavController = rememberNavController()
) {

    var itemValue by remember { mutableStateOf("") }

    fun calculate(itemValue: Double): Double = (itemValue - 32) * 5 / 9

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = itemValue,
            onValueChange = {
                itemValue = it
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
                val fahrenheit = itemValue.toDoubleOrNull()
                if (fahrenheit != null) {
                    val celsius = calculate(fahrenheit)
                    navController.navigate(Screen.Result.createRoute(celsius))
                }
            }) {
            Text(text = "Calculate")
        }

    }

}
