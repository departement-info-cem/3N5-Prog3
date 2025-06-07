package ca.cem.composetiroir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.cem.composetiroir.ui.theme.ComposeTiroirTheme
import kotlinx.coroutines.launch

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
    controleurNavigation: NavHostController,
    modifier: Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(10.dp)),
            onClick = {
                controleurNavigation.navigate("accueil")
            },
            // Uses ButtonDefaults.ContentPadding by default
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
        ) {
            // Inner content including an icon and a text label
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Favorite",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Accueil")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Accueil(
    controlerNav: NavHostController,
    modifier: Modifier) {

    // État du tiroir est défini ici parce qu'il est partagé entre
    // - le tiroir qui le ferme
    // - l'écran Accueil qui l'ouvre
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MonSuperTiroir(
                controleurNavigation = controlerNav,
                routeActuelle = "accueil",
                fermerTiroir = { coroutineScope.launch { drawerState.close() } }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Accueil") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    println("add task clicked")
                    controlerNav.navigate("ajout")
                }) {
                    IconButton(onClick = {
                        controlerNav.navigate("ajout")
                    }) {
                        Icon(Icons.Filled.Add, contentDescription = "Ajouter une tâche")
                    }
                }
            }
        ) { padding ->
            // Afficher un indicateur de chargement si on est en train de charger pour la première fois
            Text("ici mettre le contenu de l'accueil",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Ajout(
    controlerNav: NavHostController,
    modifier: Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MonSuperTiroir(
                controleurNavigation = controlerNav,
                routeActuelle = "accueil",
                fermerTiroir = { coroutineScope.launch { drawerState.close() } }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Ajout") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                coroutineScope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            },
        ) { padding ->
            // Afficher un indicateur de chargement si on est en train de charger pour la première fois
            Text("ici mettre le contenu de l'ajout",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            )
        }
    }
}

