package org.example

/**
 * Un des trucs perturbant en compose c'est la syntaxe
 * On pense qu'on appelle une méthode déjà écrite mais il semble qu'on lui donne
 * un bloc de code à exécuter
 */

// Démo de définition d'une fonction avec un trailing lambda
fun faireQuelqueChose(message: String, action: () -> Unit) {
    println("Avant l'action : $message")
    action()
    println("Après l'action")
}

fun main() {
    // Démo d'un appel avec le paramètre nommé
    faireQuelqueChose(message = "Appel avec paramètre nommé", action = { println("Action exécutée (paramètre nommé)") })

    // Démo d'un appel avec le bloc en {}
    faireQuelqueChose("Appel avec trailing lambda") {
        println("Action exécutée (trailing lambda)")
    }
}
