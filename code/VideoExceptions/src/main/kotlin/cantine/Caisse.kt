package cantine

import java.lang.IllegalArgumentException

fun main() {
    println("Bienvenu à la cantine du département d'informatique!")
    obtenirPrix("Bonbon")
    println("Ka-ching!")
}

fun obtenirPrix(choix: String): Float {
    val prix: Float = calculerChoix(choix)
    println("Le prix est de $prix")
    return prix
}

fun calculerChoix(choix: String): Float {
    return when (choix) {
        "Hotdog" -> 2f
        "Hamburger" -> 3.5f
        "Poutine" -> 4f
        "Frite" -> 3f
        "Cola" -> 1.50f
        else -> {
            throw IllegalArgumentException()
        }
    }
}