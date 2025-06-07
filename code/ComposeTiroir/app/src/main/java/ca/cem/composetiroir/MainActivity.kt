package ca.cem.composetiroir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.cem.composetiroir.ui.theme.ComposeTiroirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTiroirTheme {
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
        startDestination = "connexion",
        //modifier = modifier.padding(padding)
    ) {
        composable(route = "connexion") { Connexion(navController, modifier) }
        composable(route = "ajout") { Ajout(navController, modifier) }
        composable(route = "accueil") { Accueil(navController,modifier) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Connexion(
    navController: NavHostController,
    modifier: Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ajout(
    navController: NavHostController,
    modifier: Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Accueil(
    navController: NavHostController,
    modifier: Modifier) {

}

