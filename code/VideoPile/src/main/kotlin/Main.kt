package org.example

fun main() {
    premierNiveau()
}

fun premierNiveau() {
    println("Je suis au premier niveau")
    deuxiemeNiveau()
}

fun deuxiemeNiveau() {
    val texte = "Je suis seulement disponible au niveau deux"
    println("Je suis au deuxième niveau")
    troisiemeNiveau()
}

fun troisiemeNiveau() {
    println("Je suis au troisième niveau")
    quatriemeNiveau()
}

fun quatriemeNiveau() {
    println("Je suis au quatrième niveau")
    for(i in 1..10) {
        println("Je l'élément $i")
        if(i == 7) {
            throw MaSuperException("Erreur sur l'élément 7")
        }
    }
}