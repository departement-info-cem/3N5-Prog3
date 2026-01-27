package ca.cem.composeclassique

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import ca.cem.composeclassique.ui.theme.ComposeClassiqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeClassiqueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ){
                        Box(

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .background(Color.Blue)
                                .padding(8.dp)
                        ) {
                            ComposantAndroidClassique(
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        ComposantAndroidClassique(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ComposantAndroidClassique(modifier: Modifier = Modifier) {
    val mUrl = "https://info.cegepmontpetit.ca/3N5-Prog3/"
    // AndroidView est une fonction composable pour ajouter une vue Android classique.
    AndroidView(
        // factory est une lambda qui fournit un contexte via le paramètre `it`.
        // il renvoie un objet classique. Ici pour exemple, un WebView.
        factory = {
            val vueClassique = WebView(it)
            val parametreMiseEnPage = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            vueClassique.layoutParams = parametreMiseEnPage
            vueClassique.webViewClient = WebViewClient()
            vueClassique.loadUrl(mUrl)
            return@AndroidView vueClassique
        },
        // update est une lambda qui permet de mettre à jour la vue classique quand
        // l'interface est mise à jour
        update = {
            it.loadUrl(mUrl)
        }
    )
}
