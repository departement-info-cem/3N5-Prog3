@file:OptIn(ExperimentalMaterial3Api::class)

package ca.cem.composelistenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.cem.composelistenav.ui.theme.ComposeListeNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeListeNavTheme {
                Navigation()
            }
        }
    }
}


@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // TODO est-ce qu'on veut des routes String ou des objets ? Ici on utilise des String
    NavHost(
        navController = navController,
        startDestination = "liste",
    ) {
        // on passe le navController à l'écran pour qu'il puisse naviguer à son tour
        composable(route = "liste") { Liste(navController, modifier) }
        composable(route = "detail/{id}") {
            val id = it.arguments?.getString("id")!!.toInt()
            Detail(navController, modifier, id)
        }
    }
}


@Composable
fun Liste(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Liste") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(donnees()) { truc ->
                BoitePourElement(
                    modifier = Modifier.padding(8.dp).height(150.dp),
                    navController = navController,
                    truc = truc,
                )
            }
        }
    }
}

@Composable
fun BoitePourElement(
    truc: Donnee,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp),
    ){
        Text(
            text = "Nom ${truc.nom}!",
            modifier = modifier.weight(1f).padding(8.dp)
        )
        Button(
            onClick = {
                print("detail/" + truc.id)
                navController.navigate("detail/" + truc.id)
            }) {
            Text("Vers Écran C")
        }
    }
}

@Composable
fun Detail(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    id: Int?) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Détail") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { padding ->
        val donnee = donnee(id!!) // on suppose que l'id est toujours valide, sinon on pourrait afficher un message d'erreur
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Détail de l'élément avec id $id",
                modifier = Modifier.padding(20.dp),
            )
            Text(
                text = "Nom " + donnee.nom,
                modifier = Modifier.padding(20.dp),
            )
        }
    }
}
