@file:OptIn(ExperimentalMaterial3Api::class)

package ca.cem.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.cem.composenavigation.ui.theme.ComposeNavigationTheme

// Etape 1 : ajouter implementation("androidx.navigation:navigation-compose:2.9.0") dans le fichier build.gradle.kts
// Etape 2 : Encapsuler le NaVHost dans un composable Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationTheme {
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
    NavHost(
        navController = navController,
        startDestination = "ecranA",
        //modifier = modifier.padding(padding)
    ) {
        // on passe le navController à l'écran pour qu'il puisse naviguer à son tour
        composable(route = "ecranA") { EcranA(navController, modifier) }
        composable(route = "ecranB") { EcranB(navController, modifier) }
        composable(route = "ecranC/{id}") {
            val id = it.arguments?.getString("id")
            EcranC(navController, modifier, id)
        }
    }
}

@Composable
fun EcranA(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Ecran A") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        }
    ) { padding ->
        Column (
            modifier.padding(padding)
        ){
            Text(
                text = "Ceci est l'écran A",
                modifier = modifier.padding(20.dp),
            )
            Button(onClick = { navController.navigate("ecranB") }) {
                Text("Vers Écran B")
            }
        }
    }
}

@Composable
fun EcranB(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()

    ) { padding ->
        Column(Modifier.fillMaxSize()){
            Text(
                text = "Écran B sans topBar",
                modifier = Modifier.padding(padding)
            )
            Button(onClick = { navController.navigate("ecranA") }) {
                Text("Vers Écran A")
            }
            Button(onClick = { navController.navigate("ecranC/20") }) {
                Text("Vers Écran C avec id 20")
            }
            Button(onClick = { navController.navigate("ecranC/99") }) {
                Text("Vers Écran C avec id 99")
            }
        }
    }
}

@Composable
fun EcranC(navController: NavHostController, modifier: Modifier, id: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ecran c") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = id ?: "Aucun ID fourni",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}