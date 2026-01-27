import correcteur.Correcteur
import correcteur.Point
import correcteur.testeur
import fichier.ecrire
import fichier.lire
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension
import java.io.File
import kotlin.test.*

@ExtendWith(BeforeFichierTest::class, OutputCaptureExtension::class)
class FichierTest {

    val contenuFichierALire: String = "Bonne\nChance\nPour\nTon\nExamen\n:)"
    val nomFichierAEcrire: String = "le_nom_de_mon_fichier.txt"
    val contenuFichierAEcrire: String =
        "Voici le contenu du fichier que je veux écrire\nC'est d'ailleurs un fichier sur plusieurs lignes\n!!!"

    @BeforeTest
    fun setUp() {
        // Supprimer le fichier à lire s'il existe
        val fichierALire: File = File("message.txt")
        fichierALire.delete()

        // Supprimer le fichier à écrire s'il existe
        val fichierAEcrire: File = File(nomFichierAEcrire)
        fichierAEcrire.delete()

        // Créer le fichier à lire nombre avec le contenu qui nous intéresse
        fichierALire.writeText(contenuFichierALire)
    }

    @Test
    fun testFichierLire(output: CapturedOutput) {
        var point: Point = Point(
            question = "Affiche dans la console le contenu du fichier message.txt qui se trouve dans le projet de départ.",
            ponderation = 1
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 1,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "Le contenu du fichier n'est pas affiché dans la console.",
                test = {
                    lire()
                    val fichierALire: File = File("message.txt")
                    for (ligne in fichierALire.readLines()) {
                        assertContains(output.all, ligne)
                    }
                })
        } finally {
            Correcteur.get().categories["Fichier"]!!["Lire"]?.add(point)
        }
    }

    @Test
    fun testFichierEcrireArgs(output: CapturedOutput) {
        var point: Point = Point(
            question = "S’il n’y a pas 2 éléments dans le paramètre args, affiche un message d'erreur, et retourne la valeur -1.",
            ponderation = 1
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 1,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "La valeur retournée n'est pas -1 et/ou aucun message d'erreur n'a été affiché dans la console.",
                test = {
                    val ret: Int = ecrire(arrayOf())
                    assertEquals(-1, ret)
                    assertTrue(output.all.count() > 1)
                })
        } finally {
            Correcteur.get().categories["Fichier"]!!["Écrire"]?.add(point)
        }
    }

    @Test
    fun testFichierEcrireContientContenu() {
        var point: Point = Point(
            question = "Le fichier aura comme contenu le texte contenu dans le 2ème élément qui est dans le paramètre args.",
            ponderation = 1
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 1,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "Le fichier ne contient pas le contenu demandé.",
                test = {
                    ecrire(arrayOf(nomFichierAEcrire, contenuFichierAEcrire))

                    val fichierEcrit: File = File(nomFichierAEcrire)
                    if (fichierEcrit.exists()) {
                        val contenuFichierEcrit: String = fichierEcrit.readText()
                        for (ligne in contenuFichierAEcrire.split("\n")) {
                            assertContains(contenuFichierEcrit, ligne)
                        }
                    } else {
                        assertFails { }
                    }
                })
        } finally {
            Correcteur.get().categories["Fichier"]!!["Écrire"]?.add(point)
        }
    }

    @Test
    fun testFichierEcrireNomFichier() {
        var point: Point = Point(
            question = "Crée un fichier dans le répertoire du projet, dont le nom sera déterminé par le premier argument.",
            ponderation = 1
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 1,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "Aucun fichier portant le nom de $nomFichierAEcrire n'a été créé.",
                test = {
                    ecrire(arrayOf(nomFichierAEcrire, contenuFichierAEcrire))

                    val fichier: File = File(nomFichierAEcrire)
                    assertTrue(fichier.exists())
                })
        } finally {
            Correcteur.get().categories["Fichier"]!!["Écrire"]?.add(point)
        }
    }
}

class BeforeFichierTest : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        Correcteur.get().categories["Fichier"] = mutableMapOf(
            "Lire" to mutableListOf(), "Écrire" to mutableListOf()
        )
    }
}