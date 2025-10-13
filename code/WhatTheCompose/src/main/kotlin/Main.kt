package org.example

fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        println("i = $i")
    }
}
// Tout d'abord le nom de la fonction commence par une majuscule c'est un écart à la convention de kotlin
fun Contenant()
{   // cette accolade est le début du code de la function
    println("Contenant")
    Element1()
    Element2()
}

fun Element1() {

}

fun Element2() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Element2")
}