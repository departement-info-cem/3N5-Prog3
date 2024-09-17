
import algo.racineCarre
import correcteur.Correcteur
import correcteur.Point
import correcteur.testeur
import kotlinx.ast.common.AstSource
import kotlinx.ast.grammar.kotlin.target.antlr.kotlin.KotlinGrammarAntlrKotlinParser
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.boot.test.system.OutputCaptureExtension
import utils.ast.allPropertyDeclarationsAreTyped
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExtendWith(BeforeAlgoTest::class, OutputCaptureExtension::class)
class AlgoTest {

    val testValues: List<Pair<Double, Double>> =
        listOf(Pair(5.0, 2.2359999999999998), Pair(25.0, 5.0), Pair(7.8, 2.7927999999999997))

    @Test
    fun testAlgoRacineCarreeFonctionnement() {
        var point: Point = Point(
            question = "Tu dois traduire le pseudo-code fourni pour programmer la fonction racine carré.", ponderation = 3
        )

        point = testeur(point = point,
            pointsAjoutesSiReussi = 3,
            pointsRetiresSiEchoue = 0,
            explicationSiEchoue = "L'algorithme ne donne pas la bonne réponse.",
            test = {
                for (testValue in testValues) {
                    assertEquals(testValue.second, racineCarre(testValue.first))
                }
            })

        Correcteur.get().categories["Algo"]!!["Racine Carrée"]?.add(point)
    }

    @Test
    fun testAlgoRacineCarreeTypes() {
        var point: Point = Point(
            question = "Annotations de type", ponderation = 1
        )

        point = testeur(point = point,
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

        Correcteur.get().categories["Algo"]!!["Racine Carrée"]?.add(point)
    }
}

class BeforeAlgoTest : BeforeAllCallback {
    override fun beforeAll(context: ExtensionContext?) {
        Correcteur.get().categories["Algo"] = mutableMapOf(
            "Racine Carrée" to mutableListOf()
        )
    }
}