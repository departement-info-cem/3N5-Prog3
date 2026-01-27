package com.caldairou.incrementercompteur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caldairou.incrementercompteur.ui.theme.IncrementerCompteurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Entrée dans onCreate")
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
        println("Sortie de onCreate")
    }
}

@Composable
fun EcranPrincipal(
    modifier : Modifier = Modifier
){
    println("Entrée dans EcranPrincipal")
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
                // TODO placer un point d'arrêt sur la ligne suivante
                println("Entrée dans onClick pour liste")
                listeMemoire.add(listeMemoire.size * 2)
                println("Sortie de onClick pour liste" + listeMemoire.joinToString(", "))
            }
        ) {
            Text("Ajout Liste")
        }
        // On peut isoler les comportements / objets dans des sous fonctions
        AfficherCompteur(compteur = compteur)
        BoutonPourIncrementer(
            quandOnCliqueSurIncrementer = {
                // TODO placer un point d'arrêt sur la ligne suivante
                println("Entrée dans onClick pour compteur")
                compteur++
                println("Sortie de onClick pour compteur " + compteur)
            }
        )
    }
    println("Sortie de EcranPrincipal")
}

@Composable
private fun BoutonPourIncrementer(
    quandOnCliqueSurIncrementer : () -> Unit
) {
    println("Entrée dans BoutonPourIncrementer")
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
    println("Sortie de BoutonPourIncrementer")
}

@Composable
private fun AfficherCompteur(
    compteur : Int
) {
    println("Entrée dans AfficherCompteur avec compteur = $compteur")
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
    println("Sortie de AfficherCompteur")
}