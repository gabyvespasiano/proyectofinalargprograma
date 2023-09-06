package com.example.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.proyectofinal.ui.theme.ProyectoFinalTheme
import androidx.compose.material3.TextField

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TextComparatorApp()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextComparatorApp() {
    var text1 by remember { mutableStateOf(TextFieldValue()) }
    var text2 by remember { mutableStateOf(TextFieldValue()) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            label = { Text("Texto de la primera campera") },
            modifier = Modifier
                .padding(bottom = 16.dp)

        )

        TextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            label = { Text("Texto de la segunda campera") },
            modifier = Modifier
                .padding(bottom = 16.dp)

        )

        Button(
            onClick = {
                val areEqual = text1.text == text2.text
                result = if (areEqual) "Las cadenas son iguales" else "Las cadenas son diferentes"
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Comparar")
        }

        Text(
            text = result,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

