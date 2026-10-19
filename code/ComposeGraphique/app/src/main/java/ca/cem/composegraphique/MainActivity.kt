package ca.cem.composegraphique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import ca.cem.composegraphique.ui.theme.ComposeGraphiqueTheme
import com.github.mikephil.charting.compose.PieChart
import com.github.mikephil.charting.compose.setColors
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
fun PieChartView(modifier:Modifier = Modifier) {
    val data = remember {
        val set = PieDataSet(
            listOf(
                PieEntry(30f, "Section 1"),
                PieEntry(45f, "Section 2"),
                PieEntry(25f, "★★★★★"),
            ),
            "Données"
        ).apply {
            setColors(listOf(
                Color(255, 102, 102),
                Color(102, 178, 255),
                Color(102, 255, 102),
            ))
            valueTextSize = 16f
            valueTextColor = androidx.compose.ui.graphics.Color.White.toArgb()
        }
        PieData(set)
    }

    val holeColor = MaterialTheme.colorScheme.surface.toArgb()

    PieChart(
        data = data,
        modifier = modifier.fillMaxSize(), // Pour que la démo fonctionne. À ajuster selon le contexte dans votre TP.
        contentDescription = "Répartition des avis sur le DEC technique",
        setup = {
            description.isEnabled = false
            isDrawHoleEnabled = true
            holeRadius = 40f
            transparentCircleRadius = 45f
            isDrawEntryLabelsEnabled = true
            entryLabelColor = androidx.compose.ui.graphics.Color.Black.toArgb()
            entryLabelTextSize = 12f
        },
        update = {
            this.holeColor = holeColor
        },
    )
}