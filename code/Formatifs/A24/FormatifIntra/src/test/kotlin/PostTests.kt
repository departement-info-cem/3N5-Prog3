
import correcteur.Correcteur
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SuiteDeTests {

    companion object {
        @BeforeAll
        @JvmStatic
        fun init() {
            Correcteur.get().ecrireResultats()
        }
    }

    @Test
    fun leTestBidonMaisNecessaire() {
    }
}