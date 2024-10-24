package org.example

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.net.MalformedURLException
import java.net.UnknownHostException

fun main(args: Array<String>) {

    println("Bienvenu dans le programme de lecture d'url!")

    val htmlLu: String? = lireUrlTryCatch1(args[0])

    if(htmlLu != null) {
        println(htmlLu)
    }

    println("Au revoir!")
}

fun lireUrlTryCatch1(url: String): String? {
    try {
        val connection: Document = Jsoup.connect(url).get()
        return connection.html()
    } catch(e: UnknownHostException) {
        println("Aucun site web n'existe à cette adresse")
        return null
    } catch(e: MalformedURLException) {
        println("L'URL fournie est mal formée")
        return null
    }
}