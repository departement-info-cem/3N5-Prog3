package ca.cem.composemiseenpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ca.cem.composemiseenpage.ui.theme.ComposeMiseEnPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMiseEnPageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(){
        Column(
            modifier.weight(1f)
        ){
            Text("Yo on ne devrait jamais utiliser un poids pour la hauteur d'un élément avec du texte")
            Spacer(modifier.weight(30f))
            Button(
                onClick = {}
            ) {
                Text(text = "Clique moi")
            }
            Spacer(modifier.weight(30f))
            Box(modifier.weight(30f).background(Color.Red)) {

            }
            Text("trop petit",
                modifier = modifier.weight(10f))
            Spacer(modifier.weight(30f))
        }
        Column(
            modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text("Yo on ne devrait jamais utiliser un poids pour la hauteur d'un élément avec du texte")
            Spacer(modifier.weight(30f))
            Button(
                onClick = {}
            ) {
                Text(text = "Clique moi")
            }
            Spacer(modifier.weight(30f))
            Box(modifier.weight(30f).background(Color.Red)) {

            }
            Text("trop petit")
            Spacer(modifier.weight(30f))
        }
    }
}
