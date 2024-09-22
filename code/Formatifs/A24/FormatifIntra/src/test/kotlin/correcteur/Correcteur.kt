package correcteur

import nomExamen
import tonNom
import java.io.File

class Correcteur(private val titre: String) {

    val categories: MutableMap<String, MutableMap<String, MutableList<Point>>> = mutableMapOf()

    fun ecrireResultats() {
        val fichier: File = File("correction.md")
        fichier.delete()

        fichier.appendText("# $titre ${ls()}${ls()}")

        val totalPoints: Int = categories.values.sumOf { it.values.sumOf { point -> point.sumOf { it.pointsObtenus } } }
        val totalPonderation: Int = categories.values.sumOf { it.values.sumOf { point -> point.sumOf { it.ponderation } } }

        for (categorie in categories) {

            val totalPointsCategorie: Int = categorie.value.values.sumOf { it.sumOf { point -> point.pointsObtenus } }
            val totalPonderationCategorie: Int = categorie.value.values.sumOf { it.sumOf { point -> point.ponderation } }

            fichier.appendText("## ($totalPointsCategorie/$totalPonderationCategorie) ${categorie.key} ${ls()}${ls()}")

            for(exercice in categorie.value){
                val totalPointsExercice = exercice.value.sumOf  { point -> point.pointsObtenus }
                val totalPonderationExercice = exercice.value.sumOf { point -> point.ponderation }

                fichier.appendText("### ($totalPointsExercice/$totalPonderationExercice) ${exercice.key} ${ls()}${ls()}")

                for (point in exercice.value) {
                    fichier.appendText("- (${point.pointsObtenus}/${point.ponderation}) ${point.question} ${ls()}${ls()}")

                    for(explication in point.explications) {
                        fichier.appendText("  - **Erreur** $explication ${ls()}\n")
                    }
                }
            }
        }

        fichier.appendText("## Total : ($totalPoints/$totalPonderation) = ${(totalPoints * 100) / totalPonderation}%  ${ls()}${ls()}")
    }

    private fun ls(): String {
        return System.lineSeparator()
    }

    companion object {
        private var instance: Correcteur = Correcteur("${nomExamen()} - ${tonNom()}")

        fun get(): Correcteur {
            return instance
        }
    }
}