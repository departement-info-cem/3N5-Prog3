package ca.cem.composegraphique

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import ca.cem.composegraphique.ui.theme.ComposeGraphiqueTheme
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        println("MainActivity.onCreate - ENTRÉE")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeGraphiqueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        PieChartView()
                    }
                }
            }
        }
        println("MainActivity.onCreate - SORTIE")
    }
}

@Composable
fun PieChartView() {
    println("PieChartView - ENTRÉE")
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        factory = { context ->
            println("PieChartView.factory - ENTRÉE")
            PieChart(context).apply {
                // Créer les entrées du graphique avec 3 sections
                val entries = listOf(
                    PieEntry(30f, "Section 1"),
                    PieEntry(45f, "Section 2"),
                    PieEntry(25f, "★★★★★")
                )

                // Créer le dataset
                val dataSet = PieDataSet(entries, "Données").apply {
                    colors = listOf(
                        Color.rgb(255, 102, 102),  // Rouge
                        Color.rgb(102, 178, 255),  // Bleu
                        Color.rgb(102, 255, 102)   // Vert
                    )
                    valueTextSize = 16f
                    valueTextColor = Color.WHITE
                }

                // Configurer les données
                val pieData = PieData(dataSet)
                data = pieData

                // Personnalisation du graphique
                description.isEnabled = false
                isDrawHoleEnabled = true
                setHoleColor(Color.WHITE)
                holeRadius = 40f
                transparentCircleRadius = 45f
                setDrawEntryLabels(true)
                setEntryLabelColor(Color.BLACK)
                setEntryLabelTextSize(12f)

                // Rafraîchir
                invalidate()
            }.also {
                println("PieChartView.factory - SORTIE")
            }
        }
    )
    println("PieChartView - SORTIE")
}