package org.example

// Démo d'une fonction de tri à bulle prenant une fonction de comparaison
fun <T> triBulle(tab: Array<T>, comparer: (T, T) -> Boolean) {
    val n = tab.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (comparer(tab[j + 1], tab[j])) {
                val tmp = tab[j]
                tab[j] = tab[j + 1]
                tab[j + 1] = tmp
            }
        }
    }
}

// Fonction de comparaison nommée (ordre croissant)
fun comparerCroissant(a: Int, b: Int): Boolean = a < b

fun main() {
    val tableau1 = arrayOf(52, 242, -8432, 120, 4)
    val tableau2 = arrayOf(5, 2, 8, -1, 1, 4)

    // Tri avec une lambda (ordre décroissant)
    triBulle(tableau1) { a, b -> a > b }
    println("Tri décroissant avec lambda : ${tableau1.joinToString()}")

    // Tri avec une fonction nommée (ordre croissant)
    triBulle(tableau2, ::comparerCroissant)
    // syntaxe équivalenteà
    triBulle(tableau2, { a, b -> comparerCroissant(a, b) })
    println("Tri croissant avec fonction nommée : ${tableau2.joinToString()}")
}
