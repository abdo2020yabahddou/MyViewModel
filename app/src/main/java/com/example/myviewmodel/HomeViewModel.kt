package com.example.myviewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var itemValue by mutableStateOf("")

    fun calculateCelsius(): Double? {
        val fahrenheit = itemValue.toDoubleOrNull()
        return fahrenheit?.let { (it - 32) * 5 / 9 }
    }

}