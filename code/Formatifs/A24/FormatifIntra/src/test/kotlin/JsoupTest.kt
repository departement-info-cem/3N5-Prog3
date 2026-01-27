import correcteur.Correcteur
import correcteur.Point
import correcteur.testeur
import jsoup.jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.system.CapturedOutput
import org.springframework.boot.test.system.OutputCaptureExtension
import kotlin.test.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFails

@ExtendWith(BeforeJsoupTest::class, OutputCaptureExtension::class)
class JsoupTest {

    val mots: List<String> = listOf("Comment", "est", "votre", "blanquette ?")

    @Test
    fun testJsoupConsole(output: CapturedOutput) {
        var point: Point = Point(
            "Le contenu de la page html modifiée doit être imprimée dans la console.", 1
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 1,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "Le document n'a pas été ajouté dans la console.",
                test = {
                    val document: Document? = jsoup(mots)
                    if (document != null) {
                        for (ligne in document.html().split("\n")) {
                            assertContains(output.all, ligne)
                        }
                    } else {
                        assertFails { }
                    }
                })
        } finally {
            Correcteur.get().categories["Jsoup"]!!["Mots"]?.add(point)
        }
    }

    @Test
    fun testJsoupContenu(output: CapturedOutput) {
        var point: Point = Point(
            "Chaque élément demandé est présent dans le document retourné.", 3
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 3,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "Le document retourné ne contient pas les éléments demandés.",
                test = {
                    val document: Document? = jsoup(mots)
                    if (document != null) {
                        val body: Element = document.select("body").first()
                        assertEquals(mots.count(), body.children().count())
                        for (element in body.children()) {
                            assertEquals("div", element.tag().toString())
                            assertContains(mots, element.text())
                        }
                    } else {
                        assertFails { }
                    }
                })
        } finally {
            Correcteur.get().categories["Jsoup"]!!["Mots"]?.add(point)
        }
    }

}

class BeforeJsoupTest : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        Correcteur.get().categories["Jsoup"] = mutableMapOf(
            "Mots" to mutableListOf()
        )
    }
}