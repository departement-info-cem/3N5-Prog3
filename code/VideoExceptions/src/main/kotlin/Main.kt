package org.example

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

fun main(args: Array<String>) {

    println("Bienvenu dans le programme de lecture d'url!")

    val htmlLu: String = lireUrl(args[0])
    println(htmlLu)

    println("Au revoir!")
}

fun lireUrl(url: String): String {
    val connection: Document = Jsoup.connect(url).get()
    return connection.html()
}
