package ca.cem.composemultilingue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.cem.composemultilingue.ui.theme.ComposeMultilingueTheme

// TODO Dèfinir un nouveau fichier strings.xml dans un dossier appelé values-fr ou valuer-fr-rCA pour une vairante régionale
// TODO s'assurer que le fichier par défaut (dans values) contient toutes les chaînes de caractères utilisées
// TODO utiliser stringResource dans le code pour récupérer les chaînes de caractères
// TODO la traduction utilise la langue du téléphone, il faut donc changer la langue dans les réglages du téléphone pour tester
// TODO https://developer.android.com/guide/topics/resources/string-resource?hl=fr

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMultilingueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(R.string.hello_world) + " " + name,
            modifier = modifier
        )
        Text(text = pluralStringResource(R.plurals.you_have_messages, 1, 1))
        Text(text = pluralStringResource(R.plurals.you_have_messages, 10, 10))
    }
}
