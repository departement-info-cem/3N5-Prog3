package com.caldairou.incrementercompteur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caldairou.incrementercompteur.ui.theme.IncrementerCompteurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IncrementerCompteurTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    innerPadding ->
                    EcranPrincipal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun EcranPrincipal(
    modifier : Modifier = Modifier
){
    // la variable avec l'état doit être avant toutes les fonctions qui partagent l'état
    // TODO placer un point d'arrêt sur la ligne suivante
    var compteur by remember{mutableIntStateOf(0)}
    // déclare une liste mutable d'entiers
    val listeMemoire: SnapshotStateList<Int> = remember { mutableStateListOf(1, 2, 3) }
    Column(
        modifier = modifier.fillMaxSize()
    )
    {
        Text("la liste est " + listeMemoire.joinToString(", "))
        Button(
            onClick = {
                // dès que la valeur de la liste change, tout ce qui l'utilise est recomposé
                listeMemoire.add(listeMemoire.size * 2)
            }
        ) {
            Text("Ajout Liste")
        }
        // On peut isoler les comportements / objets dans des sous fonctions
        AfficherCompteur(compteur = compteur)
        BoutonPourIncrementer(
            // TODO placer un point d'arrêt sur la ligne suivante
            quandOnCliqueSurIncrementer = {
                compteur++
            }
        )
    }
}

@Composable
private fun BoutonPourIncrementer(
    quandOnCliqueSurIncrementer : () -> Unit
) {
    Surface(
        color = Color.LightGray,
        onClick = quandOnCliqueSurIncrementer
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Incrémenter",
                modifier = Modifier.padding(8.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun AfficherCompteur(
    compteur : Int
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        // TODO placer un point d'arrêt sur la ligne suivante
        Text(
            text = "$compteur pushs sur le bouton",
            modifier = Modifier.padding(8.dp),
            fontSize = 25.sp
        )
    }
}