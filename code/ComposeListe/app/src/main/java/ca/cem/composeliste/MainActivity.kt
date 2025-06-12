package ca.cem.composeliste

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.cem.composeliste.ui.theme.ComposeListeTheme
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeListeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // ajouter une liste ici avec un LazyColumn
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // Choix 1 on crée un certain nombre d'items avec un index qui va de 1 à 10
                        items(10) { index ->
                            Machin(name = "Item #$index", modifier = Modifier.padding(8.dp))
                        }
                        // Choix 2 on crée une liste d'items
                        val patentes = listOf<String>("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                        // qu'on parcourt avec une boucle
                        for (patente in patentes) {
                            // on ajoute un item à la liste
                            item {
                                Machin(name = patente, modifier = Modifier.padding(8.dp).height(150.dp))
                            }
                        }
                        // Choix 3 on crée des items pour chaque élément d'une liste
                        val trucs : List<Double> = listOf(12.0, 34.0, 56.0, 78.0, 90.0, 11.0, 22.0, 33.0, 44.0, 55.0)
                        // IMPORTANT : on peut avoir à importer import androidx.compose.foundation.lazy.items à la main
                        items(trucs) { truc ->
                            Machin(name = "Truc #$truc", modifier = Modifier.padding(8.dp).height(150.dp))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Machin(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Salut $name!",
        modifier = modifier
    )
}
