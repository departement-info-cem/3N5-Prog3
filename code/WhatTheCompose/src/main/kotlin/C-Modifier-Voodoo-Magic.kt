package org.example

// Classe Café qui permet de chaîner les ajouts comme dans Jetpack Compose
class Café private constructor(
    private val ajouts: List<Pair<String, Double>>
) {
    constructor() : this(emptyList())

    fun creme(nb: Int): Café = Café(ajouts + List(nb) { "crème" to 0.5 })
    fun lait(nb: Int): Café = Café(ajouts + List(nb) { "lait" to 0.4 })
    fun vanilleFrancaise(nb: Int): Café = Café(ajouts + List(nb) { "vanille française" to 0.7 })
    fun sucre(nb: Int): Café = Café(ajouts + List(nb) { "sucre" to 0.2 })

    fun prix(): Double = 1.0 + ajouts.sumOf { it.second }

    override fun toString(): String {
        if (ajouts.isEmpty()) return "Café nature : 1.00\$CA"
        val desc = ajouts.groupingBy { it.first }.eachCount().entries.joinToString(", ") {
            if (it.value > 1) "${it.key} x${it.value}" else it.key
        }
        return "Café avec $desc : %.2f\$CA".format(prix())
    }

    companion object {
        fun creme(nb: Int): Café = Café().creme(nb)
        fun lait(nb: Int): Café = Café().lait(nb)
        fun vanilleFrancaise(nb: Int): Café = Café().vanilleFrancaise(nb)
        fun sucre(nb: Int): Café = Café().sucre(nb)
    }
}

fun main() {
    val cafe1 = Café.creme(2).sucre(4)
    println(cafe1) // Café avec crème x2, sucre x4 : 2.80$CA

    val cafe2 = Café.lait(3).vanilleFrancaise(1).sucre(2)
    println(cafe2) // Café avec lait x3, vanille française, sucre x2 : 3.10$CA

    val cafe3 = Café()
    println(cafe3) // Café nature : 1.00$CA
    println(cafe3.prix()) // 1.0
}
