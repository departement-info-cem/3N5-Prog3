package ca.cem.composetiroir

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonSuperTiroir(
    controleurNavigation: NavHostController,
    routeActuelle: String,
    fermerTiroir: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(modifier) {
        JetNewsLogo(
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
        )
        NavigationDrawerItem(
            label = { Text("Accueil") },
            icon = { Icon(Icons.Filled.Home, null) },
            selected = routeActuelle == "accueil",
            onClick = {
                controleurNavigation.navigate("accueil")
                fermerTiroir()
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text("Ajout") },
            icon = { Icon(Icons.Filled.Add, null) },
            selected = routeActuelle == "ajout",
            onClick = {
                controleurNavigation.navigate("ajout")
                fermerTiroir()
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        // add a new item for disconnecting
        NavigationDrawerItem(
            label = { Text("Déconnexion") },
            icon = { Icon(Icons.Filled.Close, null) },
            selected = false, // il n'y pas d'écran de déconnexion on retourne à la connexion
            onClick = {
                controleurNavigation.navigate("connexion")
                fermerTiroir()
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Composable
private fun JetNewsLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = stringResource(R.string.app_name),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
