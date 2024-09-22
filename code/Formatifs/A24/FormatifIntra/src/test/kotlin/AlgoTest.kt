import algo.racineCarre
import correcteur.Correcteur
import correcteur.Point
import correcteur.testeur
import kotlinx.ast.common.AstSource
import kotlinx.ast.grammar.kotlin.target.antlr.kotlin.KotlinGrammarAntlrKotlinParser
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.system.OutputCaptureExtension
import utils.ast.allPropertyDeclarationsAreTyped
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertTrue

@ExtendWith(BeforeAlgoTest::class, OutputCaptureExtension::class)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class AlgoTest {

    val testValues: List<Pair<Float, Float>> =
        listOf(Pair(5f, 2.236f), Pair(25f, 5f), Pair(7.8f, 2.7928f))

    @Test
    @Order(1)
    fun testAlgoRacineCarreeFonctionnement() {
        var point: Point = Point(
            question = "Tu dois traduire le pseudo-code fourni pour programmer la fonction racine carré.",
            ponderation = 3
        )

        try {
            testeur(point = point,
                pointsAjoutesSiReussi = 3,
                pointsRetiresSiEchoue = 0,
                explicationSiEchoue = "L'algorithme ne donne pas la bonne réponse.",
                test = {
                    for (testValue in testValues) {
                        assertEquals(testValue.second, racineCarre(testValue.first))
                    }
                })
        } finally {
            Correcteur.get().categories["Algo"]!!["Racine Carrée"]?.add(point)
        }
    }

    @Test
    @Order(2)
    fun testAlgoRacineCarreeTypes() {
        var point: Point = Point(
            question = "Annotations de type", ponderation = 1
        )

        if (Correcteur.get().categories["Algo"]!!["Racine Carrée"]!![0].pointsObtenus > 0) {
            try {
                testeur(point = point,
                    pointsAjoutesSiReussi = 1,
                    pointsRetiresSiEchoue = 0,
                    explicationSiEchoue = "Certaines variables ne sont pas typées.",
                    test = {
                        val source = AstSource.File(
                            "src/main/kotlin/algo/Algo.kt"
                        )
                        val ast = KotlinGrammarAntlrKotlinParser.parseKotlinFile(source)
                        assertTrue(allPropertyDeclarationsAreTyped(ast))

                    })
            } finally {
                Correcteur.get().categories["Algo"]!!["Racine Carrée"]?.add(point)
            }
        } else {
            assertFails {  }
        }
    }
}

class BeforeAlgoTest : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        Correcteur.get().categories["Algo"] = mutableMapOf(
            "Racine Carrée" to mutableListOf()
        )
    }
}