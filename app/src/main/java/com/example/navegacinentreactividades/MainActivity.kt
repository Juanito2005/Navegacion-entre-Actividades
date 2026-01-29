package com.example.navegacinentreactividades

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal() {
    // 1. OBTENER EL CONTEXTO (Necesario para los Intents)
    val contexto = LocalContext.current

    // Truco: Para cerrar la app desde un Composable, necesitamos castear el contexto a Activity
    val activity = (LocalContext.current as? Activity)

    // Columna centrada (Equivalente a LinearLayout vertical + Gravity Center)
    Column(
        modifier = Modifier.fillMaxSize(), //Ocupa toda la pantalla
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Bienvenido a la Activity 1")

        // --- BOTÓN 1: NAVEGAR ---
        Button(onClick = {
            val intent = Intent(contexto, SecondActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Ir a Segunda Activity")
        }

        // --- BOTÓN 2: CERRAR ---
        Button(onClick = {
            activity?.finish()
        }) {
            Text("Cerrar App")
        }
    }
}
